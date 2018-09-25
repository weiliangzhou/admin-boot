package com.zwl.certificationManager.dao;

import com.zwl.certificationManager.domain.UserCertificationDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 10:38:51
 */
@Mapper
public interface UserCertificationMapper {

    @Select("select `id`, `status`, `operator`, `realname`, `id_card`, `img_1_url`, `img_2_url`, `img_3_url`, `user_id`, `merchant_id`, `reject_reason`, `audit_time`, `create_time`, `modify_time`, `available` from ss_user_certification where id = #{id}")
    UserCertificationDO get(Long id);

    @Select("<script>" +
            "select * from ss_user_certification " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"status != null and status != ''\">" + "and status = #{status} " + "</if>" +
            "<if test=\"operator != null and operator != ''\">" + "and operator = #{operator} " + "</if>" +
            "<if test=\"realname != null and realname != ''\">" + "and realname = #{realname} " + "</if>" +
            "<if test=\"idCard != null and idCard != ''\">" + "and id_card = #{idCard} " + "</if>" +
            "<if test=\"img1Url != null and img1Url != ''\">" + "and img_1_url = #{img1Url} " + "</if>" +
            "<if test=\"img2Url != null and img2Url != ''\">" + "and img_2_url = #{img2Url} " + "</if>" +
            "<if test=\"img3Url != null and img3Url != ''\">" + "and img_3_url = #{img3Url} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"rejectReason != null and rejectReason != ''\">" + "and reject_reason = #{rejectReason} " + "</if>" +
            "<if test=\"auditTime != null and auditTime != ''\">" + "and audit_time = #{auditTime} " + "</if>" +
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
    List<UserCertificationDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_user_certification " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"status != null and status != ''\">" + "and status = #{status} " + "</if>" +
            "<if test=\"operator != null and operator != ''\">" + "and operator = #{operator} " + "</if>" +
            "<if test=\"realname != null and realname != ''\">" + "and realname = #{realname} " + "</if>" +
            "<if test=\"idCard != null and idCard != ''\">" + "and id_card = #{idCard} " + "</if>" +
            "<if test=\"img1Url != null and img1Url != ''\">" + "and img_1_url = #{img1Url} " + "</if>" +
            "<if test=\"img2Url != null and img2Url != ''\">" + "and img_2_url = #{img2Url} " + "</if>" +
            "<if test=\"img3Url != null and img3Url != ''\">" + "and img_3_url = #{img3Url} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"rejectReason != null and rejectReason != ''\">" + "and reject_reason = #{rejectReason} " + "</if>" +
            "<if test=\"auditTime != null and auditTime != ''\">" + "and audit_time = #{auditTime} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_user_certification (`status`, `operator`, `realname`, `id_card`, `img_1_url`, `img_2_url`, `img_3_url`, `user_id`, `merchant_id`, `reject_reason`, `audit_time`, `create_time`, `modify_time`, `available`)"
            + "values (#{status}, #{operator}, #{realname}, #{idCard}, #{img1Url}, #{img2Url}, #{img3Url}, #{userId}, #{merchantId}, #{rejectReason}, #{auditTime}, #{createTime}, #{modifyTime}, #{available})")
    int save(UserCertificationDO userCertification);

    @Update("<script>" +
            "update ss_user_certification " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"status != null\">`status` = #{status}, </if>" +
            "<if test=\"operator != null\">`operator` = #{operator}, </if>" +
            "<if test=\"realname != null\">`realname` = #{realname}, </if>" +
            "<if test=\"idCard != null\">`id_card` = #{idCard}, </if>" +
            "<if test=\"img1Url != null\">`img_1_url` = #{img1Url}, </if>" +
            "<if test=\"img2Url != null\">`img_2_url` = #{img2Url}, </if>" +
            "<if test=\"img3Url != null\">`img_3_url` = #{img3Url}, </if>" +
            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"rejectReason != null\">`reject_reason` = #{rejectReason}, </if>" +
            "<if test=\"auditTime != null\">`audit_time` = #{auditTime}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(UserCertificationDO userCertification);

    @Delete("delete from ss_user_certification where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_user_certification where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select("select `id_card` from ss_user_certification where user_id = #{userId} and available=1 and status=2")
    String getIdCardByUserId(String userId);
}
