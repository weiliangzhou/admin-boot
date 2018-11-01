package com.zwl.giftManager.dao;

import com.zwl.giftManager.domain.GiftDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-01 13:57:43
 */
@Mapper
public interface GiftMapper {

    @Select("select `id`, `gift_main_title`, `gift_vice_title`, `min_requirement`, `gift_main_img`, `gift_vice_img_1`, `gift_vice_img_2`, `gift_vice_img_3`, `price`, `express_fee`, `stock`, `gift_desc`, `is_recommend`, `is_show`, `merchant_id`, `create_time`, `modify_time`, `available`, `buy_count` from ss_gift where id = #{id}")
    GiftDO get(Long id);

    @Select("<script>" +
            "select * from ss_gift " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"giftMainTitle != null and giftMainTitle != ''\">" + "and gift_main_title = #{giftMainTitle} " + "</if>" +
            "<if test=\"giftViceTitle != null and giftViceTitle != ''\">" + "and gift_vice_title = #{giftViceTitle} " + "</if>" +
            "<if test=\"minRequirement != null and minRequirement != ''\">" + "and min_requirement = #{minRequirement} " + "</if>" +
            "<if test=\"giftMainImg != null and giftMainImg != ''\">" + "and gift_main_img = #{giftMainImg} " + "</if>" +
            "<if test=\"giftViceImg1 != null and giftViceImg1 != ''\">" + "and gift_vice_img_1 = #{giftViceImg1} " + "</if>" +
            "<if test=\"giftViceImg2 != null and giftViceImg2 != ''\">" + "and gift_vice_img_2 = #{giftViceImg2} " + "</if>" +
            "<if test=\"giftViceImg3 != null and giftViceImg3 != ''\">" + "and gift_vice_img_3 = #{giftViceImg3} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"expressFee != null and expressFee != ''\">" + "and express_fee = #{expressFee} " + "</if>" +
            "<if test=\"stock != null and stock != ''\">" + "and stock = #{stock} " + "</if>" +
            "<if test=\"giftDesc != null and giftDesc != ''\">" + "and gift_desc = #{giftDesc} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
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
    List<GiftDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_gift " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"giftMainTitle != null and giftMainTitle != ''\">" + "and gift_main_title = #{giftMainTitle} " + "</if>" +
            "<if test=\"giftViceTitle != null and giftViceTitle != ''\">" + "and gift_vice_title = #{giftViceTitle} " + "</if>" +
            "<if test=\"minRequirement != null and minRequirement != ''\">" + "and min_requirement = #{minRequirement} " + "</if>" +
            "<if test=\"giftMainImg != null and giftMainImg != ''\">" + "and gift_main_img = #{giftMainImg} " + "</if>" +
            "<if test=\"giftViceImg1 != null and giftViceImg1 != ''\">" + "and gift_vice_img_1 = #{giftViceImg1} " + "</if>" +
            "<if test=\"giftViceImg2 != null and giftViceImg2 != ''\">" + "and gift_vice_img_2 = #{giftViceImg2} " + "</if>" +
            "<if test=\"giftViceImg3 != null and giftViceImg3 != ''\">" + "and gift_vice_img_3 = #{giftViceImg3} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"expressFee != null and expressFee != ''\">" + "and express_fee = #{expressFee} " + "</if>" +
            "<if test=\"stock != null and stock != ''\">" + "and stock = #{stock} " + "</if>" +
            "<if test=\"giftDesc != null and giftDesc != ''\">" + "and gift_desc = #{giftDesc} " + "</if>" +
            "<if test=\"isRecommend != null and isRecommend != ''\">" + "and is_recommend = #{isRecommend} " + "</if>" +
            "<if test=\"isShow != null and isShow != ''\">" + "and is_show = #{isShow} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_gift (`gift_main_title`, `gift_vice_title`, `min_requirement`, `gift_main_img`, `gift_vice_img_1`, `gift_vice_img_2`, `gift_vice_img_3`, `price`, `express_fee`, `stock`, `gift_desc`, `is_recommend`, `is_show`, `merchant_id`, `create_time`, `modify_time`, `available`, `buy_count`)"
            + "values (#{giftMainTitle}, #{giftViceTitle}, #{minRequirement}, #{giftMainImg}, #{giftViceImg1}, #{giftViceImg2}, #{giftViceImg3}, #{price}, #{expressFee}, #{stock}, #{giftDesc}, #{isRecommend}, #{isShow}, #{merchantId}, #{createTime}, #{modifyTime}, #{available}, #{buyCount})")
    int save(GiftDO gift);

    @Update("<script>" +
            "update ss_gift " +
            "<set>" +
            "<if test=\"id != null\">`id` = #{id}, </if>" +
            "<if test=\"giftMainTitle != null\">`gift_main_title` = #{giftMainTitle}, </if>" +
            "<if test=\"giftViceTitle != null\">`gift_vice_title` = #{giftViceTitle}, </if>" +
            "<if test=\"minRequirement != null\">`min_requirement` = #{minRequirement}, </if>" +
            "<if test=\"giftMainImg != null\">`gift_main_img` = #{giftMainImg}, </if>" +
            "<if test=\"giftViceImg1 != null\">`gift_vice_img_1` = #{giftViceImg1}, </if>" +
            "<if test=\"giftViceImg2 != null\">`gift_vice_img_2` = #{giftViceImg2}, </if>" +
            "<if test=\"giftViceImg3 != null\">`gift_vice_img_3` = #{giftViceImg3}, </if>" +
            "<if test=\"price != null\">`price` = #{price}, </if>" +
            "<if test=\"expressFee != null\">`express_fee` = #{expressFee}, </if>" +
            "<if test=\"stock != null\">`stock` = #{stock}, </if>" +
            "<if test=\"giftDesc != null\">`gift_desc` = #{giftDesc}, </if>" +
            "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" +
            "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
            "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "<if test=\"buyCount != null\">`buy_count` = #{buyCount}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(GiftDO gift);

    @Delete("delete from ss_gift where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_gift where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);
}
