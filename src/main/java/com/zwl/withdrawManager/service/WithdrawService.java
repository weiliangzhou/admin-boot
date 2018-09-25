package com.zwl.withdrawManager.service;

import com.zwl.withdrawManager.domain.WithdrawDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 15:47:25
 */
public interface WithdrawService {

    WithdrawDO get(Long id);

    List<WithdrawDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(WithdrawDO withdraw);

    int update(WithdrawDO withdraw);

    int remove(Long id);

    int batchRemove(Long[] ids);

    Integer getXiaXianCountByUserId(String userId);

    Integer getActualMoneyByUserId(String userId);
}
