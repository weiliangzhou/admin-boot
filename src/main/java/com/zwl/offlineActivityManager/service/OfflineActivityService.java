package com.zwl.offlineActivityManager.service;

import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityVo;

import java.util.List;
import java.util.Map;

public interface OfflineActivityService {
	
	OfflineActivityDO get(Integer id);
	
	List<OfflineActivityDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityDO offlineActivity);
	
	int update(OfflineActivityDO offlineActivity);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

    List<OfflineActivityVo> getActivityItemsList(String merchantId, Integer activityThemeId);

	String selectThemeNameByThemeId(Integer activityThemeId);
	//根据themeId查询该课程主题下有哪些开课城市，限制查询两个
    List<String> selectActivityAddressByThemeId(Integer activityThemeId);

//	String selectActivityAddressByActivityParentId(Integer activityParentId);
}
