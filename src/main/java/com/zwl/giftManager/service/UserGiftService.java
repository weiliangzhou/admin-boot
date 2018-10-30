package com.zwl.giftManager.service;


import com.zwl.giftManager.domain.UserGiftDO;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 15:56:39
 */
public interface UserGiftService {

    UserGiftDO get(Long id);

    List<UserGiftDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(UserGiftDO userGift);

    int update(UserGiftDO userGift);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
