package com.zwl.offlineActivityOperatorManager.service;

import com.zwl.offlineActivityOperatorManager.domain.OfflineActivityOperatorDO;

import java.util.List;
import java.util.Map;

public interface OfflineActivityOperatorService {
	
	OfflineActivityOperatorDO get(Integer id);
	
	List<OfflineActivityOperatorDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OfflineActivityOperatorDO offlineActivityOperator);
	
	int update(OfflineActivityOperatorDO offlineActivityOperator);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
