package com.zwl.informationManager.service;

import com.zwl.informationManager.domain.InformationDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-30 15:44:24
 */
public interface InformationService {

    InformationDO get(Integer id);

    List<InformationDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(InformationDO information);

    int update(InformationDO information);

    int remove(Integer id);

    int batchRemove(Integer[] ids);
}
