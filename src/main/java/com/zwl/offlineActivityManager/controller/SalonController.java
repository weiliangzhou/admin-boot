package com.zwl.offlineActivityManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import com.zwl.offlineActivityOrderManager.domain.OfflineActivityOrderDO;
import com.zwl.offlineActivityOrderManager.service.OfflineActivityOrderService;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static com.zwl.common.utils.BigDecimalUtil.mul;

@Controller
@RequestMapping("/salon")
@Slf4j
public class SalonController {
	@Autowired
	private OfflineActivityService offlineActivityService;
	@Autowired
	private OfflineActivityOrderService offlineActivityOrderService;
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	
	@GetMapping()
	@RequiresPermissions("salon:salon")
	String OfflineActivity(){
	    return "salonManager/salon";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("salon:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		params.put("activityType", 1);
        Query query = new Query(params);
		List<OfflineActivityDO> offlineActivityList = offlineActivityService.list(query);
		for(OfflineActivityDO offlineActivityDO:offlineActivityList){
			//根据活动主题id查询活动主题名称
			String activityTheme = offlineActivityService.selectThemeNameByThemeId(offlineActivityDO.getActivityThemeId());
			offlineActivityDO.setActivityTheme(activityTheme);
			//根据开课城市id查询该课程订单人数
			Integer orderCount = offlineActivityOrderService.selectOrderCountByActivityId(offlineActivityDO.getId());
			offlineActivityDO.setOrderCount(orderCount);
		}
		int total = offlineActivityService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("salon:add")
	String add(Model model){
		String merchantId = ShiroUtils.getMerchantId();
		model.addAttribute("merchantId", merchantId);
	    return "salonManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("salon:edit")
	String edit(Model model,@PathVariable("id")Integer id){
		OfflineActivityDO offlineActivity = offlineActivityService.get(id);
		model.addAttribute("offlineActivity", offlineActivity);
	    return "salonManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("salon:info")
	public R info(@PathVariable("id") Integer id){
		OfflineActivityDO offlineActivity = offlineActivityService.get(id);
		return R.ok().put("offlineActivity", offlineActivity);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
//	@RequiresPermissions("demo:save")
	public R save( OfflineActivityDO offlineActivity) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			offlineActivity.setActivityStartTime(simpleDateFormat.parse(offlineActivity.getActivityStartTimeDesc()));
			offlineActivity.setActivityEndTime(simpleDateFormat.parse(offlineActivity.getActivityEndTimeDesc()));
			offlineActivity.setApplyStartTime(simpleDateFormat.parse(offlineActivity.getApplyStartTimeDesc()));
			offlineActivity.setApplyEndTime(simpleDateFormat.parse(offlineActivity.getApplyEndTimeDesc()));
		} catch (ParseException e) {
			log.error("日期转化异常");
			throw new RuntimeException("日期转化异常");
		}
		//如复训价格未填，则设初始值为0
		Double retrainingPriceDesc = offlineActivity.getRetrainingPriceDesc()==null ? 0 : offlineActivity.getRetrainingPriceDesc();
		offlineActivity.setActivityPrice(Integer.parseInt((int)mul(offlineActivity.getActivityPriceDesc(),100)+""));
		offlineActivity.setRetrainingPrice(Integer.parseInt((int)mul(retrainingPriceDesc,100)+""));
		offlineActivity.setMerchantId(ShiroUtils.getMerchantId());
		offlineActivity.setBuyCount(0);
		offlineActivity.setMinRequirement(offlineActivity.getMinRequirement() == null ? 0 :offlineActivity.getMinRequirement());
		offlineActivity.setActivityType(1);
		if(offlineActivityService.save(offlineActivity)>0){
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
	public R update( OfflineActivityDO offlineActivity){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			offlineActivity.setActivityStartTime(simpleDateFormat.parse(offlineActivity.getActivityStartTimeDesc()));
			offlineActivity.setActivityEndTime(simpleDateFormat.parse(offlineActivity.getActivityEndTimeDesc()));
			offlineActivity.setApplyStartTime(simpleDateFormat.parse(offlineActivity.getApplyStartTimeDesc()));
			offlineActivity.setApplyEndTime(simpleDateFormat.parse(offlineActivity.getApplyEndTimeDesc()));
		} catch (ParseException e) {
			log.error("日期转化异常");
			throw new RuntimeException("日期转化异常");
		}
		offlineActivity.setActivityPrice(Integer.parseInt((int)mul(offlineActivity.getActivityPriceDesc(),100)+""));
		offlineActivity.setRetrainingPrice(Integer.parseInt((int)mul(offlineActivity.getRetrainingPriceDesc(),100)+""));
		offlineActivityService.update(offlineActivity);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("salon:remove")
	public R remove( Integer id){
		if(offlineActivityService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("salon:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		offlineActivityService.batchRemove(ids);
		
		return R.ok();
	}

	@GetMapping("/order/{id}")
	String order(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("id", id);
		return "salonManager/order";
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
