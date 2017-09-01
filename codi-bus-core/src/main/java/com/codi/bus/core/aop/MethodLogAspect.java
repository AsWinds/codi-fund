package com.codi.bus.core.aop;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import com.alibaba.fastjson.JSON;
import com.codi.base.cache.CacheUtil;
import com.codi.base.log.desensitizer.DesensitizeModel;
import com.codi.base.log.desensitizer.Engine;
import com.codi.base.util.ExceptionUtil;
import com.codi.base.util.ListUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.constant.RuleConstant;
import com.codi.bus.core.domain.Lookup;
import com.codi.bus.core.service.LookupService;

public abstract class MethodLogAspect {

	private static Logger logger = LoggerFactory.getLogger(MethodLogAspect.class);

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Resource(name = "lookupService")
	private LookupService lookupService;

	/***
	 * 记录业务日志切面
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

		MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
		Method method = joinPointObject.getMethod();
		String methodName = method.getName();
		// 计算脱敏所耗时间
		long startTime = System.nanoTime();
		// 获取方法入参
		Object[] args = joinPoint.getArgs();
		// 执行方法
		Object result = joinPoint.proceed(args);
		long endTime = System.nanoTime();

		/**
		 * 记录业务日志
		 */
		try {

			String logString = extractLog(result, args, methodName, startTime, endTime);

			Logger customLogger = getLogger();
			if (customLogger == null) {
				customLogger = logger;
			}

			customLogger.info(logString);
		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "MethodLogAspect.around", exception);
		}

		return result;
	}

	protected abstract Logger getLogger();

	protected abstract String extractLog(Object result, Object[] args, String methodName, long startTime, long endTime);

	protected String getLogMap(Object response, String methodName, String url, Object request, Object requestHeaders,
			long startTime, long endTime) {

		// 获取脱敏的规则
		boolean clearMemory = false;
		String key = CacheUtil.getKey(GlobalConstant.REDIS_KEY_DESFD, "RULES");
		List<DesensitizeModel> desRules = (List<DesensitizeModel>) CacheUtil.getStrList(redisTemplate, key,
				DesensitizeModel.class);
		if (desRules == null) {
			desRules = getLookupList();
			clearMemory = true;
		}else {
			logger.debug("---使用Redis中脱敏规则列表, 规则个数：{}---", desRules.size());
		}
		// 用于记录请求日志
		Map<String, Object> map = new HashMap<>();

		// 执行API接口所耗费的时间
		map.put(GlobalConstant.KEY_API_COST_TIME, getCostTime(startTime, endTime));

		// 请求的URL
		map.put(GlobalConstant.KEY_API, url);

		// 请求的方法
		map.put(GlobalConstant.KEY_METHOD, methodName);

		// 请求的参数
		map.put(GlobalConstant.KEY_REQUEST, request);
		// 请求头
		map.put(GlobalConstant.KEY_REQUEST_HEADER, requestHeaders);

		// 返回的结果
		map.put(GlobalConstant.KEY_RESPONSE, response);

		String logString = Engine.desensitize(JSON.toJSONString(map), desRules, clearMemory);

		return logString;
	}

	/**
	 * 获取时间
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	protected String getCostTime(long startTime, long endTime) {
		return (endTime - startTime) / 1000 + "μs";
	}

	/**
	 * 获取脱敏规则列表
	 * 
	 * @return
	 */
	private List<DesensitizeModel> getLookupList() {
		try {

			logger.debug("---Begin:从数据库获取脱敏规则列表，并且存入Redis---");
			List<DesensitizeModel> list = new ArrayList<>();
			String key = CacheUtil.getKey(GlobalConstant.REDIS_KEY_DESFD, "RULES");

			List<Lookup> desExps = lookupService.getLookups(RuleConstant.RULE_LOOKUP_TYPE_DESEXP);
			List<Lookup> desFileds = lookupService.getLookups(RuleConstant.RULE_LOOKUP_TYPE_DESFD);
			if (ListUtil.isNotEmpty(desExps) && ListUtil.isNotEmpty(desFileds)) {
				for (Lookup lookup : desFileds) {
					String field = lookup.getRuleValue();
					String ruleCode = lookup.getRuleText();
					for (Lookup exp : desExps) {
						if (exp.getRuleValue().equals(ruleCode)) {
							DesensitizeModel item = new DesensitizeModel();
							// 正则表达式
							item.setExpression(exp.getRuleText());
							// 替换字符串
							item.setReplacement(exp.getComponentValue());
							// 字段名称
							item.setFieldName(field);
							// 字段类型
							item.setFieldType(exp.getRuleValue());
							// 加入列表
							list.add(item);
							break;
						}
					}
				}

				CacheUtil.setStrList(redisTemplate, key, list);
				
				logger.debug("---End:获取脱敏规则列表，并且存入Redis---");

				return list;
			}

		} catch (Exception exception) {
			ExceptionUtil.logError(logger, "MethodLogAspect getLookups error", exception);
		}

		return null;
	}
}
