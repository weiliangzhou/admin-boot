package com.zwl.maidInfoManager.service;

import com.zwl.maidInfoManager.domain.MaidInfoDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 14:53:30
 */
public interface MaidInfoService {

    MaidInfoDO get(Long id);

    List<MaidInfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MaidInfoDO maidInfo);

    int update(MaidInfoDO maidInfo);

    int remove(Long id);

    int batchRemove(Long[] ids);

    Integer getBalanceByUserId(String userId);

    Integer getTotalMaidMoneyByUserId(String userId);
}
