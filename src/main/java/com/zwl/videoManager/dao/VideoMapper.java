package com.zwl.videoManager.dao;

import com.zwl.videoManager.domain.VideoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 11:15:51
 */
@Mapper
public interface VideoMapper {

    @Select("select `id`, `image_url`, `video_url`, `title`, `content`, `content_text`, `play_time`, `merchant_id`, `create_time`, `modify_time`, `available`, `is_recommend`, `is_show` from ss_video where id = #{id}")
    VideoDO get(Integer id);

    @Select("<script>" +
            "select * from ss_video " +
            "<where>" +
            "available = 1 "+
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"imageUrl != null and imageUrl != ''\">" + "and image_url = #{imageUrl} " + "</if>" +
            "<if test=\"videoUrl != null and videoUrl != ''\">" + "and video_url = #{videoUrl} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"playTime != null and playTime != ''\">" + "and play_time = #{playTime} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
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
    List<VideoDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_video " +
            "<where>" +
            "available = 1 "+
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"imageUrl != null and imageUrl != ''\">" + "and image_url = #{imageUrl} " + "</if>" +
            "<if test=\"videoUrl != null and videoUrl != ''\">" + "and video_url = #{videoUrl} " + "</if>" +
            "<if test=\"title != null and title != ''\">" + "and title like concat('%',#{title},'%') " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"playTime != null and playTime != ''\">" + "and play_time = #{playTime} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
//            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_video (`image_url`, `video_url`, `title`, `content`, `content_text`, `play_time`, `merchant_id`, `create_time`, `available`, `is_recommend`, `is_show`)"
            + "values (#{imageUrl}, #{videoUrl}, #{title}, #{content}, #{contentText}, #{playTime}, #{merchantId}, #{createTime}, #{available}, #{isRecommend}, #{isShow})")
    int save(VideoDO video);

    @Update("<script>" +
            "update ss_video " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"imageUrl != null\">`image_url` = #{imageUrl}, </if>" +
            "<if test=\"videoUrl != null\">`video_url` = #{videoUrl}, </if>" +
            "<if test=\"title != null\">`title` = #{title}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "<if test=\"playTime != null\">`play_time` = #{playTime}, </if>" +
//            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
//            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(VideoDO video);

    @Update("update ss_video set available = 0 where id =#{id}")
    int remove(Integer id);

    @Update("<script>" +
            "update ss_video set available = 0 where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Integer[] ids);
}
