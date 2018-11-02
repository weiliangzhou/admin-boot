package com.zwl.withdrawManager.dao;

import com.zwl.withdrawManager.domain.WithdrawDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 15:47:25
 */
@Mapper
public interface WithdrawMapper {

    @Select("select `id`, `withdraw_id`, `money`, `open_id`, `real_name`, `user_id`, `account`, `status`, `pay_way`, `operator`, `remark`, `success_time`, `merchant_id`, `payment_no`, `payment_time`, `create_time`, `modify_time`, `available`,`bank_name`,`bank_province`,`bank_city`,`bank_area`,`bank_branch` from ss_withdraw where id = #{id}")
    WithdrawDO get(Long id);

    @Select("<script>" +
            "select * from ss_withdraw " +
            "<where>" +
            "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" +
            "<if test=\"withdrawId != null and withdrawId != ''\">"+ "and withdraw_id = #{withdrawId} " + "</if>" +
            "<if test=\"money != null and money != ''\">"+ "and money = #{money} " + "</if>" +
            "<if test=\"balance != null and balance != ''\">"+ "and balance = #{balance} " + "</if>" +
            "<if test=\"openId != null and openId != ''\">"+ "and open_id = #{openId} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
            "<if test=\"account != null and account != ''\">"+ "and account = #{account} " + "</if>" +
            "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
            "<if test=\"payWay != null and payWay != ''\">"+ "and pay_way = #{payWay} " + "</if>" +
            "<if test=\"operator != null and operator != ''\">"+ "and operator = #{operator} " + "</if>" +
            "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" +
            "<if test=\"successTime != null and successTime != ''\">"+ "and success_time = #{successTime} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"paymentNo != null and paymentNo != ''\">"+ "and payment_no = #{paymentNo} " + "</if>" +
            "<if test=\"paymentTime != null and paymentTime != ''\">"+ "and payment_time = #{paymentTime} " + "</if>" +
            "<if test=\"bankName != null and bankName != ''\">"+ "and bank_name = #{bankName} " + "</if>" +
            "<if test=\"bankProvince != null and bankProvince != ''\">"+ "and bank_province = #{bankProvince} " + "</if>" +
            "<if test=\"bankCity != null and bankCity != ''\">"+ "and bank_city = #{bankCity} " + "</if>" +
            "<if test=\"bankArea != null and bankArea != ''\">"+ "and bank_area = #{bankArea} " + "</if>" +
            "<if test=\"bankBranch != null and bankBranch != ''\">"+ "and bank_branch = #{bankBranch} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "<if test=\"minSuccessTime != null and minSuccessTime != ''\">" + "and  <![CDATA[ successTime >= #{minSuccessTime} ]]>" + "</if>" +
            "<if test=\"maxSuccessTime != null and maxSuccessTime != ''\">" + "and  <![CDATA[ successTime <= #{maxSuccessTime} ]]>" + "</if>" +
            "</where>" +
            " <choose>" +
            "<when test=\"sort != null and sort.trim() != ''\">" +
            "order by ${sort} ${order}" +
            "</when>" +
            "<otherwise>" +
            "order by modify_time desc" +
            "</otherwise>" +
            "</choose>" +
            "<if test=\"offset != null and limit != null\">" +
            "limit #{offset}, #{limit}" +
            "</if>" +
            "</script>")
    List<WithdrawDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_withdraw " +
            "<where>" +
            "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" +
            "<if test=\"withdrawId != null and withdrawId != ''\">"+ "and withdraw_id = #{withdrawId} " + "</if>" +
            "<if test=\"money != null and money != ''\">"+ "and money = #{money} " + "</if>" +
            "<if test=\"balance != null and balance != ''\">"+ "and balance = #{balance} " + "</if>" +
            "<if test=\"openId != null and openId != ''\">"+ "and open_id = #{openId} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" +
            "<if test=\"account != null and account != ''\">"+ "and account = #{account} " + "</if>" +
            "<if test=\"status != null and status != ''\">"+ "and status = #{status} " + "</if>" +
            "<if test=\"payWay != null and payWay != ''\">"+ "and pay_way = #{payWay} " + "</if>" +
            "<if test=\"operator != null and operator != ''\">"+ "and operator = #{operator} " + "</if>" +
            "<if test=\"remark != null and remark != ''\">"+ "and remark = #{remark} " + "</if>" +
            "<if test=\"successTime != null and successTime != ''\">"+ "and success_time = #{successTime} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"paymentNo != null and paymentNo != ''\">"+ "and payment_no = #{paymentNo} " + "</if>" +
            "<if test=\"paymentTime != null and paymentTime != ''\">"+ "and payment_time = #{paymentTime} " + "</if>" +
            "<if test=\"bankName != null and bankName != ''\">"+ "and bank_name = #{bankName} " + "</if>" +
            "<if test=\"bankProvince != null and bankProvince != ''\">"+ "and bank_province = #{bankProvince} " + "</if>" +
            "<if test=\"bankCity != null and bankCity != ''\">"+ "and bank_city = #{bankCity} " + "</if>" +
            "<if test=\"bankArea != null and bankArea != ''\">"+ "and bank_area = #{bankArea} " + "</if>" +
            "<if test=\"bankBranch != null and bankBranch != ''\">"+ "and bank_branch = #{bankBranch} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "<if test=\"minSuccessTime != null and minSuccessTime != ''\">" + "and  <![CDATA[ successTime >= #{minSuccessTime} ]]>" + "</if>" +
            "<if test=\"maxSuccessTime != null and maxSuccessTime != ''\">" + "and  <![CDATA[ successTime >= #{maxSuccessTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_withdraw (`withdraw_id`, `money`, `open_id`, `real_name`, `user_id`, `account`, `status`, `pay_way`, `operator`, `remark`, `success_time`, `merchant_id`, `payment_no`, `payment_time`, `create_time`, `modify_time`, `available`)"
            + "values (#{withdrawId}, #{money}, #{openId}, #{realName}, #{userId}, #{account}, #{status}, #{payWay}, #{operator}, #{remark}, #{successTime}, #{merchantId}, #{paymentNo}, #{paymentTime}, #{createTime}, #{modifyTime}, #{available})")
    int save(WithdrawDO withdraw);

    @Update("<script>" +
            "update ss_withdraw " +
            "<set>" +
            "<if test=\"status != null\">`status` = #{status}, </if>" +
            "<if test=\"operator != null\">`operator` = #{operator}, </if>" +
            "<if test=\"remark != null\">`remark` = #{remark}, </if>" +
            "<if test=\"successTime != null \">`success_time`= #{successTime},</if>" +
//            "<if test=\"paymentNo != null\">`payment_no` = #{paymentNo}, </if>" +
//            "<if test=\"paymentTime != null\">`payment_time` = #{paymentTime}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(WithdrawDO withdraw);

    @Delete("delete from ss_withdraw where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_withdraw where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select("select count(*) from ss_user usr,ss_order so,ss_product sp where usr.available = 1 and usr.referrer = #{userId} and so.available = 1 and so.order_status>=1 and usr.user_id = so.user_id and usr.member_level=sp.`level`")
    Integer getXiaXianCountByUserId(String userId);

    @Select("select sum(actual_money) from ss_order where available = 1 and user_id = #{userId} and order_status in (1,2)")
    Integer getActualMoneyByUserId(String userId);
}
