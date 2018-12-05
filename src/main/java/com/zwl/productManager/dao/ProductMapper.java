package com.zwl.productManager.dao;

import com.zwl.productManager.domain.ProductDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:00:27
 */
@Mapper
public interface ProductMapper {

    @Select("select `id`, `level`, `level_name`, `product_name`, `maid_percent`, `validity_time`, `price`, `merchant_id`, `image_url`, `content`, `content_text`, `buy_count`, `create_time`, `modify_time`, `available` from saas_product where id = #{id}")
    ProductDO get(Long id);

    @Select("<script>" +
            "select * from saas_product " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"validityTime != null and validityTime != ''\">" + "and validity_time = #{validityTime} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"imageUrl != null and imageUrl != ''\">" + "and image_url = #{imageUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
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
    List<ProductDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from saas_product " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"level != null and level != ''\">" + "and level = #{level} " + "</if>" +
            "<if test=\"levelName != null and levelName != ''\">" + "and level_name = #{levelName} " + "</if>" +
            "<if test=\"productName != null and productName != ''\">" + "and product_name = #{productName} " + "</if>" +
            "<if test=\"maidPercent != null and maidPercent != ''\">" + "and maid_percent = #{maidPercent} " + "</if>" +
            "<if test=\"validityTime != null and validityTime != ''\">" + "and validity_time = #{validityTime} " + "</if>" +
            "<if test=\"price != null and price != ''\">" + "and price = #{price} " + "</if>" +
            "<if test=\"merchantId != null and merchantId != ''\">" + "and merchant_id = #{merchantId} " + "</if>" +
            "<if test=\"imageUrl != null and imageUrl != ''\">" + "and image_url = #{imageUrl} " + "</if>" +
            "<if test=\"content != null and content != ''\">" + "and content = #{content} " + "</if>" +
            "<if test=\"contentText != null and contentText != ''\">" + "and content_text = #{contentText} " + "</if>" +
            "<if test=\"buyCount != null and buyCount != ''\">" + "and buy_count = #{buyCount} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into saas_product (`level`, `level_name`, `product_name`, `maid_percent`, `validity_time`, `price`, `merchant_id`, `image_url`, `content`, `content_text`, `buy_count`, `create_time`, `modify_time`, `available`)"
            + "values (#{level}, #{levelName}, #{productName}, #{maidPercent}, #{validityTime}, #{price}, #{merchantId}, #{imageUrl}, #{content}, #{contentText}, #{buyCount}, #{createTime}, #{modifyTime}, #{available})")
    int save(ProductDO product);

    @Update("<script>" +
            "update saas_product " +
            "<set>" +
            "<if test=\"levelName != null\">`level_name` = #{levelName}, </if>" +
            "<if test=\"productName != null\">`product_name` = #{productName}, </if>" +
            "<if test=\"maidPercent != null\">`maid_percent` = #{maidPercent}, </if>" +
            "<if test=\"validityTime != null\">`validity_time` = #{validityTime}, </if>" +
            "<if test=\"price != null\">`price` = #{price}, </if>" +
            "<if test=\"imageUrl != null\">`image_url` = #{imageUrl}, </if>" +
            "<if test=\"content != null\">`content` = #{content}, </if>" +
            "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" +
            "<if test=\"buyCount != null\">`buy_count` = #{buyCount}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(ProductDO product);

    @Delete("delete from saas_product where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from saas_product where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Select("select * from saas_product  where `level`=#{referrerLevel} and available =1  and merchant_id=#{merchantId}")
    ProductDO getProductByLevel(@Param("referrerLevel") Integer referrerLevel, @Param("merchantId") String merchantId);
}
