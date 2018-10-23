package com.zwl.offlineActivityManager.dao;

import java.util.List;
import java.util.Map;

import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.domain.OfflineActivityVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OfflineActivityMapper {

	@Select("select `id`, `activity_address`, `activity_start_time`, `activity_end_time`, `activity_price`, `is_retraining`, `activity_theme_id`, `limit_count`, `buy_count`, `is_recommend`, `is_show`, `is_rebuy`, `is_maid`, `min_requirement`, `merchant_id`, `create_time`, `modify_time`, `available`, `apply_start_time`, `apply_end_time` , `retraining_price` from ss_offline_activity where id = #{id}")
	OfflineActivityDO get(Integer id);
	
	@Select("<script>" +
	"select * from ss_offline_activity " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"activityAddress != null and activityAddress != ''\">"+ "and activity_address like concat('%',#{activityAddress},'%') " + "</if>" +
		  		  "<if test=\"activityStartTime != null and activityStartTime != ''\">"+ "and activity_start_time = #{activityStartTime} " + "</if>" + 
		  		  "<if test=\"activityEndTime != null and activityEndTime != ''\">"+ "and activity_end_time = #{activityEndTime} " + "</if>" + 
		  		  "<if test=\"activityPrice != null and activityPrice != ''\">"+ "and activity_price = #{activityPrice} " + "</if>" + 
		  		  "<if test=\"isRetraining != null and isRetraining != ''\">"+ "and is_retraining = #{isRetraining} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
//		  		  "<if test=\"activityParentId != null and activityParentId != ''\">"+ "and activity_parent_id = #{activityParentId} " + "</if>" +
		  		  "<if test=\"limitCount != null and limitCount != ''\">"+ "and limit_count = #{limitCount} " + "</if>" + 
		  		  "<if test=\"buyCount != null and buyCount != ''\">"+ "and buy_count = #{buyCount} " + "</if>" + 
		  		  "<if test=\"isRecommend != null and isRecommend != ''\">"+ "and is_recommend = #{isRecommend} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" + 
		  		  "<if test=\"isRebuy != null and isRebuy != ''\">"+ "and is_rebuy = #{isRebuy} " + "</if>" + 
		  		  "<if test=\"isMaid != null and isMaid != ''\">"+ "and is_maid = #{isMaid} " + "</if>" + 
		  		  "<if test=\"minRequirement != null and minRequirement != ''\">"+ "and min_requirement = #{minRequirement} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
				"<if test=\"applyStartTime != null and applyStartTime != ''\">"+ "and apply_start_time = #{applyStartTime} " + "</if>" +
				"<if test=\"applyEndTime != null and applyEndTime != ''\">"+ "and apply_end_time = #{applyEndTime} " + "</if>" +
				"<if test=\"retrainingPrice != null and retrainingPrice != ''\">"+ "and retraining_price = #{retrainingPrice} " + "</if>" +
			"</where>"+
			" <choose>" + 
	            "<when test=\"sort != null and sort.trim() != ''\">" + 
	                "order by ${sort} ${order}" + 
	            "</when>" + 
				"<otherwise>" + 
	                "order by id desc" + 
				"</otherwise>" + 
	        "</choose>"+
			"<if test=\"offset != null and limit != null\">"+
			"limit #{offset}, #{limit}" + 
			"</if>"+
			"</script>")
	List<OfflineActivityDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_offline_activity " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"activityAddress != null and activityAddress != ''\">"+ "and activity_address like concat('%',#{activityAddress},'%') " + "</if>" +
		  		  "<if test=\"activityStartTime != null and activityStartTime != ''\">"+ "and activity_start_time = #{activityStartTime} " + "</if>" + 
		  		  "<if test=\"activityEndTime != null and activityEndTime != ''\">"+ "and activity_end_time = #{activityEndTime} " + "</if>" + 
		  		  "<if test=\"activityPrice != null and activityPrice != ''\">"+ "and activity_price = #{activityPrice} " + "</if>" + 
		  		  "<if test=\"isRetraining != null and isRetraining != ''\">"+ "and is_retraining = #{isRetraining} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
//		  		  "<if test=\"activityParentId != null and activityParentId != ''\">"+ "and activity_parent_id = #{activityParentId} " + "</if>" +
		  		  "<if test=\"limitCount != null and limitCount != ''\">"+ "and limit_count = #{limitCount} " + "</if>" + 
		  		  "<if test=\"buyCount != null and buyCount != ''\">"+ "and buy_count = #{buyCount} " + "</if>" + 
		  		  "<if test=\"isRecommend != null and isRecommend != ''\">"+ "and is_recommend = #{isRecommend} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" + 
		  		  "<if test=\"isRebuy != null and isRebuy != ''\">"+ "and is_rebuy = #{isRebuy} " + "</if>" + 
		  		  "<if test=\"isMaid != null and isMaid != ''\">"+ "and is_maid = #{isMaid} " + "</if>" + 
		  		  "<if test=\"minRequirement != null and minRequirement != ''\">"+ "and min_requirement = #{minRequirement} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
				"<if test=\"applyStartTime != null and applyStartTime != ''\">"+ "and apply_start_time = #{applyStartTime} " + "</if>" +
				"<if test=\"applyEndTime != null and applyEndTime != ''\">"+ "and apply_end_time = #{applyEndTime} " + "</if>" +
				"<if test=\"retrainingPrice != null and retrainingPrice != ''\">"+ "and retraining_price = #{retrainingPrice} " + "</if>" +
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_offline_activity (`activity_address`, `activity_start_time`, `activity_end_time`, `activity_price`, `is_retraining`, `activity_theme_id`, `limit_count`, `buy_count`, `is_recommend`, `is_show`, `is_rebuy`, `is_maid`, `min_requirement`, `merchant_id`, `create_time`, `modify_time`, `available`, `apply_start_time`, `apply_end_time`, `retraining_price`)"
	+ "values (#{activityAddress}, #{activityStartTime}, #{activityEndTime}, #{activityPrice}, #{isRetraining}, #{activityThemeId}, #{limitCount}, #{buyCount}, #{isRecommend}, #{isShow}, #{isRebuy}, #{isMaid}, #{minRequirement}, #{merchantId}, #{createTime}, #{modifyTime}, #{available}, #{applyStartTime}, #{applyEndTime}, #{retrainingPrice})")
	int save(OfflineActivityDO offlineActivity);
	
	@Update("<script>"+ 
			"update ss_offline_activity " + 
					"<set>" + 
//		            "<if test=\"id != null\">`id` = #{id}, </if>" +
                    "<if test=\"activityAddress != null\">`activity_address` = #{activityAddress}, </if>" +
                    "<if test=\"activityStartTime != null\">`activity_start_time` = #{activityStartTime}, </if>" + 
                    "<if test=\"activityEndTime != null\">`activity_end_time` = #{activityEndTime}, </if>" + 
                    "<if test=\"activityPrice != null\">`activity_price` = #{activityPrice}, </if>" + 
                    "<if test=\"isRetraining != null\">`is_retraining` = #{isRetraining}, </if>" + 
                    "<if test=\"activityThemeId != null\">`activity_theme_id` = #{activityThemeId}, </if>" + 
//                    "<if test=\"activityParentId != null\">`activity_parent_id` = #{activityParentId}, </if>" +
                    "<if test=\"limitCount != null\">`limit_count` = #{limitCount}, </if>" + 
                    "<if test=\"buyCount != null\">`buy_count` = #{buyCount}, </if>" + 
                    "<if test=\"isRecommend != null\">`is_recommend` = #{isRecommend}, </if>" + 
                    "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" + 
                    "<if test=\"isRebuy != null\">`is_rebuy` = #{isRebuy}, </if>" + 
                    "<if test=\"isMaid != null\">`is_maid` = #{isMaid}, </if>" + 
                    "<if test=\"minRequirement != null\">`min_requirement` = #{minRequirement}, </if>" + 
//                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
//                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//                    "<if test=\"available != null\">`available` = #{available}, </if>" +
				"<if test=\"applyStartTime != null\">`apply_start_time` = #{applyStartTime}, </if>" +
				"<if test=\"applyEndTime != null\">`apply_end_time` = #{applyEndTime}, </if>" +
				"<if test=\"retrainingPrice != null\">`retraining_price` = #{retrainingPrice}, </if>" +
			"</set>" +
					"where id = #{id}"+
			"</script>")
	int update(OfflineActivityDO offlineActivity);
	
	@Update("update ss_offline_activity set available = 0 where id =#{id}")
	int remove(Integer id);
	
	@Update("<script>"+
			"update ss_offline_activity set available = 0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);

	@Select("select id,activity_address from ss_offline_activity where available = 1 and merchant_id = #{merchantId} and activity_theme_id = #{activityThemeId}")
    List<OfflineActivityVo> getActivityItemsList(@Param("merchantId") String merchantId, @Param("activityThemeId")Integer activityThemeId);

	@Select("select theme_name from ss_offline_activity_theme where id = #{activityThemeId}")
	String selectThemeNameByThemeId(Integer activityThemeId);

	@Select("select activity_address from ss_offline_activity where id = #{activityParentId}")
	String selectActivityAddressByActivityParentId(Integer activityParentId);

	@Select("select activity_address from ss_offline_activity where activity_theme_id = #{activityThemeId} and available = 1 limit 2")
    List<String> selectActivityAddressByThemeId(Integer activityThemeId);
}
