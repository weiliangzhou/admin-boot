package com.zwl.orderManager.dao;

import com.zwl.orderManager.domain.OrderDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 10:28:37
 */
@Mapper
public interface OrderMapper {

    @Select("select `order_no`, `product_id`, `product_name`, `actual_money`, `money`, `maid_percent`, `pay_way`, `level`, `level_name`, `validity_time`, `order_status`, `user_id`, `merchant_id`, `phone`, `real_name`, `payment_no`, `payment_time`, `address`, `create_time`, `modify_time`, `available` from ss_order where order_no = #{id}")
    OrderDO get(String orderNo);

    @Select("<script>" +
            "select * from ss_order " +
            "<where>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"productId != null and productId != ''\">" + "and product_id = #{productId} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"actualMoney != null and actualMoney != ''\">" + "and actual_money = #{actualMoney} " + "</if>" +
            "<if test=\"money != null and money != ''\">" + "and money = #{money} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"payWay != null and payWay != ''\">" + "and pay_way = #{payWay} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"validityTime != null and validityTime != ''\">" + "and validity_time = #{validityTime} " + "</if>" +
            "<if test=\"orderStatus != null and orderStatus != ''\">" + "and order_status = #{orderStatus} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"paymentNo != null and paymentNo != ''\">" + "and payment_no = #{paymentNo} " + "</if>" +
            "<if test=\"paymentTime != null and paymentTime != ''\">" + "and payment_time = #{paymentTime} " + "</if>" +
            "<if test=\"address != null and address != ''\">" + "and address = #{address} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ payment_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ payment_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            " <choose>" +
            "<when test=\"sort != null and sort.trim() != ''\">" +
            "order by ${sort} ${order}" +
            "</when>" +
            "<otherwise>" +
            "order by order_no desc" +
            "</otherwise>" +
            "</choose>" +
            "<if test=\"offset != null and limit != null\">" +
            "limit #{offset}, #{limit}" +
            "</if>" +
            "</script>")
    List<OrderDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_order " +
            "<where>" +
            "<if test=\"orderNo != null and orderNo != ''\">" + "and order_no = #{orderNo} " + "</if>" +
            "<if test=\"productId != null and productId != ''\">" + "and product_id = #{productId} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"actualMoney != null and actualMoney != ''\">" + "and actual_money = #{actualMoney} " + "</if>" +
            "<if test=\"money != null and money != ''\">" + "and money = #{money} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"payWay != null and payWay != ''\">" + "and pay_way = #{payWay} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"validityTime != null and validityTime != ''\">" + "and validity_time = #{validityTime} " + "</if>" +
            "<if test=\"orderStatus != null and orderStatus != ''\">" + "and order_status = #{orderStatus} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"paymentNo != null and paymentNo != ''\">" + "and payment_no = #{paymentNo} " + "</if>" +
            "<if test=\"paymentTime != null and paymentTime != ''\">" + "and payment_time = #{paymentTime} " + "</if>" +
            "<if test=\"address != null and address != ''\">" + "and address = #{address} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ payment_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ payment_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_order (`order_no`, `product_id`, `product_name`, `actual_money`, `money`, `maid_percent`, `pay_way`, `level`, `level_name`, `validity_time`, `order_status`, `user_id`, `merchant_id`, `phone`, `real_name`, `payment_no`, `payment_time`, `address`, `create_time`, `modify_time`, `available`)"
            + "values (#{orderNo}, #{productId}, #{productName}, #{actualMoney}, #{money}, #{maidPercent}, #{payWay}, #{level}, #{levelName}, #{validityTime}, #{orderStatus}, #{userId}, #{merchantId}, #{phone}, #{realName}, #{paymentNo}, #{paymentTime}, #{address}, #{createTime}, #{modifyTime}, #{available})")
    int save(OrderDO order);

    @Update("<script>" +
            "update ss_order " +
            "<set>" +
            "<if test=\"orderNo != null\">`order_no` = #{orderNo}, </if>" +
            "<if test=\"productId != null\">`product_id` = #{productId}, </if>" +
            "<if test=\"productName != null\">`product_name` = #{productName}, </if>" +
            "<if test=\"actualMoney != null\">`actual_money` = #{actualMoney}, </if>" +
            "<if test=\"money != null\">`money` = #{money}, </if>" +
            "<if test=\"maidPercent != null\">`maid_percent` = #{maidPercent}, </if>" +
            "<if test=\"payWay != null\">`pay_way` = #{payWay}, </if>" +
            "<if test=\"level != null\">`level` = #{level}, </if>" +
            "<if test=\"levelName != null\">`level_name` = #{levelName}, </if>" +
            "<if test=\"validityTime != null\">`validity_time` = #{validityTime}, </if>" +
            "<if test=\"orderStatus != null\">`order_status` = #{orderStatus}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"phone != null\">`phone` = #{phone}, </if>" +
            "<if test=\"realName != null\">`real_name` = #{realName}, </if>" +
            "<if test=\"paymentNo != null\">`payment_no` = #{paymentNo}, </if>" +
            "<if test=\"paymentTime != null\">`payment_time` = #{paymentTime}, </if>" +
            "<if test=\"address != null\">`address` = #{address}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where order_no = #{orderNo}" +
            "</script>")
    int update(OrderDO order);

    @Delete("delete from ss_order where order_no =#{orderNo}")
    int remove(String order_no);

    @Delete("<script>" +
            "delete from ss_order where order_no in " +
            "<foreach item=\"orderNo\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{orderNo}" +
            "</foreach>" +
            "</script>")
    int batchRemove(String[] orderNos);

    @Select("select * from ss_order where `level`=#{productLevel} and user_id=#{userId} and payment_no is not null ")
    OrderDO getOrderByLevelAndUserId(@Param("productLevel") Integer productLevel, @Param("userId") String userId);
}
