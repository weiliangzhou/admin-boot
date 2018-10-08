package com.zwl.offlineActivityManager.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import com.zwl.common.utils.ShiroUtils;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;

@Controller
@RequestMapping("/offlineActivity")
@Slf4j
public class OfflineActivityController {
	@Autowired
	private OfflineActivityService offlineActivityService;
	
	@GetMapping()
	@RequiresPermissions("offlineActivity:offlineActivity")
	String OfflineActivity(){
	    return "offlineActivityManager/offlineActivity";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("offlineActivity:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
        Query query = new Query(params);
		List<OfflineActivityDO> offlineActivityList = offlineActivityService.list(query);
		for(OfflineActivityDO offlineActivityDO:offlineActivityList){
			//根据活动主题id查询活动主题名称
			String activityTheme = offlineActivityService.selectThemeNameByThemeId(offlineActivityDO.getActivityThemeId());
			//根据上个活动id查询上个活动名称
			String activityParent = offlineActivityService.selectActivityAddressByActivityParentId(offlineActivityDO.getActivityParentId());
			offlineActivityDO.setActivityTheme(activityTheme);
			offlineActivityDO.setActivityParent(activityParent == null ? "":activityParent);
		}
		int total = offlineActivityService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("offlineActivity:add")
	String add(Model model){
		String merchantId = ShiroUtils.getMerchantId();
		model.addAttribute("merchantId", merchantId);
	    return "offlineActivityManager/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("offlineActivity:edit")
	String edit(Model model,@PathVariable("id")Integer id){
		OfflineActivityDO offlineActivity = offlineActivityService.get(id);
		model.addAttribute("offlineActivity", offlineActivity);
	    return "offlineActivityManager/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("offlineActivity:info")
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
		} catch (ParseException e) {
			log.error("日期转化异常");
		}
		offlineActivity.setMerchantId(ShiroUtils.getMerchantId());
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
		} catch (ParseException e) {
			log.error("日期转化异常");
		}
		offlineActivityService.update(offlineActivity);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("offlineActivity:remove")
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
	@RequiresPermissions("offlineActivity:remove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		offlineActivityService.batchRemove(ids);
		
		return R.ok();
	}
	
}
