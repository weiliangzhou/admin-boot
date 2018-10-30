package com.zwl.giftManager.service;

import com.zwl.giftManager.domain.GiftDO;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 16:11:40
 */
public interface GiftService {

    GiftDO get(Long id);

    List<GiftDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(GiftDO gift);

    int update(GiftDO gift);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
