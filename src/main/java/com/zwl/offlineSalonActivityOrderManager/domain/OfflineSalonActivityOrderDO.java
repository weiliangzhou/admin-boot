package com.zwl.offlineSalonActivityOrderManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-01 09:43:24
 */
@Data
public class OfflineSalonActivityOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String orderNo;
	//线下活动id
	private Integer activityId;
	//主题id
	private Integer activityThemeId;
	//活动消费码
	private String activityCode;
	//活动费用
	private Integer activityPrice;
	//实际支付金额
	private Integer actualMoney;
	//0待支付 1支付成功 -1超时
	private Integer orderStatus;
	//
	private String userId;
	//0男 1女
	private Integer sex;
	//手机号
	private String phone;
	//真实姓名
	private String realName;
	//所在城市
	private String city;
	//身份证号码
	private String idCardNum;
	//支付流水号
	private String paymentNo;
	//支付时间
	private Date paymentTime;
	//商户号
	private String merchantId;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;
	//是否返佣，0不返佣，1返佣
	private Integer isMaid;
	//是否复训 0不是1是
	private Integer isRetraining;
	//推荐人UUID
	private String slReferrer;
	//订单类型 0:线下活动 1:线下沙龙
	private Integer orderType;
	//文本输入没什么意思
	private String wechatNo;
	//线下活动时间
	private Date activityDate;
	//开课城市
	private String activityAddress;
	//线下课程主题
	private String themeName;
	//邀约人手机号
	private String slReferrerPhone;
	//邀约人姓名
	private String slReferrerName;

	/**
	 * 设置：
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：线下活动id
	 */
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	/**
	 * 获取：线下活动id
	 */
	public Integer getActivityId() {
		return activityId;
	}
	/**
	 * 设置：主题id
	 */
	public void setActivityThemeId(Integer activityThemeId) {
		this.activityThemeId = activityThemeId;
	}
	/**
	 * 获取：主题id
	 */
	public Integer getActivityThemeId() {
		return activityThemeId;
	}
	/**
	 * 设置：活动消费码
	 */
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}
	/**
	 * 获取：活动消费码
	 */
	public String getActivityCode() {
		return activityCode;
	}
	/**
	 * 设置：活动费用
	 */
	public void setActivityPrice(Integer activityPrice) {
		this.activityPrice = activityPrice;
	}
	/**
	 * 获取：活动费用
	 */
	public Integer getActivityPrice() {
		return activityPrice;
	}
	/**
	 * 设置：实际支付金额
	 */
	public void setActualMoney(Integer actualMoney) {
		this.actualMoney = actualMoney;
	}
	/**
	 * 获取：实际支付金额
	 */
	public Integer getActualMoney() {
		return actualMoney;
	}
	/**
	 * 设置：0待支付 1支付成功 -1超时
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：0待支付 1支付成功 -1超时
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：0男 1女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：0男 1女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：所在城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所在城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：身份证号码
	 */
	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}
	/**
	 * 获取：身份证号码
	 */
	public String getIdCardNum() {
		return idCardNum;
	}
	/**
	 * 设置：支付流水号
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	/**
	 * 获取：支付流水号
	 */
	public String getPaymentNo() {
		return paymentNo;
	}
	/**
	 * 设置：支付时间
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}
	/**
	 * 设置：商户号
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：商户号
	 */
	public String getMerchantId() {
		return merchantId;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Date getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}
	/**
	 * 获取：
	 */
	public Integer getAvailable() {
		return available;
	}
	/**
	 * 设置：是否返佣，0不返佣，1返佣
	 */
	public void setIsMaid(Integer isMaid) {
		this.isMaid = isMaid;
	}
	/**
	 * 获取：是否返佣，0不返佣，1返佣
	 */
	public Integer getIsMaid() {
		return isMaid;
	}
	/**
	 * 设置：是否复训 0不是1是
	 */
	public void setIsRetraining(Integer isRetraining) {
		this.isRetraining = isRetraining;
	}
	/**
	 * 获取：是否复训 0不是1是
	 */
	public Integer getIsRetraining() {
		return isRetraining;
	}
	/**
	 * 设置：推荐人UUID
	 */
	public void setSlReferrer(String slReferrer) {
		this.slReferrer = slReferrer;
	}
	/**
	 * 获取：推荐人UUID
	 */
	public String getSlReferrer() {
		return slReferrer;
	}
	/**
	 * 设置：订单类型 0:线下活动 1:线下沙龙
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型 0:线下活动 1:线下沙龙
	 */
	public Integer getOrderType() {
		return orderType;
	}
	/**
	 * 设置：文本输入没什么意思
	 */
	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}
	/**
	 * 获取：文本输入没什么意思
	 */
	public String getWechatNo() {
		return wechatNo;
	}
	/**
	 * 设置：线下活动时间
	 */
	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}
	/**
	 * 获取：线下活动时间
	 */
	public Date getActivityDate() {
		return activityDate;
	}
}
