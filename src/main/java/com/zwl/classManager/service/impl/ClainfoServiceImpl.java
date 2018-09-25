package com.zwl.classManager.service.impl;

import com.zwl.classManager.dao.ClainfoMapper;
import com.zwl.classManager.domain.ClainfoDO;
import com.zwl.classManager.service.ClainfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ClainfoServiceImpl implements ClainfoService {
    @Autowired
    private ClainfoMapper clainfoMapper;

    @Override
    public ClainfoDO get(Long id) {
        return clainfoMapper.get(id);
    }

    @Override
    public List<ClainfoDO> list(Map<String, Object> map) {
        return clainfoMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return clainfoMapper.count(map);
    }

    @Override
    public int save(ClainfoDO clainfo) {
        return clainfoMapper.save(clainfo);
    }

    @Override
    public int update(ClainfoDO clainfo) {
        return clainfoMapper.update(clainfo);
    }

    @Override
    public int remove(Long id) {
        return clainfoMapper.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return clainfoMapper.batchRemove(ids);
    }

}
