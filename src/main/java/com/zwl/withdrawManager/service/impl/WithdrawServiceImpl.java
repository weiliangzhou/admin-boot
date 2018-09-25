package com.zwl.withdrawManager.service.impl;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.withdrawManager.dao.WithdrawMapper;
import com.zwl.withdrawManager.domain.WithdrawDO;
import com.zwl.withdrawManager.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class WithdrawServiceImpl implements WithdrawService {
    @Autowired
    private WithdrawMapper withdrawMapper;

    @Override
    public WithdrawDO get(Long id) {
        return withdrawMapper.get(id);
    }

    @Override
    public List<WithdrawDO> list(Map<String, Object> map) {
        return withdrawMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return withdrawMapper.count(map);
    }

    @Override
    public int save(WithdrawDO withdraw) {
        return withdrawMapper.save(withdraw);
    }

    @Override
    public int update(WithdrawDO withdraw) {
        return withdrawMapper.update(withdraw);
    }

    @Override
    public int remove(Long id) {
        return withdrawMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return withdrawMapper.batchRemove(ids);
    }

    @Override
    public Integer getXiaXianCountByUserId(String userId) {
        return withdrawMapper.getXiaXianCountByUserId(userId);
    }

    @Override
    public Integer getActualMoneyByUserId(String userId) {
        return withdrawMapper.getActualMoneyByUserId(userId);
    }

}
