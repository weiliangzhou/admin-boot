package com.zwl.iconManager.controller;

import java.util.List;
import java.util.Map;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.iconManager.domain.IconDO;
import com.zwl.iconManager.service.IconService;
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
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 16:49:09
 */
@Controller
@RequestMapping("/iconManager/icon")
public class IconController {
	@Autowired
	private IconService iconService;
	
	@GetMapping()
	@RequiresPermissions("icon:icon")
	String Icon(){
	    return "iconManager/icon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("icon:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId",merchantId);
		//查询列表数据
        Query query = new Query(params);
		List<IconDO> iconList = iconService.list(query);
		int total = iconService.count(query);
		PageUtils pageUtils = new PageUtils(iconList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("icon:add")
	String add(){
	    return "iconManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("icon:edit")
	String edit(@PathVariable("id")Integer id, Model model){
		IconDO icon = iconService.get(id);
		model.addAttribute("icon", icon);
	    return "iconManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("icon:info")
	public R info(@PathVariable("id") Integer id){
		IconDO icon = iconService.get(id);
		return R.ok().put("icon", icon);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	//@RequiresPermissions("demo:save")
	public R save(@ModelAttribute IconDO icon){
		icon.setMerchantId(ShiroUtils.getMerchantId());
//		icon.setAvailable(1);
		if(iconService.save(icon)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@ResponseBody
	//@RequiresPermissions("demo:update")
	public R update(@ModelAttribute IconDO icon){
		iconService.update(icon);
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("icon:remove")
	public R remove( Integer id){
		if(iconService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("icon:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		iconService.batchRemove(ids);
		
		return R.ok();
	}
	
}
