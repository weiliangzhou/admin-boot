package com.zwl.maidInfoByMonthManager.service.impl;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidInfoByMonthManager.dao.MaidInfoByMonthMapper;
import com.zwl.maidInfoByMonthManager.domain.MaidInfoByMonthDO;
import com.zwl.maidInfoByMonthManager.service.MaidInfoByMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MaidInfoByMonthServiceImpl implements MaidInfoByMonthService {
    @Autowired
    private MaidInfoByMonthMapper maidInfoByMonthMapper;

    @Override
    public MaidInfoByMonthDO get(Long id) {
        return maidInfoByMonthMapper.get(id);
    }

    @Override
    public List<MaidInfoByMonthDO> list(Map<String, Object> map) {
        map.put("merchantId", ShiroUtils.getMerchantId().equals("admin") ? null : ShiroUtils.getMerchantId());
        map.put("available", 1);
        return maidInfoByMonthMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return maidInfoByMonthMapper.count(map);
    }

    @Override
    public int save(MaidInfoByMonthDO maidInfoByMonth) {
        return maidInfoByMonthMapper.save(maidInfoByMonth);
    }

    @Override
    public int update(MaidInfoByMonthDO maidInfoByMonth) {
        return maidInfoByMonthMapper.update(maidInfoByMonth);
    }

    @Override
    public int remove(Long id) {
        return maidInfoByMonthMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return maidInfoByMonthMapper.batchRemove(ids);
    }

}
