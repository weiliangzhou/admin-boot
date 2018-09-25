package com.zwl.bannerManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-03 09:55:26
 */
@Data
public class BannerDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//图片路径
	private String imageUrl;
	//跳转路径
	private String hrefUrl;
	//跳转类型
	private Integer hrefType;
	//banner主题
	private String theme;
	//排序号
	private Integer queueNumber;
	//说明
	private String description;
	//创建时间
	private Date createTime = new Date();
	//修改时间
	private Date modifyTime;
	//逻辑删除
	private Integer available = 1;
	//商户id
	private String merchantId;
	//是否展示
	private Integer isShow;
	//端口类型
	private Integer portType;
}
