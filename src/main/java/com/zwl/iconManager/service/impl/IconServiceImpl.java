package com.zwl.iconManager.service.impl;

import com.zwl.iconManager.dao.IconMapper;
import com.zwl.iconManager.domain.IconDO;
import com.zwl.iconManager.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;




@Service
public class IconServiceImpl implements IconService {
	@Autowired
	private IconMapper iconMapper;
	
	@Override
	public IconDO get(Integer id){
		return iconMapper.get(id);
	}
	
	@Override
	public List<IconDO> list(Map<String, Object> map){
		return iconMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return iconMapper.count(map);
	}
	
	@Override
	public int save(IconDO icon){
		return iconMapper.save(icon);
	}
	
	@Override
	public int update(IconDO icon){
		return iconMapper.update(icon);
	}
	
	@Override
	public int remove(Integer id){
		return iconMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return iconMapper.batchRemove(ids);
	}
	
}
