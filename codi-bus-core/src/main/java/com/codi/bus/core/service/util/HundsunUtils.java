package com.codi.bus.core.service.util;

import java.util.List;
import java.util.Map;

import com.codi.base.util.StringUtil;
import com.codi.bus.constant.GlobalConstant;
import com.codi.bus.core.resultModel.BaseResult;
import com.codi.fcloud.ufx.constant.HSOutputParameterNames;
import com.codi.message.constant.ErrorConstant;

/***
 * 用于处理恒生的返回结果
 * 
 * @author Shangdu Lin
 *
 */
public class HundsunUtils {

	/***
	 * 获取查询结果列表 target & result 肯定是不为空的，在本方法内就不做检查了
	 * 
	 * @param source
	 * @param target
	 * @param result
	 */
	@SuppressWarnings("unchecked")
	public static void ConvertToList(Map<String, Object> source, List<Map<String, Object>> target, BaseResult result) {

		// 转换， 这一步强制转换是没有问题的，因为放入map时就是这个类型
		List<Map<String, Object>> list = (List<Map<String, Object>>) source.get(GlobalConstant.KEY_LIST_MAP);
		target.addAll(list);

		// 判断是否有错误
		if (target.size() > 0) {
			// 获取第一个元素
			Map<String, Object> map = target.get(0);
			boolean isFail = false;

			// 不能使用error_code来判断，查询不出数据时error_cde也不为空
			// "error_info":"HS_QUERY-9K: 总记录数为0!"
			// {"error_code":"1000","error_info":"HS_QUERY-34:总记录数为0","success_type":"0"}
			// {"data":[{"success_type":"1","e-contract_flag":"","error_code":"1000","error_info":"返回记录长度小于349","fund_code":"","fund_name":""
			/*
			 * 0-成功 1-系统级错误 2-应用级错误 3-业务级错误
			 */
			if (map.containsKey(HSOutputParameterNames.SUCCESS_TYPE)
					&& map.get(HSOutputParameterNames.SUCCESS_TYPE) != null) {
				String successType = map.get(HSOutputParameterNames.SUCCESS_TYPE).toString();
				if (!StringUtil.isEmpty(successType) && !successType.equals("0")) {
					isFail = true;
				}
			}

			// {"error_code":"1","error_info":"转发错误","error_no":"1"}
			if (!isFail && map.containsKey(HSOutputParameterNames.ERROR_NO)
					&& map.get(HSOutputParameterNames.ERROR_NO) != null) {
				String errorNo = map.get(HSOutputParameterNames.ERROR_NO).toString();
				if (!StringUtil.isEmpty(errorNo)) {
					isFail = true;
				}
			}			

			if (isFail) {

				String errorMessage = "";
				if (map.containsKey(HSOutputParameterNames.ERROR_INFO)
						&& map.get(HSOutputParameterNames.ERROR_INFO) != null) {
					errorMessage = map.get(HSOutputParameterNames.ERROR_INFO).toString();
				}
				result.setSuccess(false);
				result.setErrorType(GlobalConstant.ERROR_TYPE_SYSTEM);
				result.setErrorCode(ErrorConstant.ERROR_HUNDSUNAPI_WRONG);
				result.setErrorMessage(errorMessage);

				return;
			}
		}

		result.setSuccess(true);
	}
}
