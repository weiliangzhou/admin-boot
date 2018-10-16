package com.zwl.maidPercentManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-16 16:13:41
 */
public class UserMaidPercentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//等级
	private Integer memberLevel;
	//学员分佣比例
	private Integer maidPercent1;
	//VIP学员分佣比例
	private Integer maidPercent4;
	//院长分佣比例
	private Integer maidPercent6;
	//
	private String merchantId;
	//
	private Date createTime;
	//
	private Date modifyTime;
	//
	private Integer available;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：等级
	 */
	public void setMemberLevel(Integer memberLevel) {
		this.memberLevel = memberLevel;
	}
	/**
	 * 获取：等级
	 */
	public Integer getMemberLevel() {
		return memberLevel;
	}
	/**
	 * 设置：学员分佣比例
	 */
	public void setMaidPercent1(Integer maidPercent1) {
		this.maidPercent1 = maidPercent1;
	}
	/**
	 * 获取：学员分佣比例
	 */
	public Integer getMaidPercent1() {
		return maidPercent1;
	}
	/**
	 * 设置：VIP学员分佣比例
	 */
	public void setMaidPercent4(Integer maidPercent4) {
		this.maidPercent4 = maidPercent4;
	}
	/**
	 * 获取：VIP学员分佣比例
	 */
	public Integer getMaidPercent4() {
		return maidPercent4;
	}
	/**
	 * 设置：院长分佣比例
	 */
	public void setMaidPercent6(Integer maidPercent6) {
		this.maidPercent6 = maidPercent6;
	}
	/**
	 * 获取：院长分佣比例
	 */
	public Integer getMaidPercent6() {
		return maidPercent6;
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
