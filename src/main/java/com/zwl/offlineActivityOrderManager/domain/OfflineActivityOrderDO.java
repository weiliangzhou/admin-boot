package com.zwl.offlineActivityOrderManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OfflineActivityOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单号
	private String orderNo;
	//开课城市id
	private Integer activityId;
	//线下课程id
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
	//开课城市
	private String activityAddress;
	//线下课程主题
	private String themeName;
	//订单类型 0:线下活动 1:线下沙龙
	private Integer orderType;
}
