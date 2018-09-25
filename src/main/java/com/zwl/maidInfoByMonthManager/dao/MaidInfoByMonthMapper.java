package com.zwl.maidInfoByMonthManager.dao;

import com.zwl.maidInfoByMonthManager.domain.MaidInfoByMonthDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:36:31
 */
@Mapper
public interface MaidInfoByMonthMapper {

    @Select("select `id`, `user_id`, `maid_money`, `maid_percent`, `total_performance`, `maid_type`, `merchant_id`, `record_time`, `create_time`, `modify_time`, `available` from ss_maid_info_by_month where id = #{id}")
    public MaidInfoByMonthDO get(Long id);

    @Select("<script>" +
            "select * from ss_maid_info_by_month " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"totalPerformance != null and totalPerformance != ''\">" + "and total_performance = #{totalPerformance} " + "</if>" +
            "<if test=\"maidType != null and maidType != ''\">" + "and maid_type = #{maidType} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"recordTime != null and recordTime != ''\">" + "and record_time = #{recordTime} " + "</if>" +
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
    List<MaidInfoByMonthDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_maid_info_by_month " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"totalPerformance != null and totalPerformance != ''\">" + "and total_performance = #{totalPerformance} " + "</if>" +
            "<if test=\"maidType != null and maidType != ''\">" + "and maid_type = #{maidType} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"recordTime != null and recordTime != ''\">" + "and record_time = #{recordTime} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_maid_info_by_month (`user_id`, `maid_money`, `maid_percent`, `total_performance`, `maid_type`, `merchant_id`, `record_time`, `create_time`, `modify_time`, `available`)"
            + "values (#{userId}, #{maidMoney}, #{maidPercent}, #{totalPerformance}, #{maidType}, #{merchantId}, #{recordTime}, #{createTime}, #{modifyTime}, #{available})")
    int save(MaidInfoByMonthDO maidInfoByMonth);

    @Update("<script>" +
            "update ss_maid_info_by_month " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"maidMoney != null\">`maid_money` = #{maidMoney}, </if>" +
            "<if test=\"maidPercent != null\">`maid_percent` = #{maidPercent}, </if>" +
            "<if test=\"totalPerformance != null\">`total_performance` = #{totalPerformance}, </if>" +
            "<if test=\"maidType != null\">`maid_type` = #{maidType}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"recordTime != null\">`record_time` = #{recordTime}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(MaidInfoByMonthDO maidInfoByMonth);

    @Delete("delete from ss_maid_info_by_month where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_maid_info_by_month where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);
}
