package com.zwl.offlineActivityOperatorManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OfflineActivityOperatorDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//ID
	private Integer id;
	//操作员手机
	private String operator;
	//密码
	private String password;
	//活动主题id
	private Integer activityThemeId;
	//商户号
	private String merchantId;
	//创建时间
	private Date createTime = new Date();
	//更新时间
	private Date modifyTime;
	//逻辑删除位
	private Integer available = 1;
	//活动主题名称
	private String themeName;
}
