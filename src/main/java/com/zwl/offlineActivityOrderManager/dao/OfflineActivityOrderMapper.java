package com.zwl.offlineActivityOrderManager.dao;

import java.util.List;
import java.util.Map;

import com.zwl.offlineActivityOrderManager.domain.OfflineActivityOrderDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OfflineActivityOrderMapper {

	@Select("select `order_no`, `activity_id`, `activity_theme_id`, `activity_code`, `activity_price`, `actual_money`, `order_status`, `user_id`, `sex`, `phone`, `real_name`, `city`, `id_card_num`, `payment_no`, `payment_time`, `merchant_id`, `create_time`, `modify_time`, `available`, `is_maid`, `is_retraining` from ss_offline_activity_order where order_no = #{id}")
	OfflineActivityOrderDO get(String orderNo);
	
	@Select("<script>" +
	"select * from ss_offline_activity_order " + 
			"<where>" + 
		  		  "<if test=\"orderNo != null and orderNo != ''\">"+ "and order_no = #{orderNo} " + "</if>" + 
		  		  "<if test=\"activityId != null and activityId != ''\">"+ "and activity_id = #{activityId} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
		  		  "<if test=\"activityCode != null and activityCode != ''\">"+ "and activity_code = #{activityCode} " + "</if>" + 
		  		  "<if test=\"activityPrice != null and activityPrice != ''\">"+ "and activity_price = #{activityPrice} " + "</if>" + 
		  		  "<if test=\"actualMoney != null and actualMoney != ''\">"+ "and actual_money = #{actualMoney} " + "</if>" + 
		  		  "<if test=\"orderStatus != null and orderStatus != ''\">"+ "and order_status = #{orderStatus} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"sex != null and sex != ''\">"+ "and sex = #{sex} " + "</if>" + 
		  		  "<if test=\"phone != null and phone != ''\">"+ "and phone like concat('%',#{phone},'%') " + "</if>" +
		  		  "<if test=\"realName != null and realName != ''\">"+ "and real_name like concat('%',#{realName},'%') " + "</if>" +
		  		  "<if test=\"city != null and city != ''\">"+ "and city = #{city} " + "</if>" + 
		  		  "<if test=\"idCardNum != null and idCardNum != ''\">"+ "and id_card_num = #{idCardNum} " + "</if>" + 
		  		  "<if test=\"paymentNo != null and paymentNo != ''\">"+ "and payment_no = #{paymentNo} " + "</if>" + 
		  		  "<if test=\"paymentTime != null and paymentTime != ''\">"+ "and payment_time = #{paymentTime} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" + 
		  		  "<if test=\"isMaid != null and isMaid != ''\">"+ "and is_maid = #{isMaid} " + "</if>" + 
		  		  "<if test=\"isRetraining != null and isRetraining != ''\">"+ "and is_retraining = #{isRetraining} " + "</if>" + 
		  			"</where>"+ 
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by order_no desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<OfflineActivityOrderDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_offline_activity_order " + 
			"<where>" + 
		  		  "<if test=\"orderNo != null and orderNo != ''\">"+ "and order_no = #{orderNo} " + "</if>" + 
		  		  "<if test=\"activityId != null and activityId != ''\">"+ "and activity_id = #{activityId} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
		  		  "<if test=\"activityCode != null and activityCode != ''\">"+ "and activity_code = #{activityCode} " + "</if>" + 
		  		  "<if test=\"activityPrice != null and activityPrice != ''\">"+ "and activity_price = #{activityPrice} " + "</if>" + 
		  		  "<if test=\"actualMoney != null and actualMoney != ''\">"+ "and actual_money = #{actualMoney} " + "</if>" + 
		  		  "<if test=\"orderStatus != null and orderStatus != ''\">"+ "and order_status = #{orderStatus} " + "</if>" + 
		  		  "<if test=\"userId != null and userId != ''\">"+ "and user_id = #{userId} " + "</if>" + 
		  		  "<if test=\"sex != null and sex != ''\">"+ "and sex = #{sex} " + "</if>" + 
		  		  "<if test=\"phone != null and phone != ''\">"+ "and phone = #{phone} " + "</if>" + 
		  		  "<if test=\"realName != null and realName != ''\">"+ "and real_name = #{realName} " + "</if>" + 
		  		  "<if test=\"city != null and city != ''\">"+ "and city = #{city} " + "</if>" + 
		  		  "<if test=\"idCardNum != null and idCardNum != ''\">"+ "and id_card_num = #{idCardNum} " + "</if>" + 
		  		  "<if test=\"paymentNo != null and paymentNo != ''\">"+ "and payment_no = #{paymentNo} " + "</if>" + 
		  		  "<if test=\"paymentTime != null and paymentTime != ''\">"+ "and payment_time = #{paymentTime} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" + 
		  		  "<if test=\"isMaid != null and isMaid != ''\">"+ "and is_maid = #{isMaid} " + "</if>" + 
		  		  "<if test=\"isRetraining != null and isRetraining != ''\">"+ "and is_retraining = #{isRetraining} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_offline_activity_order (`order_no`, `activity_id`, `activity_theme_id`, `activity_code`, `activity_price`, `actual_money`, `order_status`, `user_id`, `sex`, `phone`, `real_name`, `city`, `id_card_num`, `payment_no`, `payment_time`, `merchant_id`, `create_time`, `modify_time`, `available`, `is_maid`, `is_retraining`)"
	+ "values (#{orderNo}, #{activityId}, #{activityThemeId}, #{activityCode}, #{activityPrice}, #{actualMoney}, #{orderStatus}, #{userId}, #{sex}, #{phone}, #{realName}, #{city}, #{idCardNum}, #{paymentNo}, #{paymentTime}, #{merchantId}, #{createTime}, #{modifyTime}, #{available}, #{isMaid}, #{isRetraining})")
	int save(OfflineActivityOrderDO offlineActivityOrder);
	
	@Update("<script>"+ 
			"update ss_offline_activity_order " + 
					"<set>" + 
		            "<if test=\"orderNo != null\">`order_no` = #{orderNo}, </if>" + 
                    "<if test=\"activityId != null\">`activity_id` = #{activityId}, </if>" + 
                    "<if test=\"activityThemeId != null\">`activity_theme_id` = #{activityThemeId}, </if>" + 
                    "<if test=\"activityCode != null\">`activity_code` = #{activityCode}, </if>" + 
                    "<if test=\"activityPrice != null\">`activity_price` = #{activityPrice}, </if>" + 
                    "<if test=\"actualMoney != null\">`actual_money` = #{actualMoney}, </if>" + 
                    "<if test=\"orderStatus != null\">`order_status` = #{orderStatus}, </if>" + 
                    "<if test=\"userId != null\">`user_id` = #{userId}, </if>" + 
                    "<if test=\"sex != null\">`sex` = #{sex}, </if>" + 
                    "<if test=\"phone != null\">`phone` = #{phone}, </if>" + 
                    "<if test=\"realName != null\">`real_name` = #{realName}, </if>" + 
                    "<if test=\"city != null\">`city` = #{city}, </if>" + 
                    "<if test=\"idCardNum != null\">`id_card_num` = #{idCardNum}, </if>" + 
                    "<if test=\"paymentNo != null\">`payment_no` = #{paymentNo}, </if>" + 
                    "<if test=\"paymentTime != null\">`payment_time` = #{paymentTime}, </if>" + 
                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" + 
                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" + 
                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" + 
                    "<if test=\"available != null\">`available` = #{available}, </if>" + 
                    "<if test=\"isMaid != null\">`is_maid` = #{isMaid}, </if>" + 
                    "<if test=\"isRetraining != null\">`is_retraining` = #{isRetraining}, </if>" + 
          					"</set>" + 
					"where order_no = #{orderNo}"+
			"</script>")
	int update(OfflineActivityOrderDO offlineActivityOrder);
	
	@Delete("delete from ss_offline_activity_order where order_no =#{orderNo}")
	int remove(String order_no);
	
	@Delete("<script>"+ 
			"delete from ss_offline_activity_order where order_no in " + 
					"<foreach item=\"orderNo\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{orderNo}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(String[] orderNos);

	@Select("select count(*) from ss_offline_activity_order where activity_theme_id = #{activityThemeId} and order_status = 1")
    Integer selectOrderCountByThemeId(Integer activityThemeId);
}
