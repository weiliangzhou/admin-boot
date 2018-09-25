package com.zwl.bannerManager.service;

import com.zwl.bannerManager.domain.BannerDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-03 09:55:26
 */
public interface BannerService {
	
	BannerDO get(Integer id);
	
	List<BannerDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(BannerDO banner);
	
	int update(BannerDO banner);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
