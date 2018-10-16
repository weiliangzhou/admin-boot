package com.zwl.maidPercentManager.service.impl;

import com.zwl.maidPercentManager.dao.UserMaidPercentMapper;
import com.zwl.maidPercentManager.domain.UserMaidPercentDO;
import com.zwl.maidPercentManager.service.UserMaidPercentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserMaidPercentServiceImpl implements UserMaidPercentService {
    @Autowired
    private UserMaidPercentMapper userMaidPercentMapper;

    @Override
    public UserMaidPercentDO get(Integer id) {
        return userMaidPercentMapper.get(id);
    }

    @Override
    public List<UserMaidPercentDO> list(Map<String, Object> map) {
        return userMaidPercentMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userMaidPercentMapper.count(map);
    }

    @Override
    public int save(UserMaidPercentDO userMaidPercent) {
        return userMaidPercentMapper.save(userMaidPercent);
    }

    @Override
    public int update(UserMaidPercentDO userMaidPercent) {
        return userMaidPercentMapper.update(userMaidPercent);
    }

    @Override
    public int remove(Integer id) {
        return userMaidPercentMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return userMaidPercentMapper.batchRemove(ids);
    }

}
