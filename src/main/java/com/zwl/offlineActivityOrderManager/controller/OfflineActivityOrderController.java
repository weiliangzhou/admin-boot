package com.zwl.offlineActivityOrderManager.controller;

import java.util.List;
import java.util.Map;

import com.zwl.common.utils.ShiroUtils;
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

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;

@Controller
@RequestMapping("/offlineActivityOrder")
public class OfflineActivityOrderController {
	@Autowired
	private OfflineActivityOrderService offlineActivityOrderService;
	@Autowired
	private OfflineActivityService offlineActivityService;
	@Autowired
	private OfflineActivityThemeService offlineActivityThemeService;
	
	@GetMapping()
	@RequiresPermissions("offlineActivityOrder:offlineActivityOrder")
	String OfflineActivityOrder(){
	    return "offlineActivityOrderManager/offlineActivityOrder";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("offlineActivityOrder:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		String merchantId = ShiroUtils.getMerchantId();
		params.put("merchantId", merchantId);
		params.put("available", 1);
		params.put("orderType", "0");
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
	
	@GetMapping("/add")
	//@RequiresPermissions("blog:bComments")
	String add(){
	    return "demo/offlineActivityOrder/add";
	}

	@GetMapping("/edit")
	//@RequiresPermissions("blog:bComments")
	String edit(String orderNo, Model model){
		OfflineActivityOrderDO offlineActivityOrder = offlineActivityOrderService.get(orderNo);
		model.addAttribute("offlineActivityOrder", offlineActivityOrder);
	    return "demo/offlineActivityOrder/edit";
	}
	/**
	 * 信息
	 */
	@RequestMapping("/info/{orderNo}")
	@RequiresPermissions("demo:info")
	public R info(@PathVariable("orderNo") String orderNo){
		OfflineActivityOrderDO offlineActivityOrder = offlineActivityOrderService.get(orderNo);
		return R.ok().put("offlineActivityOrder", offlineActivityOrder);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("demo:save")
	public R save( OfflineActivityOrderDO offlineActivityOrder){
		if(offlineActivityOrderService.save(offlineActivityOrder)>0){
			return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("demo:update")
	public R update(@RequestBody OfflineActivityOrderDO offlineActivityOrder){
		offlineActivityOrderService.update(offlineActivityOrder);
		
		return R.ok();
	}
	
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("demo:remove")
	public R remove( String orderNo){
		if(offlineActivityOrderService.remove(orderNo)>0){
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
		offlineActivityOrderService.batchRemove(orderNos);
		
		return R.ok();
	}
	
}
