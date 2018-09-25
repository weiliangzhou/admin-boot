package com.zwl.videoManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 11:15:51
 */
@Data
public class VideoDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//视频图片地址
	private String imageUrl;
	//视频地址
	private String videoUrl;
	//视频标题
	private String title;
	//商品介绍（带格式）
	private String content;
	//商品介绍（不带格式）
	private String contentText;
	//视频时长
	private Integer playTime;
	//商户号
	private String merchantId;
	//创建时间
	private Date createTime = new Date();
	//修改时间
	private Date modifyTime;
	//是否可用
	private Integer available = 1;
	//是否推荐，0不推荐，1推荐
	private Integer isRecommend;
	//是否展示，0不展示，1展示
	private Integer isShow;
	//时长分
	private Integer minute;
	//时长秒
	private Integer second;

	private String playTimeDesc;

	public String getPlayTimeDesc() {
		return playTime == null ? "0分0秒" : playTime/60 +"分"+ playTime%60 +"秒";
	}
}
