package com.zwl.workOrderManager.dao;

import com.zwl.workOrderManager.domain.WorkOrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-19 14:26:45
 */
@Mapper
public interface WorkOrderMapper {

    @Select("select `id`, `referrer_user_id`, `referrer_level`, `maid_money`, `user_id`, `order_money`, `phone`, `order_no`, `create_time`, `modify_time`, `remark`,`status` from ss_work_order where id = #{id}")
    WorkOrderDO get(Long id);

    @Select("<script>" +
            "select * from ss_work_order " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"referrerUserId != null and referrerUserId != ''\">" + "and referrer_user_id = #{referrerUserId} " + "</if>" +
            "<if test=\"referrerLevel != null and referrerLevel != ''\">" + "and referrer_level = #{referrerLevel} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"orderMoney != null and orderMoney != ''\">" + "and order_money = #{orderMoney} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
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
    List<WorkOrderDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_work_order " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"referrerUserId != null and referrerUserId != ''\">" + "and referrer_user_id = #{referrerUserId} " + "</if>" +
            "<if test=\"referrerLevel != null and referrerLevel != ''\">" + "and referrer_level = #{referrerLevel} " + "</if>" +
            "<if test=\"maidMoney != null and maidMoney != ''\">" + "and maid_money = #{maidMoney} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"orderMoney != null and orderMoney != ''\">" + "and order_money = #{orderMoney} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_work_order (`referrer_user_id`, `referrer_level`, `maid_money`, `user_id`, `order_money`, `phone`, `order_no`, `create_time`, `available`,`remark`,`status`,`referrer_phone`)"
            + "values (#{referrerUserId}, #{referrerLevel}, #{maidMoney}, #{userId}, #{orderMoney}, #{phone}, #{orderNo}, #{createTime},#{available},#{remark},#{status},#{referrerPhone})")
    int save(WorkOrderDO workOrder);

    @Update("<script>" +
            "update ss_work_order " +
            "<set>" +
            "<if test=\"orderNo != null\">`order_no` = #{orderNo}, </if>" +
            "<if test=\"remark != null\">`remark` = #{remark}, </if>" +
            "<if test=\"status != null\">`status` = #{status}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(WorkOrderDO workOrder);

    @Update("update ss_work_order set available=0  where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "update ss_work_order set available=0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);
}
