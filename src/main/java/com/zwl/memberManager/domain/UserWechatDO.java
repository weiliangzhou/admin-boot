package com.zwl.memberManager.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户绑定微信账号 
(目前微信账号是手输的    why)
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-12 16:27:50
 */
public class UserWechatDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//微信账号
	private String wechatAccount;
	//关联账号
	private String userId;
	//
	private Date createTime;
	//
	private Date modifyTime;

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
	 * 设置：微信账号
	 */
	public void setWechatAccount(String wechatAccount) {
		this.wechatAccount = wechatAccount;
	}
	/**
	 * 获取：微信账号
	 */
	public String getWechatAccount() {
		return wechatAccount;
	}
	/**
	 * 设置：关联账号
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：关联账号
	 */
	public String getUserId() {
		return userId;
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
}
