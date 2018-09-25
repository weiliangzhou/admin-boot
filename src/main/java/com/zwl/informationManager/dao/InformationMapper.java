package com.zwl.informationManager.dao;

import com.zwl.informationManager.domain.InformationDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-30 15:44:24
 */
@Mapper
public interface InformationMapper {

    @Select("select `id`, `merchant_id`, `url`, `is_show`, `title`, `logo_url`, `audio_url`, `content`, `create_time`, `modify_time`, `available`, `content_text` from ss_information where id = #{id}")
    InformationDO get(Integer id);

    @Select("<script>" +
            "select * from ss_information " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"url != null and url != ''\">" + "and url = #{url} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title = #{title} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"audioUrl != null and audioUrl != ''\">" + "and audio_url = #{audioUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
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
    List<InformationDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_information " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"url != null and url != ''\">" + "and url = #{url} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title = #{title} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"audioUrl != null and audioUrl != ''\">" + "and audio_url = #{audioUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"minTime != null and minTime != ''\">" + "and  <![CDATA[ create_time>= #{minTime} ]]>" + "</if>" +
            "<if test=\"maxTime != null and maxTime != ''\">" + "and  <![CDATA[ create_time<= #{maxTime} ]]>" + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_information (`merchant_id`, `url`, `is_show`, `title`, `logo_url`, `audio_url`, `content`, `create_time`, `available`, `content_text`)"
            + "values (#{merchantId}, #{url}, #{isShow}, #{title}, #{logoUrl}, #{audioUrl}, #{content}, now(), #{available}, #{contentText})")
    int save(InformationDO information);

    @Update("<script>" +
            "update ss_information " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"url != null\">`url` = #{url}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "<if test=\"title != null\">`title` = #{title}, </if>" +
            "<if test=\"logoUrl != null\">`logo_url` = #{logoUrl}, </if>" +
            "<if test=\"audioUrl != null\">`audio_url` = #{audioUrl}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(InformationDO information);

    @Update("update  ss_information  set available = 0 where id =#{id}")
    int remove(Integer id);

    @Update("<script>" +
            "update  ss_information set available = 0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Integer[] ids);
}
