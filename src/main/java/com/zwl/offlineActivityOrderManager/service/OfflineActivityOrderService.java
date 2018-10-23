package com.zwl.offlineActivityOrderManager.service;

import com.zwl.offlineActivityOrderManager.domain.OfflineActivityOrderDO;

import java.util.List;
import java.util.Map;

public interface OfflineActivityOrderService {
	
	OfflineActivityOrderDO get(String orderNo);
	
	List<OfflineActivityOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityOrderDO offlineActivityOrder);
	
	int update(OfflineActivityOrderDO offlineActivityOrder);
	
	int remove(String orderNo);
	
	int batchRemove(String[] orderNos);
	//根据themeId查询该场线下活动主题的订单人数
    Integer selectOrderCountByThemeId(Integer activityThemeId);
	//根据activityId查询该场活动的订单人数
    Integer selectOrderCountByActivityId(Integer activityId);
}
