package com.zwl.iconManager.dao;

import java.util.List;
import java.util.Map;

import com.zwl.iconManager.domain.IconDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 16:49:09
 */
@Mapper
public interface IconMapper {

	@Select("select `id`, `title`, `picture_url`, `href_url`, `href_type`, `available`, `merchant_id`, `create_time`, `modify_time`, `port_type` from ss_icon where id = #{id}")
	IconDO get(Integer id);
	
	@Select("<script>" +
	"select * from ss_icon " + 
			"<where>" +
				 "available = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"title != null and title != ''\">"+ "and title = #{title} " + "</if>" + 
		  		  "<if test=\"pictureUrl != null and pictureUrl != ''\">"+ "and picture_url = #{pictureUrl} " + "</if>" + 
		  		  "<if test=\"hrefUrl != null and hrefUrl != ''\">"+ "and href_url = #{hrefUrl} " + "</if>" + 
//		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" +
					"<if test=\"portType != null and portType != ''\">"+ "and port_type = #{portType} " + "</if>" +
			"</where>"+
//			" <choose>" +
//	            "<when test=\"sort != null and sort.trim() != ''\">" +
//	                "order by ${sort} ${order}" +
//	            "</when>" +
//				"<otherwise>" +
//	                "order by id desc" +
//				"</otherwise>" +
//	        "</choose>"+
//			"<if test=\"offset != null and limit != null\">"+
//			"limit #{offset}, #{limit}" +
//			"</if>"+
			"</script>")
	List<IconDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_icon " + 
			"<where>" +
					"available = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"title != null and title != ''\">"+ "and title = #{title} " + "</if>" + 
		  		  "<if test=\"pictureUrl != null and pictureUrl != ''\">"+ "and picture_url = #{pictureUrl} " + "</if>" + 
		  		  "<if test=\"hrefUrl != null and hrefUrl != ''\">"+ "and href_url = #{hrefUrl} " + "</if>" + 
//		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" +
					"<if test=\"portType != null and portType != ''\">"+ "and port_type = #{portType} " + "</if>" +
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_icon (`title`, `picture_url`, `href_url`, `href_type`, `available`, `merchant_id`, `create_time`, `port_type`)"
	+ "values (#{title}, #{pictureUrl}, #{hrefUrl}, #{hrefType}, #{available}, #{merchantId}, #{createTime}, #{portType})")
	int save(IconDO icon);
	
	@Update("<script>"+ 
			"update ss_icon " + 
					"<set>" + 
//		            "<if test=\"id != null\">`id` = #{id}, </if>" +
                    "<if test=\"title != null\">`title` = #{title}, </if>" + 
                    "<if test=\"pictureUrl != null\">`picture_url` = #{pictureUrl}, </if>" + 
                    "<if test=\"hrefUrl != null\">`href_url` = #{hrefUrl}, </if>" +
					"<if test=\"hrefType != null\">`href_type` = #{hrefType}, </if>" +
					"<if test=\"portType != null\">`port_type` = #{portType}, </if>" +
//                    "<if test=\"available != null\">`available` = #{available}, </if>" +
//                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
//                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(IconDO icon);
	
	@Update("update ss_icon set available = 0 where id =#{id}")
	int remove(Integer id);
	
	@Update("<script>"+
			"update ss_icon set available = 0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
