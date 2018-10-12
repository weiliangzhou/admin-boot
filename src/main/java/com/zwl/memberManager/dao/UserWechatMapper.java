package com.zwl.memberManager.dao;

import com.zwl.memberManager.domain.UserWechatDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 用户绑定微信账号
 * (目前微信账号是手输的    why)
 *
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-12 16:27:50
 */
@Mapper
public interface UserWechatMapper {

    @Select("select `id`, `wechat_account`, `user_id`, `create_time`, `modify_time` from ss_user_wechat where id = #{id}")
    UserWechatDO get(Integer id);

    @Select("select `id`, `wechat_account`, `user_id`, `create_time`, `modify_time` from ss_user_wechat where user_id = #{userId}")
    UserWechatDO getUserWechatByUserId(String userId);

    @Select("<script>" +
            "select * from ss_user_wechat " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"wechatAccount != null and wechatAccount != ''\">" + "and wechat_account = #{wechatAccount} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
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
    List<UserWechatDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_user_wechat " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"wechatAccount != null and wechatAccount != ''\">" + "and wechat_account = #{wechatAccount} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_user_wechat (`wechat_account`, `user_id`, `create_time`, `modify_time`)"
            + "values (#{wechatAccount}, #{userId}, #{createTime}, #{modifyTime})")
    int save(UserWechatDO userWechat);

    @Update("<script>" +
            "update ss_user_wechat " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"wechatAccount != null\">`wechat_account` = #{wechatAccount}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(UserWechatDO userWechat);

    @Delete("delete from ss_user_wechat where id =#{id}")
    int remove(Integer id);

    @Delete("<script>" +
            "delete from ss_user_wechat where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Integer[] ids);
}
