package com.zwl.offlineActivityThemeManager.controller;

import com.zwl.common.utils.*;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import com.zwl.offlineActivityOrderManager.domain.OfflineActivityOrderDO;
import com.zwl.offlineActivityOrderManager.service.OfflineActivityOrderService;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/salonTheme")
public class SalonThemeController {
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	@Autowired
	private OfflineActivityOrderService offlineActivityOrderService;
	@Autowired
	private OfflineActivityService offlineActivityService;
	
	@GetMapping()
	@RequiresPermissions("salonTheme:salonTheme")
	String OfflineActivityTheme(){
	    return "salonThemeManager/salonTheme";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("salonTheme:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		params.put("activityType",1);
        Query query = new Query(params);
		List<OfflineActivityThemeDO> offlineActivityThemeList = offlineActivityThemeService.list(query);
		for(OfflineActivityThemeDO offlineActivityThemeDO:offlineActivityThemeList){
			Integer orderCount = offlineActivityOrderService.selectOrderCountByThemeId(offlineActivityThemeDO.getId());
			offlineActivityThemeDO.setOrderCount(orderCount);
		}
		int total = offlineActivityThemeService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityThemeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("salonTheme:add")
	String add(){
	    return "salonThemeManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("salonTheme:edit")
	String edit(Model model, @PathVariable("id")Integer id){
		OfflineActivityThemeDO offlineActivityTheme = offlineActivityThemeService.get(id);
		String activityTime = offlineActivityTheme.getActivityTime();
		if(null != activityTime){
			String startTime = activityTime.substring(0,16);
			String endTime = activityTime.substring(17,22);
			offlineActivityTheme.setStartTime(startTime);
			offlineActivityTheme.setEndTime(endTime);
		}
		model.addAttribute("offlineActivityTheme", offlineActivityTheme);
	    return "salonThemeManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("salonTheme:info")
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
		String startTime = offlineActivityTheme.getStartTime();
		String endTime = offlineActivityTheme.getEndTime();
		offlineActivityTheme.setActivityTime(startTime+"-"+endTime);
		offlineActivityTheme.setActivityType(1);
//		String contextText = EditUtil.delHtmlTag(offlineActivityTheme.getContent());
//		offlineActivityTheme.setContentText(contextText);
		offlineActivityTheme.setBuyCount(0);
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
		String startTime = offlineActivityTheme.getStartTime();
		String endTime = offlineActivityTheme.getEndTime();
		offlineActivityTheme.setActivityTime(startTime+"-"+endTime);
//		String contextText = EditUtil.delHtmlTag(offlineActivityTheme.getContent());
//		offlineActivityTheme.setContentText(contextText);
		offlineActivityThemeService.update(offlineActivityTheme);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("salonTheme:remove")
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
	@RequiresPermissions("salonTheme:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		offlineActivityThemeService.batchRemove(ids);
		
		return R.ok();
	}

	@GetMapping("/order/{id}")
	String order(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		return "salonThemeManager/order";
	}

	@ResponseBody
	@GetMapping("/getOrderList")
//	@RequiresPermissions("offlineActivityTheme:getOrderList")
	public PageUtils getOrderList(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		params.put("orderStatus",1);
		Query query = new Query(params);
		List<OfflineActivityOrderDO> offlineActivityOrderList = offlineActivityOrderService.list(query);
		for(OfflineActivityOrderDO offlineActivityOrderDO:offlineActivityOrderList){
			OfflineActivityDO offlineActivityDO = offlineActivityService.get(offlineActivityOrderDO.getActivityId());
			offlineActivityOrderDO.setActivityAddress(offlineActivityDO.getActivityAddress());
			OfflineActivityThemeDO offlineActivityThemeDO = offlineActivityThemeService.get(offlineActivityOrderDO.getActivityThemeId());
			offlineActivityOrderDO.setThemeName(offlineActivityThemeDO.getThemeName());
		}
		int total = offlineActivityOrderService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityOrderList, total);
		return pageUtils;
	}
}
