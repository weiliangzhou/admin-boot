package com.zwl.offlineSalonActivityOrderManager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zwl.offlineSalonActivityOrderManager.dao.OfflineSalonActivityOrderMapper;
import com.zwl.offlineSalonActivityOrderManager.domain.OfflineSalonActivityOrderDO;
import com.zwl.offlineSalonActivityOrderManager.service.OfflineSalonActivityOrderService;



@Service
public class OfflineSalonActivityOrderServiceImpl implements OfflineSalonActivityOrderService {
	@Autowired
	private OfflineSalonActivityOrderMapper offlineSalonActivityOrderMapper;
	
	@Override
	public OfflineSalonActivityOrderDO get(String orderNo){
		return offlineSalonActivityOrderMapper.get(orderNo);
	}
	
	@Override
	public List<OfflineSalonActivityOrderDO> list(Map<String, Object> map){
		return offlineSalonActivityOrderMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return offlineSalonActivityOrderMapper.count(map);
	}
	
	@Override
	public int save(OfflineSalonActivityOrderDO offlineSalonActivityOrder){
		return offlineSalonActivityOrderMapper.save(offlineSalonActivityOrder);
	}
	
	@Override
	public int update(OfflineSalonActivityOrderDO offlineSalonActivityOrder){
		return offlineSalonActivityOrderMapper.update(offlineSalonActivityOrder);
	}
	
	@Override
	public int remove(String orderNo){
		return offlineSalonActivityOrderMapper.remove(orderNo);
	}
	
	@Override
	public int batchRemove(String[] orderNos){
		return offlineSalonActivityOrderMapper.batchRemove(orderNos);
	}
	
}
