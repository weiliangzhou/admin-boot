package com.zwl.offlineActivityOrderManager.service.impl;

import com.zwl.offlineActivityOrderManager.dao.OfflineActivityOrderMapper;
import com.zwl.offlineActivityOrderManager.domain.OfflineActivityOrderDO;
import com.zwl.offlineActivityOrderManager.service.OfflineActivityOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfflineActivityOrderServiceImpl implements OfflineActivityOrderService {
	@Autowired
	private OfflineActivityOrderMapper offlineActivityOrderMapper;
	
	@Override
	public OfflineActivityOrderDO get(String orderNo){
		return offlineActivityOrderMapper.get(orderNo);
	}
	
	@Override
	public List<OfflineActivityOrderDO> list(Map<String, Object> map){
		return offlineActivityOrderMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offlineActivityOrderMapper.count(map);
	}
	
	@Override
	public int save(OfflineActivityOrderDO offlineActivityOrder){
		return offlineActivityOrderMapper.save(offlineActivityOrder);
	}
	
	@Override
	public int update(OfflineActivityOrderDO offlineActivityOrder){
		return offlineActivityOrderMapper.update(offlineActivityOrder);
	}
	
	@Override
	public int remove(String orderNo){
		return offlineActivityOrderMapper.remove(orderNo);
	}
	
	@Override
	public int batchRemove(String[] orderNos){
		return offlineActivityOrderMapper.batchRemove(orderNos);
	}

	@Override
	public Integer selectOrderCountByThemeId(Integer activityThemeId) {
		return offlineActivityOrderMapper.selectOrderCountByThemeId(activityThemeId);
	}

}
