package com.zwl.classManager.service;

import com.zwl.classManager.domain.ClassCategoryItemVo;

import java.util.List;

public interface ClassCategoryService {
    List<ClassCategoryItemVo> getClassCategoryItemList(String merchantId);
}
