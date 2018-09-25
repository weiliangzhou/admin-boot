package com.zwl.iconManager.service;

import com.zwl.iconManager.domain.IconDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 16:49:09
 */
public interface IconService {
	
	IconDO get(Integer id);
	
	List<IconDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IconDO icon);
	
	int update(IconDO icon);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
