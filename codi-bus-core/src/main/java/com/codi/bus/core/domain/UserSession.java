package com.codi.bus.core.domain;

import java.util.Date;

public class UserSession {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_user_session_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private Long userSessionId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.ur_user_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private Long userId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_channel_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private String channelId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_device_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private String deviceId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_login_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private Date loginTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_expire_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private Date expireTime;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column us_user_session.us_token
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	private String token;

	private String ip;

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIp() {
		return this.ip;
	}

	private Long userSessionHistoryId;

	public Long getUserSessionHistoryId() {
		return userSessionHistoryId;
	}

	public void setUserSessionHistoryId(Long userSessionHistoryId) {
		this.userSessionHistoryId = userSessionHistoryId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_user_session_id
	 *
	 * @return the value of us_user_session.us_user_session_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public Long getUserSessionId() {
		return userSessionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_user_session_id
	 *
	 * @param usUserSessionId
	 *            the value for us_user_session.us_user_session_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setUserSessionId(Long userSessionId) {
		this.userSessionId = userSessionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.ur_user_id
	 *
	 * @return the value of us_user_session.ur_user_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.ur_user_id
	 *
	 * @param urUserId
	 *            the value for us_user_session.ur_user_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_channel_id
	 *
	 * @return the value of us_user_session.us_channel_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public String getChannelId() {
		return channelId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_channel_id
	 *
	 * @param channelId
	 *            the value for us_user_session.us_channel_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setChannelId(String channelId) {
		this.channelId = channelId == null ? null : channelId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_device_id
	 *
	 * @return the value of us_user_session.us_device_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public String getDeviceId() {
		return deviceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_device_id
	 *
	 * @param deviceId
	 *            the value for us_user_session.us_device_id
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId == null ? null : deviceId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_login_time
	 *
	 * @return the value of us_user_session.us_login_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public Date getLoginTime() {
		return loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_login_time
	 *
	 * @param usLoginTime
	 *            the value for us_user_session.us_login_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_expire_time
	 *
	 * @return the value of us_user_session.us_expire_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public Date getExpireTime() {
		return expireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_expire_time
	 *
	 * @param usExpireTime
	 *            the value for us_user_session.us_expire_time
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column us_user_session.us_token
	 *
	 * @return the value of us_user_session.us_token
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public String getToken() {
		return token;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column us_user_session.us_token
	 *
	 * @param token
	 *            the value for us_user_session.us_token
	 *
	 * @mbggenerated Thu Aug 18 14:52:53 CST 2016
	 */
	public void setToken(String token) {
		this.token = token == null ? null : token.trim();
	}
}