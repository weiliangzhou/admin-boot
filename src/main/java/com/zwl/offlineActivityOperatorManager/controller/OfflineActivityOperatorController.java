package com.zwl.offlineActivityOperatorManager.controller;

import java.util.List;
import java.util.Map;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityOperatorManager.domain.OfflineActivityOperatorDO;
import com.zwl.offlineActivityOperatorManager.service.OfflineActivityOperatorService;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;

@Controller
@RequestMapping("/offlineActivityOperator")
public class OfflineActivityOperatorController {
	@Autowired
	private OfflineActivityOperatorService offlineActivityOperatorService;
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	
	@GetMapping()
	@RequiresPermissions("offlineActivityOperator:offlineActivityOperator")
	String OfflineActivityOperator(){
	    return "offlineActivityOperatorManager/offlineActivityOperator";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("offlineActivityOperator:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
        Query query = new Query(params);
		List<OfflineActivityOperatorDO> offlineActivityOperatorList = offlineActivityOperatorService.list(query);
		for(OfflineActivityOperatorDO offlineActivityOperatorDO:offlineActivityOperatorList){
			Integer activityThemeId = offlineActivityOperatorDO.getActivityThemeId();
			OfflineActivityThemeDO offlineActivityThemeDO = offlineActivityThemeService.get(activityThemeId);
			offlineActivityOperatorDO.setThemeName(offlineActivityThemeDO.getThemeName());
		}
		int total = offlineActivityOperatorService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityOperatorList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("offlineActivityOperator:add")
	String add(Model model){
		String merchantId = ShiroUtils.getMerchantId();
		model.addAttribute("merchantId", merchantId);
	    return "offlineActivityOperatorManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("offlineActivityOperator:edit")
	String edit(Model model, @PathVariable("id")Integer id){
		OfflineActivityOperatorDO offlineActivityOperator = offlineActivityOperatorService.get(id);
		model.addAttribute("offlineActivityOperator", offlineActivityOperator);
	    return "offlineActivityOperatorManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("offlineActivityOperator:info")
	public R info(@PathVariable("id") Integer id){
		OfflineActivityOperatorDO offlineActivityOperator = offlineActivityOperatorService.get(id);
		return R.ok().put("offlineActivityOperator", offlineActivityOperator);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("offlineActivityOperator:save")
	public R save(OfflineActivityOperatorDO offlineActivityOperator){
		offlineActivityOperator.setMerchantId(ShiroUtils.getMerchantId());
		if(offlineActivityOperatorService.save(offlineActivityOperator)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
//	@RequiresPermissions("offlineActivityOperator:update")
	public R update(OfflineActivityOperatorDO offlineActivityOperator){
		offlineActivityOperatorService.update(offlineActivityOperator);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("offlineActivityOperator:remove")
	public R remove( Integer id){
		if(offlineActivityOperatorService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("offlineActivityOperator:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		offlineActivityOperatorService.batchRemove(ids);
		
		return R.ok();
	}
	
}
