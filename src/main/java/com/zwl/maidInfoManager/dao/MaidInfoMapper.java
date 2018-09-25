package com.zwl.maidInfoManager.dao;

import com.zwl.maidInfoManager.domain.MaidInfoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 14:53:30
 */
@Mapper
public interface MaidInfoMapper {

    @Select("select `id`, `order_no`, `user_id`, `maid_user_id`, `maid_money`, `maid_percent`, `order_actual_money`, `merchant_id`, `product_id`, `product_name`, `level`, `level_name`, `create_time`, `modify_time`, `available` from ss_maid_info where id = #{id}")
    public MaidInfoDO get(Long id);

    @Select("<script>" +
            "select * from ss_maid_info " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"maidUserId != null and maidUserId != ''\">" + "and maid_user_id = #{maidUserId} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"orderActualMoney != null and orderActualMoney != ''\">" + "and order_actual_money = #{orderActualMoney} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"productId != null and productId != ''\">" + "and product_id = #{productId} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            " <choose>" +
            "<when test=\"sort != null and sort.trim() != ''\">" +
            "order by ${sort} ${order}" +
            "</when>" +
            "<otherwise>" +
            "order by id desc" +
            "</otherwise>" +
            "</choose>" +
            "<if test=\"offset != null and limit != null\">" +
            "limit #{offset}, #{limit}" +
            "</if>" +
            "</script>")
    List<MaidInfoDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_maid_info " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"maidUserId != null and maidUserId != ''\">" + "and maid_user_id = #{maidUserId} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"orderActualMoney != null and orderActualMoney != ''\">" + "and order_actual_money = #{orderActualMoney} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"productId != null and productId != ''\">" + "and product_id = #{productId} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_maid_info (`order_no`, `user_id`, `maid_user_id`, `maid_money`, `maid_percent`, `order_actual_money`, `merchant_id`, `product_id`, `product_name`, `level`, `level_name`, `create_time`, `modify_time`, `available`)"
            + "values (#{orderNo}, #{userId}, #{maidUserId}, #{maidMoney}, #{maidPercent}, #{orderActualMoney}, #{merchantId}, #{productId}, #{productName}, #{level}, #{levelName}, #{createTime}, #{modifyTime}, #{available})")
    int save(MaidInfoDO maidInfo);

    @Update("<script>" +
            "update ss_maid_info " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"orderNo != null\">`order_no` = #{orderNo}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"maidUserId != null\">`maid_user_id` = #{maidUserId}, </if>" +
            "<if test=\"maidMoney != null\">`maid_money` = #{maidMoney}, </if>" +
            "<if test=\"maidPercent != null\">`maid_percent` = #{maidPercent}, </if>" +
            "<if test=\"orderActualMoney != null\">`order_actual_money` = #{orderActualMoney}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"productId != null\">`product_id` = #{productId}, </if>" +
            "<if test=\"productName != null\">`product_name` = #{productName}, </if>" +
            "<if test=\"level != null\">`level` = #{level}, </if>" +
            "<if test=\"levelName != null\">`level_name` = #{levelName}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(MaidInfoDO maidInfo);

    @Delete("delete from ss_maid_info where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_maid_info where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select(" select balance from ss_user_account where available=1 and user_id =#{userId}")
    Integer getBalanceByUserId(String userId);

    @Select("SELECT sum(maid_money) from ss_maid_info where user_id=#{userId} and available=1")
    Integer getTotalMaidMoneyByUserId(String userId);
}
