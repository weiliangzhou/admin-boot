package com.zwl.memberManager.service;

import com.zwl.memberManager.domain.UserWechatDO;

import java.util.List;
import java.util.Map;

/**
 * 用户绑定微信账号
 * (目前微信账号是手输的    why)
 *
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-12 16:27:50
 */
public interface UserWechatService {

    UserWechatDO get(Integer id);

    List<UserWechatDO> list(Map<String, Object> map);

    /**
     * 查询用户绑定的微信信息
     *
     * @param userId 用户标识
     */
    UserWechatDO getUserWechatByUserId(String userId);

    int count(Map<String, Object> map);

    int save(UserWechatDO userWechat);

    int update(UserWechatDO userWechat);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
