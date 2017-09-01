package com.codi.bus.core.domain;

import com.codi.base.util.DateUtils;

import java.util.Date;

public class PEAppointment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_appointment_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Long appointmentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_client_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private String clientName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_client_mobile
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private String clientMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pp_product_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Long productId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pp_product_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private String productName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_appointment_time
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Date appointmentTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_is_valid
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Boolean isValid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_create_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_create_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private String createUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_last_update_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private Date lastUpdateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pa_peappointment.pa_last_update_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    private String lastUpdateUserId;

    private Integer productStatus;

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_appointment_id
     *
     * @return the value of pa_peappointment.pa_appointment_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Long getAppointmentId() {
        return appointmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_appointment_id
     *
     * @param appointmentId the value for pa_peappointment.pa_appointment_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_client_name
     *
     * @return the value of pa_peappointment.pa_client_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_client_name
     *
     * @param clientName the value for pa_peappointment.pa_client_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setClientName(String clientName) {
        this.clientName = clientName == null ? null : clientName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_client_mobile
     *
     * @return the value of pa_peappointment.pa_client_mobile
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public String getClientMobile() {
        return clientMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_client_mobile
     *
     * @param clientMobile the value for pa_peappointment.pa_client_mobile
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setClientMobile(String clientMobile) {
        this.clientMobile = clientMobile == null ? null : clientMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pp_product_id
     *
     * @return the value of pa_peappointment.pp_product_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pp_product_id
     *
     * @param ppProductId the value for pa_peappointment.pp_product_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pp_product_name
     *
     * @return the value of pa_peappointment.pp_product_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public String getProductName() {
        return productName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pp_product_name
     *
     * @param ppProductName the value for pa_peappointment.pp_product_name
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_appointment_time
     *
     * @return the value of pa_peappointment.pa_appointment_time
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public String getAppointmentTimeString() {
        if(this.appointmentTime!=null) {
            return DateUtils.formatDateTime(appointmentTime);
        }

        return "";
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_appointment_time
     *
     * @param appointmentTime the value for pa_peappointment.pa_appointment_time
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_is_valid
     *
     * @return the value of pa_peappointment.pa_is_valid
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Boolean getIsValid() {
        return isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_is_valid
     *
     * @param isValid the value for pa_peappointment.pa_is_valid
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_create_date
     *
     * @return the value of pa_peappointment.pa_create_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_create_date
     *
     * @param createDate the value for pa_peappointment.pa_create_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_create_user_id
     *
     * @return the value of pa_peappointment.pa_create_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_create_user_id
     *
     * @param createUserId the value for pa_peappointment.pa_create_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId == null ? null : createUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_last_update_date
     *
     * @return the value of pa_peappointment.pa_last_update_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_last_update_date
     *
     * @param lastUpdateDate the value for pa_peappointment.pa_last_update_date
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pa_peappointment.pa_last_update_user_id
     *
     * @return the value of pa_peappointment.pa_last_update_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public String getLastUpdateUserId() {
        return lastUpdateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pa_peappointment.pa_last_update_user_id
     *
     * @param lastUpdateUserId the value for pa_peappointment.pa_last_update_user_id
     *
     * @mbggenerated Mon Jan 09 22:39:20 CST 2017
     */
    public void setLastUpdateUserId(String lastUpdateUserId) {
        this.lastUpdateUserId = lastUpdateUserId == null ? null : lastUpdateUserId.trim();
    }
}
