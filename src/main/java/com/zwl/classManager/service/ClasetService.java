package com.zwl.classManager.service;

import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClasetDO;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
public interface ClasetService {

    ClasetDO get(Long id);

    List<ClasetDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ClasetDO claset);

    int update(ClasetDO claset);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<ClaSetItemVo> getClassSetItemList(Integer categoryId, String merchantId);

    String getClassNameByClassSet(Integer classSetId);
}
