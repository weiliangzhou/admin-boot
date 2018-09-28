package com.zwl.offlineActivityOperatorManager.service.impl;

import com.zwl.offlineActivityOperatorManager.dao.OfflineActivityOperatorMapper;
import com.zwl.offlineActivityOperatorManager.domain.OfflineActivityOperatorDO;
import com.zwl.offlineActivityOperatorManager.service.OfflineActivityOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OfflineActivityOperatorServiceImpl implements OfflineActivityOperatorService {
	@Autowired
	private OfflineActivityOperatorMapper offlineActivityOperatorMapper;
	
	@Override
	public OfflineActivityOperatorDO get(Integer id){
		return offlineActivityOperatorMapper.get(id);
	}
	
	@Override
	public List<OfflineActivityOperatorDO> list(Map<String, Object> map){
		return offlineActivityOperatorMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offlineActivityOperatorMapper.count(map);
	}
	
	@Override
	public int save(OfflineActivityOperatorDO offlineActivityOperator){
		return offlineActivityOperatorMapper.save(offlineActivityOperator);
	}
	
	@Override
	public int update(OfflineActivityOperatorDO offlineActivityOperator){
		return offlineActivityOperatorMapper.update(offlineActivityOperator);
	}
	
	@Override
	public int remove(Integer id){
		return offlineActivityOperatorMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return offlineActivityOperatorMapper.batchRemove(ids);
	}
	
}
