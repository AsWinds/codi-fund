package com.codi.bus.core.service;

import com.codi.bus.core.domain.UserPrivateequity;
import com.codi.bus.core.resultModel.PaperInfoTestResult;

/**
 * 私募扩展信息服务类
 * @author Shangdu Lin
 *
 * @date 2017年1月9日 下午8:30:36
 */
public interface UserPrivateequityService {

	/**
	 * 查询用户的私募信息
	 * @param userId
	 * @return
	 */
	UserPrivateequity getByUserId(Long userId);

	/**
	 * 更新是否为合格投资者
	 * @param userId
	 * @param isQualified
	 */
	void updateQualifiedInvester(Long userId, boolean isQualified);

    /**
     * 新增扩展信息
     * @param userId
     * @param isQualified
     */
	void addOrUpdate(Long userId, boolean isQualified);

    /**
     * 判断用户是否做过风险测评
     * @param userId
     * @return
     */
    PaperInfoTestResult getTestResult(Long userId);

    /**
     * 提交风险测评
     * @param answers
     * @return
     */
    PaperInfoTestResult commitAnswers(Long userId,String answers);

    /**
     * 更新风险测评结果
     * @param userId
     * @param paperId
     * @param riskTolerance
     */
    void updateRiskTolerance(Long userId, String paperId, String riskTolerance);
}
