package com.zwl.offlineActivityThemeManager.dao;

import java.util.List;
import java.util.Map;

import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeItemVo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OfflineActivityThemeMapper {

	@Select("select `id`, `theme_name`, `theme_href_url`, `theme_type`, `content`, `content_text`, `create_time`, `modify_time`, `available`, `merchant_id` from ss_offline_activity_theme where id = #{id}")
	OfflineActivityThemeDO get(Integer id);
	
	@Select("<script>" +
	"select * from ss_offline_activity_theme " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"themeName != null and themeName != ''\">"+ "and theme_name = #{themeName} " + "</if>" + 
		  		  "<if test=\"themeHrefUrl != null and themeHrefUrl != ''\">"+ "and theme_href_url = #{themeHrefUrl} " + "</if>" + 
		  		  "<if test=\"themeType != null and themeType != ''\">"+ "and theme_type = #{themeType} " + "</if>" + 
		  		  "<if test=\"content != null and content != ''\">"+ "and content = #{content} " + "</if>" + 
		  		  "<if test=\"contentText != null and contentText != ''\">"+ "and content_text = #{contentText} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
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
	List<OfflineActivityThemeDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_offline_activity_theme " + 
			"<where>" + 
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"themeName != null and themeName != ''\">"+ "and theme_name = #{themeName} " + "</if>" + 
		  		  "<if test=\"themeHrefUrl != null and themeHrefUrl != ''\">"+ "and theme_href_url = #{themeHrefUrl} " + "</if>" + 
		  		  "<if test=\"themeType != null and themeType != ''\">"+ "and theme_type = #{themeType} " + "</if>" + 
		  		  "<if test=\"content != null and content != ''\">"+ "and content = #{content} " + "</if>" + 
		  		  "<if test=\"contentText != null and contentText != ''\">"+ "and content_text = #{contentText} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" + 
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_offline_activity_theme (`theme_name`, `theme_href_url`, `theme_type`, `content`, `content_text`, `create_time`, `modify_time`, `available`, `merchant_id`)"
	+ "values (#{themeName}, #{themeHrefUrl}, #{themeType}, #{content}, #{contentText}, #{createTime}, #{modifyTime}, #{available}, #{merchantId})")
	int save(OfflineActivityThemeDO offlineActivityTheme);
	
	@Update("<script>"+ 
			"update ss_offline_activity_theme " + 
					"<set>" + 
//		            "<if test=\"id != null\">`id` = #{id}, </if>" +
                    "<if test=\"themeName != null\">`theme_name` = #{themeName}, </if>" + 
                    "<if test=\"themeHrefUrl != null\">`theme_href_url` = #{themeHrefUrl}, </if>" + 
                    "<if test=\"themeType != null\">`theme_type` = #{themeType}, </if>" + 
                    "<if test=\"content != null\">`content` = #{content}, </if>" + 
                    "<if test=\"contentText != null\">`content_text` = #{contentText}, </if>" + 
//                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//                    "<if test=\"available != null\">`available` = #{available}, </if>" +
//                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(OfflineActivityThemeDO offlineActivityTheme);
	
	@Update("update ss_offline_activity_theme set available = 0 where id =#{id}")
	int remove(Integer id);
	
	@Update("<script>"+
			"update ss_offline_activity_theme set available = 0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);

	@Select("select id,theme_name from ss_offline_activity_theme where available = 1 and merchant_id = #{merchantId}")
	List<OfflineActivityThemeItemVo> getActivityThemeItemsList(@Param("merchantId") String merchantId);

}
