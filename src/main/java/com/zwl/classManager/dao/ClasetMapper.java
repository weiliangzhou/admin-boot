package com.zwl.classManager.dao;

import com.zwl.classManager.domain.ClasetDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
@Mapper
public interface ClasetMapper {

    @Select("select `id`, `title`, `banner_url`, `content`, `category_id`, `merchant_id`, `is_show`, `required_member_level`, `create_time`, `modify_time`, `available`, `content_text`, `style`, `is_recommend`, `front_cover` from ss_class_set where id = #{id}")
    ClasetDO get(Long id);

    @Select("<script>" +
            "select * from ss_class_set " +
            "<where>" +
            "available = 1 "+
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"bannerUrl != null and bannerUrl != ''\">" + "and banner_url = #{bannerUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"categoryId != null and categoryId != ''\">" + "and category_id = #{categoryId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"requiredMemberLevel != null and requiredMemberLevel != ''\">" + "and required_member_level = #{requiredMemberLevel} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"style != null and style != ''\">" + "and style = #{style} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"frontCover != null and frontCover != ''\">" + "and front_cover = #{frontCover} " + "</if>" +
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
    List<ClasetDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_class_set " +
            "<where>" +
            "available = 1 "+
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"bannerUrl != null and bannerUrl != ''\">" + "and banner_url = #{bannerUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"categoryId != null and categoryId != ''\">" + "and category_id = #{categoryId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"requiredMemberLevel != null and requiredMemberLevel != ''\">" + "and required_member_level = #{requiredMemberLevel} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"style != null and style != ''\">" + "and style = #{style} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"frontCover != null and frontCover != ''\">" + "and front_cover = #{frontCover} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_class_set (`title`, `banner_url`, `content`, `category_id`, `merchant_id`, `is_show`, `required_member_level`, `create_time`, `available`, `content_text`, `style`, `is_recommend`, `front_cover`)"
            + "values (#{title}, #{bannerUrl}, #{content}, #{categoryId}, #{merchantId}, #{isShow}, #{requiredMemberLevel}, #{createTime}, #{available}, #{contentText}, #{style}, #{isRecommend}, #{frontCover})")
    int save(ClasetDO claset);

    @Update("<script>" +
            "update ss_class_set " +
            "<set>" +
//            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"title != null\">`title` = #{title}, </if>" +
            "<if test=\"bannerUrl != null\">`banner_url` = #{bannerUrl}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"categoryId != null\">`category_id` = #{categoryId}, </if>" +
//            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "<if test=\"requiredMemberLevel != null\">`required_member_level` = #{requiredMemberLevel}, </if>" +
//            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "<if test=\"style != null\">`style` = #{style}, </if>" +
            "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" +
            "<if test=\"frontCover != null\">`front_cover` = #{frontCover}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(ClasetDO claset);

    @Update("update ss_class_set set available = 0 where id =#{id}")
    int remove(Long id);

    @Update("<script>" +
            "update ss_class_set set available = 0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);
}
