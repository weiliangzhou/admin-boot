package com.zwl.offlineSalonActivityOrderManager.service;

import com.zwl.offlineSalonActivityOrderManager.domain.OfflineSalonActivityOrderDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-01 09:43:24
 */
public interface OfflineSalonActivityOrderService {
	
	OfflineSalonActivityOrderDO get(String orderNo);
	
	List<OfflineSalonActivityOrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineSalonActivityOrderDO offlineActivityOrder);
	
	int update(OfflineSalonActivityOrderDO offlineActivityOrder);
	
	int remove(String orderNo);
	
	int batchRemove(String[] orderNos);
}
