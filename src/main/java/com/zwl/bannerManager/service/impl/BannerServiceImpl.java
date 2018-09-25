package com.zwl.bannerManager.service.impl;

import com.zwl.bannerManager.dao.BannerMapper;
import com.zwl.bannerManager.domain.BannerDO;
import com.zwl.bannerManager.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerMapper bannerMapper;
	
	@Override
	public BannerDO get(Integer id){
		return bannerMapper.get(id);
	}
	
	@Override
	public List<BannerDO> list(Map<String, Object> map){
		return bannerMapper.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return bannerMapper.count(map);
	}
	
	@Override
	public int save(BannerDO banner){
		return bannerMapper.save(banner);
	}
	
	@Override
	public int update(BannerDO banner){
		return bannerMapper.update(banner);
	}
	
	@Override
	public int remove(Integer id){
		return bannerMapper.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return bannerMapper.batchRemove(ids);
	}
	
}
