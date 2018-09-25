package com.zwl.classManager.service;


import com.zwl.classManager.domain.ClainfoDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
public interface ClainfoService {

    ClainfoDO get(Long id);

    List<ClainfoDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ClainfoDO clainfo);

    int update(ClainfoDO clainfo);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
