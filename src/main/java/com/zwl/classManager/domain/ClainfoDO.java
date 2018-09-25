package com.zwl.classManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
@Data
public class ClainfoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//所属套课id
	private Integer classSetId;
	//如果节课程没有所属的套课，则存category_id
	private Integer categoryId;
	//所属商户id
	private String merchantId;
	//音频url
	private String audioUrl;
	//
	private String logoUrl;
	//
	private String title;
	//
	private String content;
	//该字段 是否发布状态 默认0不发布 1发布
	private Long isShow;
	//收听人数
	private Long listenCount;
	//
	private Date createTime = new Date();
	//
	private Date modifyTime;
	//
	private Integer available = 1;
	//不带格式的介绍
	private String contentText;
	//
	private Integer style;
	//
	private Integer isRecommend;
	//
	private Integer playTime;
	//时长分
	private Integer minute;
	//时长秒
	private Integer second;

	private String playTimeDesc;
	//套课名称
	private String claSetName;
	//分类名称
	private String categoryName;



	public String getPlayTimeDesc() {
		return playTime == null ? "0分0秒" : playTime/60 +"分"+ playTime%60 +"秒";
	}

}
