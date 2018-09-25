package com.zwl.maidInfoByMonthManager.service;

import com.zwl.maidInfoByMonthManager.domain.MaidInfoByMonthDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:36:31
 */
public interface MaidInfoByMonthService {

    MaidInfoByMonthDO get(Long id);

    List<MaidInfoByMonthDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(MaidInfoByMonthDO maidInfoByMonth);

    int update(MaidInfoByMonthDO maidInfoByMonth);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
