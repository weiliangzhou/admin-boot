package com.zwl.bannerManager.dao;

import com.zwl.bannerManager.domain.BannerDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-03 09:55:26
 */
@Mapper
public interface BannerMapper {

	@Select("select `id`, `image_url`, `href_url`, `href_type`, `theme`, `queue_number`, `description`, `create_time`, `modify_time`, `available`, `merchant_id`, `is_show`, `port_type` from ss_banner where id = #{id}")
	BannerDO get(Integer id);
	
	@Select("<script>" +
	"select * from ss_banner " + 
			"<where>" +
				"available = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"imageUrl != null and imageUrl != ''\">"+ "and image_url = #{imageUrl} " + "</if>" + 
		  		  "<if test=\"hrefUrl != null and hrefUrl != ''\">"+ "and href_url = #{hrefUrl} " + "</if>" + 
		  		  "<if test=\"hrefType != null and hrefType != ''\">"+ "and href_type = #{hrefType} " + "</if>" + 
		  		  "<if test=\"theme != null and theme != ''\">"+ "and theme = #{theme} " + "</if>" + 
		  		  "<if test=\"queueNumber != null and queueNumber != ''\">"+ "and queue_number = #{queueNumber} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
//		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" +
					"<if test=\"portType != null and portType != ''\">"+ "and port_type = #{portType} " + "</if>" +
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
	List<BannerDO> list(Map<String, Object> map);
	
	@Select("<script>" +
	"select count(*) from ss_banner " + 
			"<where>" +
				"available = 1 " +
		  		  "<if test=\"id != null and id != ''\">"+ "and id = #{id} " + "</if>" + 
		  		  "<if test=\"imageUrl != null and imageUrl != ''\">"+ "and image_url = #{imageUrl} " + "</if>" + 
		  		  "<if test=\"hrefUrl != null and hrefUrl != ''\">"+ "and href_url = #{hrefUrl} " + "</if>" + 
		  		  "<if test=\"hrefType != null and hrefType != ''\">"+ "and href_type = #{hrefType} " + "</if>" + 
		  		  "<if test=\"theme != null and theme != ''\">"+ "and theme = #{theme} " + "</if>" + 
		  		  "<if test=\"queueNumber != null and queueNumber != ''\">"+ "and queue_number = #{queueNumber} " + "</if>" + 
		  		  "<if test=\"description != null and description != ''\">"+ "and description = #{description} " + "</if>" + 
		  		  "<if test=\"createTime != null and createTime != ''\">"+ "and create_time = #{createTime} " + "</if>" + 
		  		  "<if test=\"modifyTime != null and modifyTime != ''\">"+ "and modify_time = #{modifyTime} " + "</if>" + 
//		  		  "<if test=\"available != null and available != ''\">"+ "and available = #{available} " + "</if>" +
		  		  "<if test=\"merchantId != null and merchantId != ''\">"+ "and merchant_id = #{merchantId} " + "</if>" + 
		  		  "<if test=\"isShow != null and isShow != ''\">"+ "and is_show = #{isShow} " + "</if>" +
					"<if test=\"portType != null and portType != ''\">"+ "and port_type = #{portType} " + "</if>" +
		  			"</where>"+ 
			"</script>")
	int count(Map<String, Object> map);
	
	@Insert("insert into ss_banner (`image_url`, `href_url`, `href_type`, `theme`, `queue_number`, `description`, `create_time`, `available`, `merchant_id`, `is_show`, `port_type`)"
	+ "values (#{imageUrl}, #{hrefUrl}, #{hrefType}, #{theme}, #{queueNumber}, #{description}, #{createTime}, #{available}, #{merchantId}, #{isShow}, #{portType})")
	int save(BannerDO banner);
	
	@Update("<script>"+ 
			"update ss_banner " + 
					"<set>" + 
//		            "<if test=\"id != null\">`id` = #{id}, </if>" +
                    "<if test=\"imageUrl != null\">`image_url` = #{imageUrl}, </if>" + 
                    "<if test=\"hrefUrl != null\">`href_url` = #{hrefUrl}, </if>" + 
                    "<if test=\"hrefType != null\">`href_type` = #{hrefType}, </if>" + 
                    "<if test=\"theme != null\">`theme` = #{theme}, </if>" + 
                    "<if test=\"queueNumber != null\">`queue_number` = #{queueNumber}, </if>" + 
                    "<if test=\"description != null\">`description` = #{description}, </if>" + 
//                    "<if test=\"createTime != null\">`create_time` = #{createTime}, </if>" +
//                    "<if test=\"modifyTime != null\">`modify_time` = #{modifyTime}, </if>" +
//                    "<if test=\"available != null\">`available` = #{available}, </if>" +
//                    "<if test=\"merchantId != null\">`merchant_id` = #{merchantId}, </if>" +
                    "<if test=\"isShow != null\">`is_show` = #{isShow}, </if>" +
					"<if test=\"portType != null\">`port_type` = #{portType}, </if>" +
          					"</set>" + 
					"where id = #{id}"+
			"</script>")
	int update(BannerDO banner);
	
	@Update("update ss_banner set available = 0 where id =#{id}")
	int remove(Integer id);
	
	@Update("<script>"+
			"update ss_banner set available = 0 where id in " +
					"<foreach item=\"id\" collection=\"array\" open=\"(\" separator=\",\" close=\")\">" + 
						"#{id}" + 
					"</foreach>"+
			"</script>")
	int batchRemove(Integer[] ids);
}
