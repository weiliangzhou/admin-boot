package com.zwl.memberManager.dao;

import com.zwl.memberManager.domain.SsUserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 *
 *
 * @author 二师兄超级帅
 * @email 382308664@qq.com
 * @date 2018-08-27 16:35:27
 */
@Mapper
public interface SsUserMapper {

    @Select("select `id`, `user_id`, `wechat_openid`, `wechat_union_id`, `merchant_id`, `register_from`, `register_mobile`, `real_name`, `logo_url`, `referrer`, `member_level`, `level_name`, `is_buy`, `expires_time`, `register_time`, `modify_time`, `available`, `form_id` from ss_user where id = #{id}")
    SsUserDO get(Long id);

    @Select("<script>" +
            "select * from ss_user" +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"wechatOpenid != null and wechatOpenid != ''\">" + "and wechat_openid = #{wechatOpenid} " + "</if>" +
            "<if test=\"wechatUnionId != null and wechatUnionId != ''\">" + "and wechat_union_id = #{wechatUnionId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != 'admin'\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"registerFrom != null and registerFrom != ''\">" + "and register_from = #{registerFrom} " + "</if>" +
            "<if test=\"registerMobile != null and registerMobile != ''\">" + "and register_mobile = #{registerMobile} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"referrer != null and referrer != ''\">" + "and referrer = #{referrer} " + "</if>" +
            "<if test=\"memberLevel != null and memberLevel != ''\">" + "and member_level = #{memberLevel} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"isBuy != null and isBuy != ''\">" + "and is_buy = #{isBuy} " + "</if>" +
            "<if test=\"expiresTime != null and expiresTime != ''\">" + "and expires_time = #{expiresTime} " + "</if>" +
            "<if test=\"registerTime != null and registerTime != ''\">" + "and register_time = #{registerTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ register_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ register_time<= #{maxTime} ]]>" + "</if>" +
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
    List<SsUserDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_user " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"wechatOpenid != null and wechatOpenid != ''\">" + "and wechat_openid = #{wechatOpenid} " + "</if>" +
            "<if test=\"wechatUnionId != null and wechatUnionId != ''\">" + "and wechat_union_id = #{wechatUnionId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != 'admin'\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"registerFrom != null and registerFrom != ''\">" + "and register_from = #{registerFrom} " + "</if>" +
            "<if test=\"registerMobile != null and registerMobile != ''\">" + "and register_mobile = #{registerMobile} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"referrer != null and referrer != ''\">" + "and referrer = #{referrer} " + "</if>" +
            "<if test=\"memberLevel != null and memberLevel != ''\">" + "and member_level = #{memberLevel} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"isBuy != null and isBuy != ''\">" + "and is_buy = #{isBuy} " + "</if>" +
            "<if test=\"expiresTime != null and expiresTime != ''\">" + "and expires_time = #{expiresTime} " + "</if>" +
            "<if test=\"registerTime != null and registerTime != ''\">" + "and register_time = #{registerTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ register_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ register_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_user (`user_id`, `wechat_openid`, `wechat_union_id`, `merchant_id`, `register_from`, `register_mobile`, `real_name`, `logo_url`, `referrer`, `member_level`, `level_name`, `is_buy`, `expires_time`, `register_time`, `modify_time`, `available`, `form_id`)"
            + "values (#{userId}, #{wechatOpenid}, #{wechatUnionId}, #{merchantId}, #{registerFrom}, #{registerMobile}, #{realName}, #{logoUrl}, #{referrer}, #{memberLevel}, #{levelName}, #{isBuy}, #{expiresTime}, #{registerTime}, #{modifyTime}, #{available}, #{formId})")
    int save(SsUserDO ssUser);

    @Update("<script>" +
            "update ss_user " +
            "<set>" +
            "<if test=\"registerFrom != null\">`register_from` = #{registerFrom}, </if>" +
            "<if test=\"registerMobile != null\">`register_mobile` = #{registerMobile}, </if>" +
            "<if test=\"realName != null\">`real_name` = #{realName}, </if>" +
            "<if test=\"referrer != null\">`referrer` = #{referrer}, </if>" +
            "<if test=\"memberLevel != null\">`member_level` = #{memberLevel}, </if>" +
            "<if test=\"levelName != null\">`level_name` = #{levelName}, </if>" +
            "<if test=\"isBuy != null\">`is_buy` = #{isBuy}, </if>" +
            "<if test=\"expiresTime != null\">`expires_time` = #{expiresTime}, </if>" +
            "</set>" +
            "where user_id = #{userId}" +
            "</script>")
    int update(SsUserDO ssUser);

    @Delete("delete from ss_user where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_user where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select("select * from ss_user where user_id =#{userId}")
    SsUserDO getUserByUserId(String userId);
    @Select("select user_id from ss_user where register_mobile =#{registerMobile}")
    String getUserByRegisterMobile(String registerMobile);

//    @Select("select count(*) from ss_user usr,ss_order so,ss_product sp where usr.available = 1 and usr.referrer = #{userId} and so.available = 1 and so.order_status>=1 and usr.user_id = so.user_id and usr.member_level=sp.`level`")
    @Select("select count(*) from ss_user where referrer = #{userId} and merchant_id = #{merchantId} and available = 1")
    Integer getXiaXianCountByUserId(@Param("userId") String userId, @Param("merchantId")String merchantId);

    @Select("select sum(actual_money) from ss_order where available = 1 and user_id = #{userId} and order_status in (1,2)")
    Integer getActualMoneyByUserId(@Param("userId") String userId);

    @Select("select * from ss_user where available=1 and register_mobile=#{phone} and merchant_id =#{merchantId}")
    SsUserDO getUserByPhone(@Param("phone") String phone, @Param("merchantId") String merchantId);

    //根据userId查询该userId的一级下线的总业绩
    @Select("select sum(so.money) from ss_user su join ss_order so on su.user_id = so.user_id where su.referrer = #{userId} and su.merchant_id = #{merchantId} and su.available = 1 and so.order_status in (1,2) and so.available = 1")
    Integer getTotalPerformanceByUserId(@Param("userId")String userId, @Param("merchantId")String merchantId);
}
