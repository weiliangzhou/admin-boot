package com.zwl.giftManager.service.impl;

import com.zwl.giftManager.dao.GiftMapper;
import com.zwl.giftManager.domain.GiftDO;
import com.zwl.giftManager.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class GiftServiceImpl implements GiftService {
    @Autowired
    private GiftMapper giftMapper;

    @Override
    public GiftDO get(Long id) {
        return giftMapper.get(id);
    }

    @Override
    public List<GiftDO> list(Map<String, Object> map) {
        return giftMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return giftMapper.count(map);
    }

    @Override
    public int save(GiftDO gift) {
        return giftMapper.save(gift);
    }

    @Override
    public int update(GiftDO gift) {
        return giftMapper.update(gift);
    }

    @Override
    public int remove(Long id) {
        return giftMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return giftMapper.batchRemove(ids);
    }

}
