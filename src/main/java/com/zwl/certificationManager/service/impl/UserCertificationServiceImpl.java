package com.zwl.certificationManager.service.impl;

import com.zwl.certificationManager.dao.UserCertificationMapper;
import com.zwl.certificationManager.domain.UserCertificationDO;
import com.zwl.certificationManager.service.UserCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserCertificationServiceImpl implements UserCertificationService {
    @Autowired
    private UserCertificationMapper userCertificationMapper;

    @Override
    public UserCertificationDO get(Long id) {
        return userCertificationMapper.get(id);
    }

    @Override
    public List<UserCertificationDO> list(Map<String, Object> map) {
        return userCertificationMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userCertificationMapper.count(map);
    }

    @Override
    public int save(UserCertificationDO userCertification) {
        return userCertificationMapper.save(userCertification);
    }

    @Override
    public int update(UserCertificationDO userCertification) {
        return userCertificationMapper.update(userCertification);
    }

    @Override
    public int remove(Long id) {
        return userCertificationMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return userCertificationMapper.batchRemove(ids);
    }

    @Override
    public String getIdCardByUserId(String userId) {
        return userCertificationMapper.getIdCardByUserId(userId);
    }

}
