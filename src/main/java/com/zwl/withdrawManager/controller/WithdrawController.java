package com.zwl.withdrawManager.controller;

import com.zwl.certificationManager.service.UserCertificationService;
import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidInfoManager.service.MaidInfoService;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import com.zwl.system.service.UserService;
import com.zwl.withdrawManager.domain.WithdrawDO;
import com.zwl.withdrawManager.service.WithdrawService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 15:47:25
 */
@Controller
@RequestMapping("/withdrawManager")
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;
    @Autowired
    private MaidInfoService maidInfoService;
    @Autowired
    private UserCertificationService userCertificationService;
    @Autowired
    private SsUserService ssUserService;

    @GetMapping()
    @RequiresPermissions("withdraw:list")
    public String Withdraw() {
        return "withdrawManager/withdraw";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("withdraw:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //如果存在phone 转换成userId
        if (params.containsKey("phone")) {
            String phone = params.get("phone").toString();
            String userId = ssUserService.getUserByRegisterMobile(phone);
            if (StringUtils.isNotBlank(userId))
                params.put("userId", userId);
        }

        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<WithdrawDO> withdrawList = withdrawService.list(query);
        for (WithdrawDO withdrawDO : withdrawList) {
            String userId = withdrawDO.getUserId();
            Integer xiaxianCount = withdrawService.getXiaXianCountByUserId(userId);
            withdrawDO.setXiaxianCount(xiaxianCount == null ? 0 : xiaxianCount);
            //根据userId查消费金额
            Integer actualMoney = withdrawService.getActualMoneyByUserId(userId);
            withdrawDO.setActualMoney(actualMoney == null ? 0 : actualMoney);
            //当前用户可用余额
            Integer balance = maidInfoService.getBalanceByUserId(userId);
            withdrawDO.setBalance(balance == null ? 0 : balance);
            //当前用户累计返佣金额
            Integer totalMaidAmount = maidInfoService.getTotalMaidMoneyByUserId(userId);
            withdrawDO.setTotalMaidAmount(totalMaidAmount == null ? 0 : totalMaidAmount);
            //身份证号码
            String idCard=userCertificationService.getIdCardByUserId(userId);
            withdrawDO.setIdCard(StringUtils.isBlank(idCard)?"":idCard);
            //手机号码
            SsUserDO userDO=ssUserService.getUserByUserId(userId);
            String phone=userDO.getRegisterMobile();
            withdrawDO.setPhone(phone);
        }
        int total = withdrawService.count(query);
        PageUtils pageUtils = new PageUtils(withdrawList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        //@RequiresPermissions("blog:bComments")
    String add() {
        return "demo/withdraw/add";
    }

    @GetMapping("/edit/{id}")
    //@RequiresPermissions("blog:bComments")
    public String edit(@PathVariable("id") Long id, ModelMap model) {
        WithdrawDO withdraw = withdrawService.get(id);
        model.addAttribute("Withdraw", withdraw);
        return "withdrawManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:info")
    public R info(@PathVariable("id") Long id) {
        WithdrawDO withdraw = withdrawService.get(id);
        return R.ok().put("withdraw", withdraw);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(WithdrawDO withdraw) {
        if (withdrawService.save(withdraw) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("withdraw:update")
    @ResponseBody
    public R update(@ModelAttribute WithdrawDO withdraw) {
        withdraw.setSuccessTime(new Date());
        withdraw.setOperator(ShiroUtils.getUserName());
        Integer status = withdraw.getStatus();
        if (status == 2)
            withdraw.setSuccessTime(new Date());
        withdrawService.update(withdraw);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(Long id) {
        if (withdrawService.remove(id) > 0) {
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
        withdrawService.batchRemove(ids);

        return R.ok();
    }

}
