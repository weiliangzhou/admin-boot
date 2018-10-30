package com.zwl.giftManager.service.impl;

import com.zwl.giftManager.dao.UserGiftMapper;
import com.zwl.giftManager.domain.UserGiftDO;
import com.zwl.giftManager.service.UserGiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserGiftServiceImpl implements UserGiftService {
    @Autowired
    private UserGiftMapper userGiftMapper;

    @Override
    public UserGiftDO get(Long id) {
        return userGiftMapper.get(id);
    }

    @Override
    public List<UserGiftDO> list(Map<String, Object> map) {
        return userGiftMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userGiftMapper.count(map);
    }

    @Override
    public int save(UserGiftDO userGift) {
        return userGiftMapper.save(userGift);
    }

    @Override
    public int update(UserGiftDO userGift) {
        return userGiftMapper.update(userGift);
    }

    @Override
    public int remove(Long id) {
        return userGiftMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return userGiftMapper.batchRemove(ids);
    }

}
