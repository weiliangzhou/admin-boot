package com.zwl.classManager.service.impl;

import com.zwl.classManager.dao.ClainfoMapper;
import com.zwl.classManager.dao.ClasetMapper;
import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClainfoDO;
import com.zwl.classManager.domain.ClasetDO;
import com.zwl.classManager.service.ClasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ClasetServiceImpl implements ClasetService {
    @Autowired
    private ClasetMapper clasetMapper;
    @Autowired
    private ClainfoMapper clainfoMapper;

    @Override
    public ClasetDO get(Long id) {
        return clasetMapper.get(id);
    }

    @Override
    public List<ClasetDO> list(Map<String, Object> map) {
        return clasetMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return clasetMapper.count(map);
    }

    @Override
    public int save(ClasetDO claset) {
        return clasetMapper.save(claset);
    }

    @Override
    public int update(ClasetDO claset) {
        return clasetMapper.update(claset);
    }

    @Override
    public int remove(Long id) {
        int count = clasetMapper.remove(id);
        List<ClainfoDO> clainfoDOList = clainfoMapper.getListByClassSetId(id);
        for (ClainfoDO clainfoDO : clainfoDOList) {
            clainfoMapper.remove(clainfoDO.getId());
        }
        return count;
    }

    @Override
    public int batchRemove(Long[] ids) {
        int count = clasetMapper.batchRemove(ids);
        for (Long id : ids) {
            List<ClainfoDO> clainfoDOList = clainfoMapper.getListByClassSetId(id);
            for (ClainfoDO clainfoDO : clainfoDOList) {
                clainfoMapper.remove(clainfoDO.getId());
            }
        }
        return count;
    }

    @Override
    public List<ClaSetItemVo> getClassSetItemList(Integer categoryId, String merchantId) {
        return clainfoMapper.getClassSetItemList(categoryId, merchantId);
    }

    @Override
    public String getClassNameByClassSet(Integer classSetId) {
        return clainfoMapper.getClassNameByClassSet(classSetId);
    }

}
