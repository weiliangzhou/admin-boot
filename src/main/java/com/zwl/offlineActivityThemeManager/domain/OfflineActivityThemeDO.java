package com.zwl.offlineActivityThemeManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class OfflineActivityThemeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//主题名称
	private String themeName;
	//跳转地址
	private Integer themeHrefUrl;
	//类型 0图片 1视频
	private Integer themeType;
	//
	private String content;
	//
	private String contentText;
	//
	private Date createTime = new Date();
	//
	private Date modifyTime;
	//
	private Integer available =1;
	//
	private String merchantId;
}
