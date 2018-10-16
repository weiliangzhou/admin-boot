package com.zwl.maidPercentManager.service;

import com.zwl.maidPercentManager.domain.UserMaidPercentDO;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-16 15:46:13
 */
public interface UserMaidPercentService {

    UserMaidPercentDO get(Integer id);

    List<UserMaidPercentDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserMaidPercentDO userMaidPercent);

    int update(UserMaidPercentDO userMaidPercent);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
