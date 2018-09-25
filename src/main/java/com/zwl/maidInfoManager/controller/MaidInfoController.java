package com.zwl.maidInfoManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidInfoManager.domain.MaidInfoDO;
import com.zwl.maidInfoManager.service.MaidInfoService;
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
 * @date 2018-08-31 14:53:30
 */
@Controller
@RequestMapping("/maidInfoManager")
public class MaidInfoController {
    @Autowired
    private MaidInfoService maidInfoService;
    @Autowired
    private SsUserService ssUserService;

    @GetMapping()
    @RequiresPermissions("maid:maid")
    public String MaidInfo() {
        return "maidInfoManager/maidInfo";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("maid:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //如果存在referrerMobile 转换成userId
        if (params.containsKey("referrerMobile")) {
            String referrerMobile = params.get("referrerMobile").toString();
            String referrerUserId = ssUserService.getUserByRegisterMobile(referrerMobile);
            if (StringUtils.isNotBlank(referrerUserId))
                params.put("userId", referrerUserId);
        }
        if (params.containsKey("maidMobile")) {
            String maidMobile = params.get("maidMobile").toString();
            String referrerUserId = ssUserService.getUserByRegisterMobile(maidMobile);
            if (StringUtils.isNotBlank(referrerUserId))
                params.put("maidUserId", referrerUserId);
        }
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<MaidInfoDO> maidInfoList = maidInfoService.list(query);
        for (MaidInfoDO maidInfo : maidInfoList) {
            String userId = maidInfo.getUserId();
            String maidUserId = maidInfo.getMaidUserId();
            if (StringUtils.isNotBlank(userId)) {
                SsUserDO userDO = ssUserService.getUserByUserId(userId);
                if (userDO != null) {

                    String referrerMobile = userDO.getRegisterMobile();
                    String referrerRealName = userDO.getRealName();
                    maidInfo.setReferrerMobile(referrerMobile);
                    maidInfo.setReferrerRealName(referrerRealName);
                }
            }
            if (StringUtils.isNotBlank(maidUserId)) {
                SsUserDO userDO = ssUserService.getUserByUserId(maidUserId);
                if (userDO != null) {
                    String referrerMobile = userDO.getRegisterMobile();
                    String referrerRealName = userDO.getRealName();
                    maidInfo.setMaidMobile(referrerMobile);
                    maidInfo.setMaidRealName(referrerRealName);
                }
            }


        }


        int total = maidInfoService.count(query);
        PageUtils pageUtils = new PageUtils(maidInfoList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        //@RequiresPermissions("blog:bComments")
    String add() {
        return "demo/maidInfo/add";
    }

    @GetMapping("/edit/{id}")
    //@RequiresPermissions("blog:bComments")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        MaidInfoDO maidInfo = maidInfoService.get(id);
        model.addAttribute("MaidInfo", maidInfo);
        return "demo/maidInfo/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:info")
    public R info(@PathVariable("id") Long id) {
        MaidInfoDO maidInfo = maidInfoService.get(id);
        return R.ok().put("maidInfo", maidInfo);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(MaidInfoDO maidInfo) {
        if (maidInfoService.save(maidInfo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:update")
    public R update(@RequestBody MaidInfoDO maidInfo) {
        maidInfoService.update(maidInfo);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(Long id) {
        if (maidInfoService.remove(id) > 0) {
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
        maidInfoService.batchRemove(ids);

        return R.ok();
    }

}
