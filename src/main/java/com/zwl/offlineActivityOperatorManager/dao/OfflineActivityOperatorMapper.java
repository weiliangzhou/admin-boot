package com.zwl.offlineActivityOperatorManager.dao;

import java.util.List;
import java.util.Map;

import com.zwl.offlineActivityOperatorManager.domain.OfflineActivityOperatorDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OfflineActivityOperatorMapper {

	@Select("select `id`, `operator`, `password`, `activity_theme_id`, `merchant_id`, `create_time`, `modify_time`, `available` from ss_offline_activity_operator where id = #{id}")
	OfflineActivityOperatorDO get(Integer id);
	
	@Select("<script>" +
	"select * from ss_offline_activity_operator " + 
			"<where>" +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"operator != null and operator != ''\">"+ "and operator = #{operator} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
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
	List<OfflineActivityOperatorDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_offline_activity_operator " + 
			"<where>" +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"operator != null and operator != ''\">"+ "and operator = #{operator} " + "</if>" + 
		  		  "<if test=\"password != null and password != ''\">"+ "and password = #{password} " + "</if>" + 
		  		  "<if test=\"activityThemeId != null and activityThemeId != ''\">"+ "and activity_theme_id = #{activityThemeId} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_offline_activity_operator (`operator`, `password`, `activity_theme_id`, `merchant_id`, `create_time`, `modify_time`, `available`)"
	+ "values (#{operator}, #{password}, #{activityThemeId}, #{merchantId}, #{createTime}, #{modifyTime}, #{available})")
	int save(OfflineActivityOperatorDO offlineActivityOperator);
	
	@Update("<script>"+ 
			"update ss_offline_activity_operator " + 
					"<set>" + 
//		            "<if test=\"id != null\">`id` = #{id}, </if>" +
                    "<if test=\"operator != null\">`operator` = #{operator}, </if>" + 
                    "<if test=\"password != null\">`password` = #{password}, </if>" + 
                    "<if test=\"activityThemeId != null\">`activity_theme_id` = #{activityThemeId}, </if>" + 
//                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
//                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//                    "<if test=\"available != null\">`available` = #{available}, </if>" +
          			"</set>" +
					"where id = #{id}"+
			"</script>")
	int update(OfflineActivityOperatorDO offlineActivityOperator);
	
	@Update("update ss_offline_activity_operator set available = 0 where id =#{id}")
	int remove(Integer id);
	
	@Update("<script>"+
			"update ss_offline_activity_operator set available = 0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
