package com.zwl.classManager.dao;

import com.zwl.classManager.domain.ClassCategoryItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassCategoryMapper {
    @Select("select id,title from ss_class_category where available = 1 and merchant_id = #{merchantId}")
    List<ClassCategoryItemVo> getClassCategoryItemList(@Param("merchantId")String merchantId);
}
