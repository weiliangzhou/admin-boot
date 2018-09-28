package com.zwl.offlineActivityThemeManager.controller;

import java.util.List;
import java.util.Map;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;

@Controller
@RequestMapping("/offlineActivityTheme")
public class OfflineActivityThemeController {
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	
	@GetMapping()
	@RequiresPermissions("offlineActivityTheme:offlineActivityTheme")
	String OfflineActivityTheme(){
	    return "offlineActivityThemeManager/offlineActivityTheme";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("offlineActivityTheme:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
        Query query = new Query(params);
		List<OfflineActivityThemeDO> offlineActivityThemeList = offlineActivityThemeService.list(query);
		int total = offlineActivityThemeService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityThemeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("offlineActivityTheme:add")
	String add(){
	    return "offlineActivityThemeManager/add";
	}

	@GetMapping("/edit")
	@RequiresPermissions("offlineActivityTheme:edit")
	String edit(Model model, @PathVariable("id")Integer id){
		OfflineActivityThemeDO offlineActivityTheme = offlineActivityThemeService.get(id);
		model.addAttribute("offlineActivityTheme", offlineActivityTheme);
	    return "offlineActivityThemeManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("offlineActivityTheme:info")
	public R info(@PathVariable("id") Integer id){
		OfflineActivityThemeDO offlineActivityTheme = offlineActivityThemeService.get(id);
		return R.ok().put("offlineActivityTheme", offlineActivityTheme);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("demo:save")
	public R save( OfflineActivityThemeDO offlineActivityTheme){
		offlineActivityTheme.setMerchantId(ShiroUtils.getMerchantId());
		if(offlineActivityThemeService.save(offlineActivityTheme)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
//	@RequiresPermissions("demo:update")
	public R update( OfflineActivityThemeDO offlineActivityTheme){
		offlineActivityThemeService.update(offlineActivityTheme);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("offlineActivityTheme:remove")
	public R remove( Integer id){
		if(offlineActivityThemeService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("offlineActivityTheme:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		offlineActivityThemeService.batchRemove(ids);
		
		return R.ok();
	}
	
}
