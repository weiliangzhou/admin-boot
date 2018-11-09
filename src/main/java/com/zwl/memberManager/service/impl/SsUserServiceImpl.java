package com.zwl.memberManager.service.impl;

import com.zwl.memberManager.dao.SsUserMapper;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SsUserServiceImpl implements SsUserService {
    @Autowired
    private SsUserMapper ssUserMapper;

    @Override
    public SsUserDO get(Long id) {
        return ssUserMapper.get(id);
    }

    @Override
    public List<SsUserDO> list(Map<String, Object> map) {
        return ssUserMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return ssUserMapper.count(map);
    }

    @Override
    public int save(SsUserDO ssUser) {
        return ssUserMapper.save(ssUser);
    }

    @Override
    public int update(SsUserDO ssUser) {
        return ssUserMapper.update(ssUser);
    }

    @Override
    public int remove(Long id) {
        return ssUserMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return ssUserMapper.batchRemove(ids);
    }

    @Override
    public SsUserDO getUserByUserId(String userId) {
        return ssUserMapper.getUserByUserId(userId);
    }

    @Override
    public String getUserByRegisterMobile(String registerMobile) {
        return ssUserMapper.getUserByRegisterMobile(registerMobile);
    }

    @Override
    public Integer getXiaXianCountByUserId(String userId, String merchantId) {
        return ssUserMapper.getXiaXianCountByUserId(userId,merchantId);
    }

    @Override
    public Integer getActualMoneyByUserId(String userId) {
        return ssUserMapper.getActualMoneyByUserId(userId);
    }

    @Override
    public SsUserDO getUserByPhone(String phone, String merchantId) {
        return ssUserMapper.getUserByPhone(phone, merchantId);
    }

    @Override
    public Integer getTotalPerformanceByUserId(String userId, String merchantId) {
        return ssUserMapper.getTotalPerformanceByUserId(userId,merchantId);
    }

    @Override
    public List<String> getUserIdByRealName(String slReferrerName, String merchantId) {
        return ssUserMapper.getUserIdByRealName(slReferrerName,merchantId);
    }
}
