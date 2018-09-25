package com.zwl.classManager.dao;


import com.zwl.classManager.domain.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface MerchantMapper {
    @Select("select * from ss_merchant where merchant_id=#{merchantId}")
    Merchant selectByMerchantId(String merchantId);

}