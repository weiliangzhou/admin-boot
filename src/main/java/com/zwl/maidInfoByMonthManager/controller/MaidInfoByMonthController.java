package com.zwl.maidInfoByMonthManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidInfoByMonthManager.domain.MaidInfoByMonthDO;
import com.zwl.maidInfoByMonthManager.service.MaidInfoByMonthService;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:36:31
 */
@Controller
@RequestMapping("/maidInfoByMonthManager")
public class MaidInfoByMonthController {
    @Autowired
    private MaidInfoByMonthService maidInfoByMonthService;
    @Autowired
    private SsUserService ssUserService;

    @GetMapping()
    @RequiresPermissions("maidInfoByMonth:maidInfoByMonth")
    public String MaidInfoByMonth() {
        return "maidInfoByMonthManager/maidInfoByMonth";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("maidInfoByMonth:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //如果存在referrerMobile 转换成userId
        if (params.containsKey("referrerMobile")) {
            String referrerMobile = params.get("referrerMobile").toString();
            String referrerUserId = ssUserService.getUserByRegisterMobile(referrerMobile);
            if (StringUtils.isNotBlank(referrerUserId))
                params.put("userId", referrerUserId);
        }
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<MaidInfoByMonthDO> maidInfoByMonthList = maidInfoByMonthService.list(query);
        int total = maidInfoByMonthService.count(query);
        for (MaidInfoByMonthDO maidInfoByMonthDO : maidInfoByMonthList) {
            String userId = maidInfoByMonthDO.getUserId();
            SsUserDO userDO = ssUserService.getUserByUserId(userId);
            maidInfoByMonthDO.setReferrerMobile(userDO.getRegisterMobile());
            maidInfoByMonthDO.setReferrerRealName(userDO.getRealName());
        }

        PageUtils pageUtils = new PageUtils(maidInfoByMonthList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        //@RequiresPermissions("blog:bComments")
    String add() {
        return "demo/maidInfoByMonthManager/add";
    }

    @GetMapping("/edit/{id}")
        //@RequiresPermissions("blog:bComments")
    String edit(ModelMap model, @PathVariable("id") Long id) {
        MaidInfoByMonthDO maidInfoByMonth = maidInfoByMonthService.get(id);
        model.addAttribute("MaidInfoByMonth", maidInfoByMonth);
        return "demo/maidInfoByMonthManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:info")
    public R info(@PathVariable("id") Long id) {
        MaidInfoByMonthDO maidInfoByMonth = maidInfoByMonthService.get(id);
        return R.ok().put("maidInfoByMonthManager", maidInfoByMonth);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(MaidInfoByMonthDO maidInfoByMonth) {
        if (maidInfoByMonthService.save(maidInfoByMonth) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:update")
    public R update(@RequestBody MaidInfoByMonthDO maidInfoByMonth) {
        maidInfoByMonthService.update(maidInfoByMonth);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(Long id) {
        if (maidInfoByMonthService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        maidInfoByMonthService.batchRemove(ids);

        return R.ok();
    }

}
