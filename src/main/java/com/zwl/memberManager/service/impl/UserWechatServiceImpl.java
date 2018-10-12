package com.zwl.memberManager.service.impl;

import com.zwl.memberManager.dao.UserWechatMapper;
import com.zwl.memberManager.domain.UserWechatDO;
import com.zwl.memberManager.service.UserWechatService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserWechatServiceImpl implements UserWechatService {
    @Autowired
    private UserWechatMapper userWechatMapper;

    @Override
    public UserWechatDO get(Integer id) {
        return userWechatMapper.get(id);
    }

    @Override
    public List<UserWechatDO> list(Map<String, Object> map) {
        return userWechatMapper.list(map);
    }

    @Override
    public UserWechatDO getUserWechatByUserId(String userId) {
        return userWechatMapper.getUserWechatByUserId(userId);
    }

    @Override
    public int count(Map<String, Object> map) {
        return userWechatMapper.count(map);
    }

    @Override
    public int save(UserWechatDO userWechat) {
        return userWechatMapper.save(userWechat);
    }

    @Override
    public int update(UserWechatDO userWechat) {
        return userWechatMapper.update(userWechat);
    }

    @Override
    public int remove(Integer id) {
        return userWechatMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return userWechatMapper.batchRemove(ids);
    }

}
