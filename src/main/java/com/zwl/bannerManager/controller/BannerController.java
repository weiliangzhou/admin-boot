package com.zwl.bannerManager.controller;

import java.util.List;
import java.util.Map;

import com.zwl.bannerManager.domain.BannerDO;
import com.zwl.bannerManager.service.BannerService;
import com.zwl.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;

/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-03 09:55:26
 */
@Controller
@RequestMapping("/bannerManager/banner")
public class BannerController {
	@Autowired
	private BannerService bannerService;
	
	@GetMapping()
	@RequiresPermissions("banner:banner")
	String Banner(){
	    return "bannerManager/banner";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("banner:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId",merchantId);
		//查询列表数据
        Query query = new Query(params);
		List<BannerDO> bannerList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(bannerList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("banner:add")
	String add(){
	    return "bannerManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("banner:edit")
	String edit(@PathVariable("id")Integer id , Model model){
		BannerDO banner = bannerService.get(id);
		model.addAttribute("banner", banner);
	    return "bannerManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("banner:info")
	public R info(@PathVariable("id") Integer id){
		BannerDO banner = bannerService.get(id);
		return R.ok().put("banner", banner);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("demo:save")
	public R save( BannerDO banner){
		banner.setMerchantId(ShiroUtils.getMerchantId());
//		banner.setAvailable(1);
		if(bannerService.save(banner)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
//	@RequiresPermissions("demo:update")
	public R update(@ModelAttribute BannerDO banner){
		bannerService.update(banner);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("banner:remove")
	public R remove( Integer id){
		if(bannerService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("banner:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		bannerService.batchRemove(ids);
		
		return R.ok();
	}
	
}
