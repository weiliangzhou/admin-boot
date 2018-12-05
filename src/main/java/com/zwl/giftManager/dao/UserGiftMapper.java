package com.zwl.giftManager.dao;

import com.zwl.giftManager.domain.UserGiftDO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 15:56:39
 */
@Mapper
public interface UserGiftMapper {

    @Select("select `id`, `user_id`, `gift_id`, `gift_title`, `phone`, `province`, `city`, `area`, `address`, `express_no`, `express_company`, `merchant_id`, `order_state`, `create_time`, `modify_time`, `available`, `real_name` from ss_user_gift where id = #{id}")
    UserGiftDO get(Long id);

    @Select("<script>" +
            "select * from ss_user_gift " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"giftTitle != null and giftTitle != ''\">" + "and gift_title = #{giftTitle} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"province != null and province != ''\">" + "and province = #{province} " + "</if>" +
            "<if test=\"city != null and city != ''\">" + "and city = #{city} " + "</if>" +
            "<if test=\"area != null and area != ''\">" + "and area = #{area} " + "</if>" +
            "<if test=\"address != null and address != ''\">" + "and address = #{address} " + "</if>" +
            "<if test=\"expressNo != null and expressNo != ''\">" + "and express_no = #{expressNo} " + "</if>" +
            "<if test=\"expressCompany != null and expressCompany != ''\">" + "and express_company = #{expressCompany} " + "</if>" +
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
    List<UserGiftDO> list(Map<String, Object> map);

    @Select("<script>" +
            "select count(*) from ss_user_gift " +
            "<where>" +
            "<if test=\"id != null and id != ''\">" + "and id = #{id} " + "</if>" +
            "<if test=\"userId != null and userId != ''\">" + "and user_id = #{userId} " + "</if>" +
            "<if test=\"giftTitle != null and giftTitle != ''\">" + "and gift_title = #{giftTitle} " + "</if>" +
            "<if test=\"phone != null and phone != ''\">" + "and phone = #{phone} " + "</if>" +
            "<if test=\"realName != null and realName != ''\">" + "and real_name = #{realName} " + "</if>" +
            "<if test=\"province != null and province != ''\">" + "and province = #{province} " + "</if>" +
            "<if test=\"city != null and city != ''\">" + "and city = #{city} " + "</if>" +
            "<if test=\"area != null and area != ''\">" + "and area = #{area} " + "</if>" +
            "<if test=\"address != null and address != ''\">" + "and address = #{address} " + "</if>" +
            "<if test=\"expressNo != null and expressNo != ''\">" + "and express_no = #{expressNo} " + "</if>" +
            "<if test=\"expressCompany != null and expressCompany != ''\">" + "and express_company = #{expressCompany} " + "</if>" +
            "<if test=\"createTime != null and createTime != ''\">" + "and create_time = #{createTime} " + "</if>" +
            "<if test=\"modifyTime != null and modifyTime != ''\">" + "and modify_time = #{modifyTime} " + "</if>" +
            "<if test=\"available != null and available != ''\">" + "and available = #{available} " + "</if>" +
            "</where>" +
            "</script>")
    int count(Map<String, Object> map);

    @Insert("insert into ss_user_gift (`user_id`, `gift_title`, `phone`, `province`, `city`, `area`, `address`, `express_no`, `express_company`, `create_time`, `modify_time`, `available`, `real_name`)"
            + "values (#{userId}, #{giftTitle}, #{phone}, #{province}, #{city}, #{area}, #{address}, #{expressNo}, #{expressCompany}, #{createTime}, #{modifyTime}, #{available},#{realName})")
    int save(UserGiftDO userGift);

    @Update("<script>" +
            "update ss_user_gift " +
            "<set>" +
//            "<if test=\"id != null\">`id` = #{id}, </if>" +
//            "<if test=\"userId != null\">`user_id` = #{userId}, </if>" +
//            "<if test=\"giftTitle != null\">`gift_title` = #{giftTitle}, </if>" +
            "<if test=\"phone != null\">`phone` = #{phone}, </if>" +
            "<if test=\"realName != null\">`real_name` = #{realName}, </if>" +
            "<if test=\"province != null\">`province` = #{province}, </if>" +
            "<if test=\"city != null\">`city` = #{city}, </if>" +
            "<if test=\"area != null\">`area` = #{area}, </if>" +
            "<if test=\"address != null\">`address` = #{address}, </if>" +
            "<if test=\"expressNo != null\">`express_no` = #{expressNo}, </if>" +
            "<if test=\"expressCompany != null\">`express_company` = #{expressCompany}, </if>" +
            "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
            "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
            "<if test=\"available != null\">`available` = #{available}, </if>" +
            "</set>" +
            "where id = #{id}" +
            "</script>")
    int update(UserGiftDO userGift);

    @Delete("delete from ss_user_gift where id =#{id}")
    int remove(Long id);

    @Delete("<script>" +
            "delete from ss_user_gift where id in " +
            "<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    int batchRemove(Long[] ids);

    @Update("update ss_user_gift b set b.express_company = #{expressCompany} , b.express_no = #{expressNo} ,b.order_state = 1 where b.id = #{id}")
    int updateShipments(@Param("id") Long id, @Param("expressCompany") Integer expressCompany, @Param("expressNo") String expressNo);
}
