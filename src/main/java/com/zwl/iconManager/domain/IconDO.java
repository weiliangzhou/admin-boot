package com.zwl.iconManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 16:49:09
 */
@Data
public class IconDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// id
	private Integer id;
	//图标名称
	private String title;
	//图标
	private String pictureUrl;
	//图标跳转地址
	private String hrefUrl;
	//图标跳转类型
	private Integer hrefType;
	//是否可用
	private Integer available = 1;
	//商户号
	private String merchantId;
	//创建时间
	private Date createTime = new Date();
	//修改时间
	private Date modifyTime;
	//端口类型
	private Integer portType;
}
