package com.zwl.informationManager.service.impl;

import com.zwl.common.utils.EditUtil;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.informationManager.dao.InformationMapper;
import com.zwl.informationManager.domain.InformationDO;
import com.zwl.informationManager.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;


@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public InformationDO get(Integer id) {
        return informationMapper.get(id);
    }

    @Override
    public List<InformationDO> list(Map<String, Object> map) {
        return informationMapper.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return informationMapper.count(map);
    }

    @Override
    public int save(InformationDO information) {
        verfiy(information);
        information.setCreateTime(Calendar.getInstance().getTime());
        return informationMapper.save(information);
    }

    private void verfiy(InformationDO information) {
        if (null == information) {
            throw new RuntimeException("参数错误");
        }
    }

    @Override
    public int update(InformationDO information) {
        if (null == information) {
            throw new RuntimeException("参数错误");
        }
        information.setContentText(EditUtil.delHtmlTag(information.getContent()));
        return informationMapper.update(information);
    }

    @Override
    public int remove(Integer id) {
        return informationMapper.remove(id);
    }

    @Override
    public int batchRemove(Integer[] ids) {
        return informationMapper.batchRemove(ids);
    }

}
