package com.zwl.maidPercentManager.dao;

import com.zwl.maidPercentManager.domain.UserMaidPercentDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-16 16:13:41
 */
@Mapper
public interface UserMaidPercentMapper {

    @Select("select `id`, `member_level`, `maid_percent_1`, `maid_percent_4`, `maid_percent_6`, `merchant_id`, `create_time`, `modify_time`, `available` from ss_user_maid_percent where id = #{id}")
    UserMaidPercentDO get(Integer id);

    @Select("<script>" +
            "select * from ss_user_maid_percent " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"memberLevel != null and memberLevel != ''\">" + "and member_level = #{memberLevel} " + "</if>" +
            "<if test=\"maidPercent1 != null and maidPercent1 != ''\">" + "and maid_percent_1 = #{maidPercent1} " + "</if>" +
            "<if test=\"maidPercent4 != null and maidPercent4 != ''\">" + "and maid_percent_4 = #{maidPercent4} " + "</if>" +
            "<if test=\"maidPercent6 != null and maidPercent6 != ''\">" + "and maid_percent_6 = #{maidPercent6} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
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
    List<UserMaidPercentDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_user_maid_percent " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"memberLevel != null and memberLevel != ''\">" + "and member_level = #{memberLevel} " + "</if>" +
            "<if test=\"maidPercent1 != null and maidPercent1 != ''\">" + "and maid_percent_1 = #{maidPercent1} " + "</if>" +
            "<if test=\"maidPercent4 != null and maidPercent4 != ''\">" + "and maid_percent_4 = #{maidPercent4} " + "</if>" +
            "<if test=\"maidPercent6 != null and maidPercent6 != ''\">" + "and maid_percent_6 = #{maidPercent6} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_user_maid_percent (`member_level`, `maid_percent_1`, `maid_percent_4`, `maid_percent_6`, `merchant_id`, `create_time`, `modify_time`, `available`)"
            + "values (#{memberLevel}, #{maidPercent1}, #{maidPercent4}, #{maidPercent6}, #{merchantId}, #{createTime}, #{modifyTime}, #{available})")
    int save(UserMaidPercentDO userMaidPercent);

    @Update("<script>" +
            "update ss_user_maid_percent " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"memberLevel != null\">`member_level` = #{memberLevel}, </if>" +
            "<if test=\"maidPercent1 != null\">`maid_percent_1` = #{maidPercent1}, </if>" +
            "<if test=\"maidPercent4 != null\">`maid_percent_4` = #{maidPercent4}, </if>" +
            "<if test=\"maidPercent6 != null\">`maid_percent_6` = #{maidPercent6}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(UserMaidPercentDO userMaidPercent);

    @Delete("delete from ss_user_maid_percent where id =#{id}")
    int remove(Integer id);

    @Delete("<script>" +
            "delete from ss_user_maid_percent where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Integer[] ids);
}
