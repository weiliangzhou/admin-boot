package com.zwl.orderManager.service;

import com.zwl.orderManager.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 10:28:37
 */
public interface OrderService {
	
	OrderDO get(String orderNo);
	
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(String orderNo);
	
	int batchRemove(String[] orderNos);

    OrderDO getOrderByLevelAndUserId(Integer productLevel, String userId);
}
