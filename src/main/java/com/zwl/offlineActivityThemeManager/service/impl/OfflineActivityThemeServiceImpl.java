package com.zwl.offlineActivityThemeManager.service.impl;

import com.zwl.offlineActivityThemeManager.dao.OfflineActivityThemeMapper;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeItemVo;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfflineActivityThemeServiceImpl implements OfflineActivityThemeService {
	@Autowired
	private OfflineActivityThemeMapper offlineActivityThemeMapper;
	
	@Override
	public OfflineActivityThemeDO get(Integer id){
		return offlineActivityThemeMapper.get(id);
	}
	
	@Override
	public List<OfflineActivityThemeDO> list(Map<String, Object> map){
		return offlineActivityThemeMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offlineActivityThemeMapper.count(map);
	}
	
	@Override
	public int save(OfflineActivityThemeDO offlineActivityTheme){
		return offlineActivityThemeMapper.save(offlineActivityTheme);
	}
	
	@Override
	public int update(OfflineActivityThemeDO offlineActivityTheme){
		return offlineActivityThemeMapper.update(offlineActivityTheme);
	}
	
	@Override
	public int remove(Integer id){
		return offlineActivityThemeMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return offlineActivityThemeMapper.batchRemove(ids);
	}

	@Override
	public List<OfflineActivityThemeItemVo> getActivityThemeItemsList(String merchantId, Integer activityType) {
		return offlineActivityThemeMapper.getActivityThemeItemsList(merchantId,activityType);
	}

	@Override
	public Integer getThemeIdByThemeName(String themeName){
		return offlineActivityThemeMapper.getThemeIdByThemeName(themeName);
	}

}
