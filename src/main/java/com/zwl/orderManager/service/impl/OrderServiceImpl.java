package com.zwl.orderManager.service.impl;

import com.zwl.orderManager.dao.OrderMapper;
import com.zwl.orderManager.domain.OrderDO;
import com.zwl.orderManager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public OrderDO get(String orderNo) {
        return orderMapper.get(orderNo);
    }

    @Override
    public List<OrderDO> list(Map<String, Object> map) {
        return orderMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return orderMapper.count(map);
    }

    @Override
    public int save(OrderDO order) {
        return orderMapper.save(order);
    }

    @Override
    public int update(OrderDO order) {
        return orderMapper.update(order);
    }

    @Override
    public int remove(String orderNo) {
        return orderMapper.remove(orderNo);
    }

    @Override
    public int batchRemove(String[] orderNos) {
        return orderMapper.batchRemove(orderNos);
    }

    @Override
    public OrderDO getOrderByLevelAndUserId(Integer productLevel, String userId) {
        return orderMapper.getOrderByLevelAndUserId(productLevel, userId);
    }

}
