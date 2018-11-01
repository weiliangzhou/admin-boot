package com.zwl.offlineActivityThemeManager.service;

import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeItemVo;

import java.util.List;
import java.util.Map;

public interface OfflineActivityThemeService {
	
	OfflineActivityThemeDO get(Integer id);
	
	List<OfflineActivityThemeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityThemeDO offlineActivityTheme);
	
	int update(OfflineActivityThemeDO offlineActivityTheme);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<OfflineActivityThemeItemVo> getActivityThemeItemsList(String merchantId, Integer activityType);

	Integer  getThemeIdByThemeName(String themeName);
}
