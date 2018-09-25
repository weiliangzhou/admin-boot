package com.zwl.orderManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 10:28:37
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String orderNo;
	//
	private Long productId;
	//
	private String productName;
	//实际支付金额
	private Integer actualMoney;
	//订单金额按照分为单位存储
	private Integer money;
	//
	private Integer maidPercent;
	//支付方式：目前只支持微信1
	private Integer payWay;
	//
	private Integer level;
	//
	private String levelName;
	//有效期，天为单位
	private Integer validityTime;
	//订单状态  0待支付 1成功  -1超时关闭
	private Integer orderStatus;
	//
	private String userId;
	//
	private String merchantId;
	//手机号
	private String phone;
	//下单人
	private String realName;
	//微信支付订单号
	private String paymentNo;
	//微信到账成功实践
	private Date paymentTime;
	//收货地址
	private String address;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;

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
	 * 设置：
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	/**
	 * 获取：
	 */
	public Long getProductId() {
		return productId;
	}
	/**
	 * 设置：
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：
	 */
	public String getProductName() {
		return productName;
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
	 * 设置：订单金额按照分为单位存储
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}
	/**
	 * 获取：订单金额按照分为单位存储
	 */
	public Integer getMoney() {
		return money;
	}
	/**
	 * 设置：
	 */
	public void setMaidPercent(Integer maidPercent) {
		this.maidPercent = maidPercent;
	}
	/**
	 * 获取：
	 */
	public Integer getMaidPercent() {
		return maidPercent;
	}
	/**
	 * 设置：支付方式：目前只支持微信1
	 */
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	/**
	 * 获取：支付方式：目前只支持微信1
	 */
	public Integer getPayWay() {
		return payWay;
	}
	/**
	 * 设置：
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * 获取：
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * 设置：有效期，天为单位
	 */
	public void setValidityTime(Integer validityTime) {
		this.validityTime = validityTime;
	}
	/**
	 * 获取：有效期，天为单位
	 */
	public Integer getValidityTime() {
		return validityTime;
	}
	/**
	 * 设置：订单状态  0待支付 1成功  -1超时关闭
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态  0待支付 1成功  -1超时关闭
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
	 * 设置：
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	/**
	 * 获取：
	 */
	public String getMerchantId() {
		return merchantId;
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
	 * 设置：下单人
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**
	 * 获取：下单人
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * 设置：微信支付订单号
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}
	/**
	 * 获取：微信支付订单号
	 */
	public String getPaymentNo() {
		return paymentNo;
	}
	/**
	 * 设置：微信到账成功实践
	 */
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	/**
	 * 获取：微信到账成功实践
	 */
	public Date getPaymentTime() {
		return paymentTime;
	}
	/**
	 * 设置：收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：收货地址
	 */
	public String getAddress() {
		return address;
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
}
