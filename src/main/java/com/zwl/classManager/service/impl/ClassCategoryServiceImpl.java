package com.zwl.classManager.service.impl;

import com.zwl.classManager.dao.ClassCategoryMapper;
import com.zwl.classManager.domain.ClassCategoryItemVo;
import com.zwl.classManager.service.ClassCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassCategoryServiceImpl implements ClassCategoryService {
    @Autowired
    private ClassCategoryMapper classCategoryMapper;
    @Override
    public List<ClassCategoryItemVo> getClassCategoryItemList(String merchantId) {
        return classCategoryMapper.getClassCategoryItemList(merchantId);
    }
}
