package com.zwl.offlineSalonActivityOrderManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import com.zwl.offlineActivityManager.domain.OfflineActivityDO;
import com.zwl.offlineActivityManager.service.OfflineActivityService;
import com.zwl.offlineActivityThemeManager.domain.OfflineActivityThemeDO;
import com.zwl.offlineActivityThemeManager.service.OfflineActivityThemeService;
import com.zwl.offlineSalonActivityOrderManager.domain.OfflineSalonActivityOrderDO;
import com.zwl.offlineSalonActivityOrderManager.service.OfflineSalonActivityOrderService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




/**
 * 
 * 
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-11-01 09:43:24
 */
@Controller
@RequestMapping("/offlineSalonActivityOrder")
public class OfflineSalonActivityOrderController {
	@Autowired
	private OfflineSalonActivityOrderService offlineSalonActivityOrderService;
	@Autowired
	private OfflineActivityService offlineActivityService;
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	@Autowired
	private SsUserService userService;
	@GetMapping()
	@RequiresPermissions("offlineSalonActivityOrder:offlineSalonActivityOrder")
	String OfflineSalonActivityOrder(){
	    return "offlineSalonActivityOrderManager/offlineSalonActivityOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("offlineSalonActivityOrder:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		params.put("orderType", 1);
		String themeName = null;
		if(null != params.get("themeName") && StringUtils.isNotBlank(params.get("themeName").toString())){
			themeName = params.get("themeName").toString();
			Integer themeId = offlineActivityThemeService.getThemeIdByThemeName(themeName);
			if(null != themeId ){
				params.put("activityThemeId", themeId);
			}else{
				return new PageUtils(new ArrayList<OfflineSalonActivityOrderDO>(), 0);
			}
		}
		String slReferrerPhone = params.get("slReferrerPhone").toString();
		if(StringUtils.isNotBlank(slReferrerPhone)){
			String slReferrer = userService.getUserByRegisterMobile(slReferrerPhone);
			if(StringUtils.isNotBlank(slReferrer)){
				params.put("slReferrer", slReferrer);
			}else{
				return new PageUtils(new ArrayList<OfflineSalonActivityOrderDO>(), 0);
			}
		}
		String slReferrerName = params.get("slReferrerName").toString();
		if(StringUtils.isNotBlank(slReferrerName)){
			List<String> slReferrerList = userService.getUserIdByRealName(slReferrerName,merchantId);
			if(null != slReferrerList && slReferrerList.size() != 0){
				params.put("slReferrer", slReferrerList.get(0));
			}else{
				return new PageUtils(new ArrayList<OfflineSalonActivityOrderDO>(), 0);
			}
		}
        Query query = new Query(params);
		List<OfflineSalonActivityOrderDO> offlineActivityOrderList = offlineSalonActivityOrderService.list(query);
		for(OfflineSalonActivityOrderDO offlineActivityOrderDO:offlineActivityOrderList){
			OfflineActivityDO offlineActivityDO = offlineActivityService.get(offlineActivityOrderDO.getActivityId());
			offlineActivityOrderDO.setActivityAddress(offlineActivityDO.getActivityAddress());
			OfflineActivityThemeDO offlineActivityThemeDO = offlineActivityThemeService.get(offlineActivityOrderDO.getActivityThemeId());
			offlineActivityOrderDO.setThemeName(offlineActivityThemeDO.getThemeName());
			SsUserDO ssUserDO = userService.getUserByUserId(offlineActivityOrderDO.getSlReferrer());
			offlineActivityOrderDO.setSlReferrerName(ssUserDO.getRealName());
			offlineActivityOrderDO.setSlReferrerPhone(ssUserDO.getRegisterMobile());
		}
		int total = offlineSalonActivityOrderService.count(query);
		PageUtils pageUtils = new PageUtils(offlineActivityOrderList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "demo/offlineSalonActivityOrder/add";
	}
	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(String orderNo, Model model){
		OfflineSalonActivityOrderDO offlineSalonActivityOrder = offlineSalonActivityOrderService.get(orderNo);
		model.addAttribute("OfflineSalonActivityOrder", offlineSalonActivityOrder);
	    return "demo/offlineSalonActivityOrder/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{orderNo}")
	@RequiresPermissions("demo:info")
	public R info(@PathVariable("orderNo") String orderNo){
		OfflineSalonActivityOrderDO offlineSalonActivityOrder = offlineSalonActivityOrderService.get(orderNo);
		return R.ok().put("offlineSalonActivityOrder", offlineSalonActivityOrder);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("demo:save")
	public R save( OfflineSalonActivityOrderDO offlineSalonActivityOrder){
		if(offlineSalonActivityOrderService.save(offlineSalonActivityOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("demo:update")
	public R update(@RequestBody OfflineSalonActivityOrderDO offlineSalonActivityOrder){
		offlineSalonActivityOrderService.update(offlineSalonActivityOrder);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("demo:remove")
	public R remove( String orderNo){
		if(offlineSalonActivityOrderService.remove(orderNo)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("demo:remove")
	public R remove(@RequestParam("ids[]") String[] orderNos){
		offlineSalonActivityOrderService.batchRemove(orderNos);
		
		return R.ok();
	}
	
}
