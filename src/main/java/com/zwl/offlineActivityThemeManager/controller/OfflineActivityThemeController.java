package com.zwl.offlineActivityThemeManager.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/offlineActivityTheme")
public class OfflineActivityThemeController {
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	@Autowired
	private OfflineActivityOrderService offlineActivityOrderService;
	@Autowired
	private OfflineActivityService offlineActivityService;
	
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
		for(OfflineActivityThemeDO offlineActivityThemeDO:offlineActivityThemeList){
			Integer orderCount = offlineActivityOrderService.selectOrderCountByThemeId(offlineActivityThemeDO.getId());
			offlineActivityThemeDO.setOrderCount(orderCount);
			String activityTime = offlineActivityThemeDO.getActivityTime().substring(3);
			offlineActivityThemeDO.setActivityTime(activityTime);
			//查询该课程主题下有哪些开课城市
			List<String> cities = offlineActivityService.selectActivityAddressByThemeId(offlineActivityThemeDO.getId());
			if(null != cities && !cities.isEmpty()){
				String city = cities.get(0);
				if(2 == cities.size()){
					city = city + "，"+cities.get(1);
				}
				offlineActivityThemeDO.setCity(city);
			}

		}
		int total = offlineActivityThemeService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityThemeList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("offlineActivityTheme:add")
	String add(){
	    return "offlineActivityThemeManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("offlineActivityTheme:edit")
	String edit(Model model, @PathVariable("id")Integer id){
		OfflineActivityThemeDO offlineActivityTheme = offlineActivityThemeService.get(id);
		String activityTime = offlineActivityTheme.getActivityTime();
		if(null != activityTime){
			Integer day = Integer.valueOf(activityTime.substring(3,activityTime.indexOf("天")));
			Integer night = Integer.valueOf(activityTime.substring(activityTime.indexOf("天")+1,activityTime.indexOf("夜")));
			offlineActivityTheme.setDay(day);
			offlineActivityTheme.setNight(night);
		}
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
		Integer day = offlineActivityTheme.getDay();
		Integer night = offlineActivityTheme.getNight();
		if (null != day && null != night) {
			offlineActivityTheme.setActivityTime("时长 "+day+"天"+night+"夜");
		}
		String contextText = EditUtil.delHtmlTag(offlineActivityTheme.getContent());
		offlineActivityTheme.setContentText(contextText);
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
		Integer day = offlineActivityTheme.getDay();
		Integer night = offlineActivityTheme.getNight();
		if (null != day && null != night) {
			offlineActivityTheme.setActivityTime("时长 "+day+"天"+night+"夜");
		}
		String contextText = EditUtil.delHtmlTag(offlineActivityTheme.getContent());
		offlineActivityTheme.setContentText(contextText);
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

	@GetMapping("/order/{id}")
	String order(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		return "offlineActivityThemeManager/order";
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

	@GetMapping("/activity/{id}")
	String activity(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		return "offlineActivityThemeManager/activity";
	}

	@ResponseBody
	@GetMapping("/getActivityList")
//	@RequiresPermissions("offlineActivity:list")
	public PageUtils getActivityList(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		Query query = new Query(params);
		List<OfflineActivityDO> offlineActivityList = offlineActivityService.list(query);
		for(OfflineActivityDO offlineActivityDO:offlineActivityList){
			//根据活动主题id查询活动主题名称
			String activityTheme = offlineActivityService.selectThemeNameByThemeId(offlineActivityDO.getActivityThemeId());
			offlineActivityDO.setActivityTheme(activityTheme);
			Integer orderCount = offlineActivityOrderService.selectOrderCountByActivityId(offlineActivityDO.getId());
			offlineActivityDO.setOrderCount(orderCount);
		}
		int total = offlineActivityService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityList, total);
		return pageUtils;
	}
}
