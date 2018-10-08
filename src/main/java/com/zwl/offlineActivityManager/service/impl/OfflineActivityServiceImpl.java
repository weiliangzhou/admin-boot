package com.zwl.offlineActivityManager.service.impl;

import com.zwl.offlineActivityManager.dao.OfflineActivityMapper;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityVo;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfflineActivityServiceImpl implements OfflineActivityService {
	@Autowired
	private OfflineActivityMapper offlineActivityMapper;
	
	@Override
	public OfflineActivityDO get(Integer id){
		return offlineActivityMapper.get(id);
	}
	
	@Override
	public List<OfflineActivityDO> list(Map<String, Object> map){
		return offlineActivityMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offlineActivityMapper.count(map);
	}
	
	@Override
	public int save(OfflineActivityDO offlineActivity){
		return offlineActivityMapper.save(offlineActivity);
	}
	
	@Override
	public int update(OfflineActivityDO offlineActivity){
		return offlineActivityMapper.update(offlineActivity);
	}
	
	@Override
	public int remove(Integer id){
		return offlineActivityMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return offlineActivityMapper.batchRemove(ids);
	}

	@Override
	public List<OfflineActivityVo> getActivityItemsList(String merchantId, Integer activityThemeId) {
		return offlineActivityMapper.getActivityItemsList(merchantId,activityThemeId);
	}

	@Override
	public String selectThemeNameByThemeId(Integer activityThemeId) {
		return offlineActivityMapper.selectThemeNameByThemeId(activityThemeId);
	}

	@Override
	public String selectActivityAddressByActivityParentId(Integer activityParentId) {
		return offlineActivityMapper.selectActivityAddressByActivityParentId(activityParentId);
	}

}
