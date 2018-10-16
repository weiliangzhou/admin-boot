package com.zwl.memberManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.domain.UserWechatDO;
import com.zwl.memberManager.service.SsUserService;
import com.zwl.memberManager.service.UserWechatService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author 二师兄超级帅
 * @email 382308664@qq.com
 * @date 2018-08-27 16:35:27
 */
@Controller
@RequestMapping("/memberManager")
public class MemberMangerController {
    @Autowired
    private SsUserService ssUserService;
    @Autowired
    private UserWechatService userWechatService;

    @GetMapping()
    @RequiresPermissions("memberManager:memberManager")
    String SsUser() {
        return "memberManager/memberManager";
    }

    @ResponseBody
    @GetMapping("/list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //如果存在referrerMobile 转换成userId
        if (params.containsKey("referrerMobile")) {
            String referrerMobile = params.get("referrerMobile").toString();
            String referrerUserId = ssUserService.getUserByRegisterMobile(referrerMobile);
            if (StringUtils.isNotBlank(referrerUserId))
                params.put("referrer", referrerUserId);
        }
        //查询列表数据
        String merchantId = ShiroUtils.getMerchantId();
        params.put("merchantId", merchantId);
        params.put("available", 1);
        Query query = new Query(params);
        List<SsUserDO> ssUserList = ssUserService.list(query);
        for (SsUserDO ssUserDO : ssUserList) {
            String referrer = ssUserDO.getReferrer();
            if (StringUtils.isNotBlank(referrer)) {
                SsUserDO userDO = ssUserService.getUserByUserId(referrer);
                if (userDO != null) {
                    String referrerMobile1 = userDO.getRegisterMobile();
                    String referrerRealName = userDO.getRealName();
                    ssUserDO.setReferrerMobile(referrerMobile1);
                    ssUserDO.setReferrerRealName(referrerRealName);
                }

            }
            String userId = ssUserDO.getUserId();
//            String merchantId = ShiroUtils.getMerchantId();
            //根据userId查下线人数
            Integer xiaxianCount = ssUserService.getXiaXianCountByUserId(userId, merchantId);
            ssUserDO.setXiaxianCount(xiaxianCount == null ? 0 : xiaxianCount);
            //根据userId查消费金额
            Integer actualMoney = ssUserService.getActualMoneyByUserId(userId);
            ssUserDO.setActualMoney(actualMoney == null ? 0 : actualMoney / 100);
            //根据userId查总业绩
            Integer totalPerformance = ssUserService.getTotalPerformanceByUserId(userId, merchantId);
            ssUserDO.setTotalPerformance(totalPerformance == null ? 0 : totalPerformance / 100);
            //获取用户绑定的微信账号
            UserWechatDO userWechatDO = userWechatService.getUserWechatByUserId(userId);
            if (null != userWechatDO) {
                ssUserDO.setWechatAccount(userWechatDO.getWechatAccount());
            }
        }
        int total = ssUserService.count(query);
        PageUtils pageUtils = new PageUtils(ssUserList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    String add() {
        return "memberManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("memberManager:edit")
    String edit(Model model, @PathVariable("id") Long id) {
        SsUserDO ssUser = ssUserService.get(id);
        model.addAttribute("ssUser", ssUser);
        return "memberManager/edit";
    }


    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("memberManager:save")
    public R save(SsUserDO ssUser) {
        if (ssUserService.save(ssUser) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @PostMapping("/update")
    @RequiresPermissions("memberManager:update")
    public R update(SsUserDO ssUser) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);//设置起时间
        cal.add(Calendar.YEAR, 99);//增加99年
        ssUser.setExpiresTime(cal.getTime());
        ssUser.setIsBuy(1);
        ssUser.setRegisterFrom(2);
        String levelName = "";
        Integer memberLevel = ssUser.getMemberLevel();
        if (null==memberLevel)
            return R.error();
        switch (memberLevel) {
            case 99:
                levelName = "校长";
                break;
            case 6:
                levelName = "院长";
                break;
            case 4:
                levelName = "VIP学员";
                break;
            case 1:
                levelName = "学员";
                break;
        }
        ssUser.setLevelName(levelName);
        ssUserService.update(ssUser);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("memberManager:remove")
    public R remove(Long id) {
        if (ssUserService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("memberManager:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        ssUserService.batchRemove(ids);

        return R.ok();
    }

    @GetMapping("/xiaXian/{userId}")
    String xiaXian(Model model, @PathVariable("userId") String userId) {
        model.addAttribute("userId", userId);
        return "memberManager/xiaXian";
    }

    @GetMapping("/getXiaXianList")
    @ResponseBody
    public PageUtils getXiaXianList(@RequestParam Map<String, Object> params) {
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<SsUserDO> ssUserList = ssUserService.list(query);
        for (SsUserDO ssUserDO : ssUserList) {
            String userId = ssUserDO.getUserId();
            String merchantId = ShiroUtils.getMerchantId();
            //根据userId查下线人数
            Integer xiaxianCount = ssUserService.getXiaXianCountByUserId(userId, merchantId);
            ssUserDO.setXiaxianCount(xiaxianCount == null ? 0 : xiaxianCount);
            //根据userId查消费金额
            Integer actualMoney = ssUserService.getActualMoneyByUserId(userId);
            ssUserDO.setActualMoney(actualMoney == null ? 0 : actualMoney / 100);
            //根据userId查总业绩
            Integer totalPerformance = ssUserService.getTotalPerformanceByUserId(userId, merchantId);
            ssUserDO.setTotalPerformance(totalPerformance == null ? 0 : totalPerformance / 100);
        }
        int total = ssUserService.count(query);
        PageUtils pageUtils = new PageUtils(ssUserList, total);
        return pageUtils;
    }
}
