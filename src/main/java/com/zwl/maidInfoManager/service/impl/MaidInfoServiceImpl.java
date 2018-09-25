package com.zwl.maidInfoManager.service.impl;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidInfoManager.dao.MaidInfoMapper;
import com.zwl.maidInfoManager.domain.MaidInfoDO;
import com.zwl.maidInfoManager.service.MaidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MaidInfoServiceImpl implements MaidInfoService {
    @Autowired
    private MaidInfoMapper maidInfoMapper;

    @Override
    public MaidInfoDO get(Long id) {
        return maidInfoMapper.get(id);
    }

    @Override
    public List<MaidInfoDO> list(Map<String, Object> map) {
        return maidInfoMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return maidInfoMapper.count(map);
    }

    @Override
    public int save(MaidInfoDO maidInfo) {
        return maidInfoMapper.save(maidInfo);
    }

    @Override
    public int update(MaidInfoDO maidInfo) {
        return maidInfoMapper.update(maidInfo);
    }

    @Override
    public int remove(Long id) {
        return maidInfoMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return maidInfoMapper.batchRemove(ids);
    }

    @Override
    public Integer getBalanceByUserId(String userId) {
        return maidInfoMapper.getBalanceByUserId(userId);
    }

    @Override
    public Integer getTotalMaidMoneyByUserId(String userId) {
        return maidInfoMapper.getTotalMaidMoneyByUserId(userId);
    }

}
