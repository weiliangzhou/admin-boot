package com.zwl.classManager.dao;

import com.zwl.classManager.domain.ClaSetItemVo;
import com.zwl.classManager.domain.ClainfoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
@Mapper
public interface ClainfoMapper {
    @Select("select `id` from ss_class_info where class_set_id = #{id} and available = 1")
    List<ClainfoDO> getListByClassSetId(Long id);

    @Select("select `id`, `class_set_id`, `category_id`, `merchant_id`, `audio_url`, `logo_url`, `title`, `content`, `is_show`, `listen_count`, `create_time`, `modify_time`, `available`, `content_text`, `style`, `is_recommend`, `play_time` from ss_class_info where id = #{id}")
    ClainfoDO get(Long id);

    @Select("<script>" +
            "select * from ss_class_info " +
            "<where>" +
            "available = 1 " +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"classSetId != null and classSetId != ''\">" + "and class_set_id = #{classSetId} " + "</if>" +
            "<if test=\"categoryId != null and categoryId != ''\">" + "and category_id = #{categoryId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"audioUrl != null and audioUrl != ''\">" + "and audio_url = #{audioUrl} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"listenCount != null and listenCount != ''\">" + "and listen_count = #{listenCount} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"style != null and style != ''\">" + "and style = #{style} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"playTime != null and playTime != ''\">" + "and play_time = #{playTime} " + "</if>" +
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
    List<ClainfoDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_class_info " +
            "<where>" +
            "available = 1 " +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"classSetId != null and classSetId != ''\">" + "and class_set_id = #{classSetId} " + "</if>" +
            "<if test=\"categoryId != null and categoryId != ''\">" + "and category_id = #{categoryId} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"audioUrl != null and audioUrl != ''\">" + "and audio_url = #{audioUrl} " + "</if>" +
            "<if test=\"logoUrl != null and logoUrl != ''\">" + "and logo_url = #{logoUrl} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"listenCount != null and listenCount != ''\">" + "and listen_count = #{listenCount} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"style != null and style != ''\">" + "and style = #{style} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"playTime != null and playTime != ''\">" + "and play_time = #{playTime} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_class_info (`class_set_id`, `category_id`, `merchant_id`, `audio_url`, `logo_url`, `title`, `content`, `is_show`, `listen_count`, `create_time`, `available`, `content_text`, `style`, `is_recommend`, `play_time`)"
            + "values (#{classSetId}, #{categoryId}, #{merchantId}, #{audioUrl}, #{logoUrl}, #{title}, #{content}, #{isShow}, #{listenCount}, #{createTime}, #{available}, #{contentText}, #{style}, #{isRecommend}, #{playTime})")
    int save(ClainfoDO clainfo);

    @Update("<script>" +
            "update ss_class_info " +
            "<set>" +
//            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"classSetId != null\">`class_set_id` = #{classSetId}, </if>" +
            "<if test=\"categoryId != null\">`category_id` = #{categoryId}, </if>" +
//            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"audioUrl != null\">`audio_url` = #{audioUrl}, </if>" +
            "<if test=\"logoUrl != null\">`logo_url` = #{logoUrl}, </if>" +
            "<if test=\"title != null\">`title` = #{title}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "<if test=\"listenCount != null\">`listen_count` = #{listenCount}, </if>" +
//            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "<if test=\"style != null\">`style` = #{style}, </if>" +
            "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" +
            "<if test=\"playTime != null\">`play_time` = #{playTime}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(ClainfoDO clainfo);

    @Update("update ss_class_info set available = 0 where id =#{id}")
    int remove(Long id);

    @Update("<script>" +
            "update ss_class_info set available = 0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select("select id,title from ss_class_set where available = 1 and merchant_id = #{merchantId} and category_id =#{categoryId}")
    List<ClaSetItemVo> getClassSetItemList(@Param("categoryId") Integer categoryId, @Param("merchantId") String merchantId);

    @Select("select title from ss_class_set where  id =#{classSetId} and available =1")
    String getClassNameByClassSet(Integer classSetId);
}
