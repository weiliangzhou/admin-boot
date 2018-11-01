package com.zwl.offlineActivityManager.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class OfflineActivityDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//活动地点
	private String activityAddress;
	//活动开始时间
	private Date activityStartTime;
	//活动结束时间
	private Date activityEndTime;
	//价格
	private Integer activityPrice;
	//是否复训 0不是1是
	private Integer isRetraining;
	//活动主题id
	private Integer activityThemeId;
	//上个活动的id
//	private Integer activityParentId;
	//容纳人数
	private Integer limitCount;
	//购买人数
	private Integer buyCount;
	//是否推荐，0不推荐，1推荐
	private Integer isRecommend;
	//是否展示，0不展示，1展示
	private Integer isShow;
	//是否可用重复购买,0不可用,1可以
	private Integer isRebuy;
	//是否返佣，0不返佣，1返佣
	private Integer isMaid;
	//购买最低要求
	private Integer minRequirement;
	//商户号
	private String merchantId;
	//创建时间
	private Date createTime = new Date();
	//更新时间
	private Date modifyTime;
	//逻辑删除位
	private Integer available = 1;
	//开始时间
	private String activityStartTimeDesc;
	//结束时间
	private String activityEndTimeDesc;
	//活动主题
	private String activityTheme;
	//上个活动
	private String activityParent;
	//报名开始时间
	private Date applyStartTime;
	//报名结束时间
	private Date applyEndTime;
	//复训价格
	private Integer retrainingPrice;
	//报名开始时间
	private String applyStartTimeDesc;
	//报名结束时间
	private String applyEndTimeDesc;
	//价格
	private Double activityPriceDesc;
	//复训价格
	private Double retrainingPriceDesc;
	//订单购买人数
	private Integer orderCount;
	//类型 0线下课程 1沙龙
	private Integer activityType;
}
