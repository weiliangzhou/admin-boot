package com.zwl.certificationManager.controller;

import com.zwl.certificationManager.domain.UserCertificationDO;
import com.zwl.certificationManager.service.UserCertificationService;
import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
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
 * @date 2018-08-31 10:38:51
 */
@Controller
@RequestMapping("/certificationManager")
public class UserCertificationController {
    @Autowired
    private UserCertificationService userCertificationService;
    @Autowired
    private SsUserService ssUserService;

    @GetMapping()
    @RequiresPermissions("certificationManager:certificationManager")
    String UserCertification() {
        return "certificationManager/certificationManager";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("certificationManager:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //如果存在referrerMobile 转换成userId
        if (params.containsKey("registerMobile")) {
            String registerMobile = params.get("registerMobile").toString();
            String userId = ssUserService.getUserByRegisterMobile(registerMobile);
            if (StringUtils.isNotBlank(userId))
                params.put("userId", userId);
        }
        //查询列表数据
        Query query = new Query(params);
        params.put("merchantId", ShiroUtils.getMerchantId());
//        params.put("available", 1);
        List<UserCertificationDO> userCertificationList = userCertificationService.list(query);

        for (UserCertificationDO userCertification : userCertificationList) {
            String userId = userCertification.getUserId();
            SsUserDO userDO = ssUserService.getUserByUserId(userId);
            if(null != userDO){
                String registerMobile = userDO.getRegisterMobile();
                userCertification.setRegisterMobile(registerMobile);
            }
        }


        int total = userCertificationService.count(query);
        PageUtils pageUtils = new PageUtils(userCertificationList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("certificationManager:add")
    String add() {
        return "certificationManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("certificationManager:edit")
    String edit(ModelMap model, @PathVariable("id") Long id) {
        UserCertificationDO userCertification = userCertificationService.get(id);
        model.addAttribute("userCertification", userCertification);
        return "certificationManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("certificationManager:info")
    public R info(@PathVariable("id") Long id) {
        UserCertificationDO userCertification = userCertificationService.get(id);
        return R.ok().put("userCertification", userCertification);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("certificationManager:save")
    public R save(UserCertificationDO userCertification) {
        if (userCertificationService.save(userCertification) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("certificationManager:update")
    @ResponseBody
    public R update(@ModelAttribute UserCertificationDO userCertification) {
        Integer status = userCertification.getStatus();
        String userId = userCertification.getUserId();
        String realName = userCertification.getRealname();
        switch (status) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                //查询是否已经有通过的，如果有则直接报错
                String idCard = userCertificationService.getIdCardByUserId(userId);
                if (idCard != null){
                    userCertification.setRejectReason("已经审核通过了");
                    userCertification.setAvailable(0);
                    userCertificationService.update(userCertification);
                    return R.error(1, "已经审核通过了");
                }
                //如果实名认证通过，则更新用户表 真实姓名
                SsUserDO ssUserDO = new SsUserDO();
                ssUserDO.setUserId(userId);
                ssUserDO.setRealName(realName);
                ssUserService.update(ssUserDO);
                break;
            case 3:
                //驳回 则把available = 0
                userCertification.setAvailable(0);
                break;
        }
        userCertification.setOperator(ShiroUtils.getUserName());
        userCertificationService.update(userCertification);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("certificationManager:remove")
    public R remove(Long id) {
        if (userCertificationService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("certificationManager:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        userCertificationService.batchRemove(ids);

        return R.ok();
    }

}
