package com.zwl.giftManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.giftManager.domain.UserGiftDO;
import com.zwl.giftManager.service.UserGiftService;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import com.zwl.system.domain.SysUserDO;
import com.zwl.system.service.UserService;
import org.apache.catalina.User;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 15:56:39
 */
@Controller
@RequestMapping("/userGift")
public class UserGiftController {
    @Autowired
    private UserGiftService userGiftService;
    @Autowired
    private SsUserService ssUserService;

    @GetMapping()
    @RequiresPermissions("userGift:userGift")
    String UserGift() {
        return "giftManager/userGift/userGift";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("userGift:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Object registerMobile = params.get("registerMobile");
        if(registerMobile != null){
            String userId = ssUserService.getUserByRegisterMobile(registerMobile.toString());
            params.put("userId",userId);
        }
        Query query = new Query(params);
        List<UserGiftDO> userGiftList = userGiftService.list(query);
        for (UserGiftDO userGiftDO : userGiftList) {
            SsUserDO ssUserDO = ssUserService.getUserByUserId(userGiftDO.getUserId());
            userGiftDO.setRegisterMobile(ssUserDO.getRegisterMobile());
        }
        int total = userGiftService.count(query);
        PageUtils pageUtils = new PageUtils(userGiftList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("userGift:add")
    String add() {
        return "giftManager/userGift/add";
    }

    @GetMapping("/dispatchShipments")
    @RequiresPermissions("userGift:shipments")
    public String dispatchShipments(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        UserGiftDO userGift = userGiftService.get(id);
        modelMap.put("userGift", userGift);
//        modelMap.put("id", id);
        return "giftManager/userGift/shipments";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("userGift:update")
    String edit(@PathVariable("id") Long id, Model model) {
        UserGiftDO userGift = userGiftService.get(id);
        model.addAttribute("userGift", userGift);
        return "giftManager/userGift/edit";
    }

    /**
     * 确认发货
     */
    @ResponseBody
    @PostMapping("/shipments")
    @RequiresPermissions("userGift:shipments")
    public R shipments(@RequestParam(value = "id") Long id,
                       @RequestParam(value = "expressCompany") Integer expressCompany,
                       @RequestParam(value = "expressNo") String expressNo) {
        if (userGiftService.updateShipments(id, expressCompany, expressNo) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("userGift:info")
    public R info(@PathVariable("id") Long id) {
        UserGiftDO userGift = userGiftService.get(id);
        return R.ok().put("userGift", userGift);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("userGift:save")
    public R save(UserGiftDO userGift) {
        if (userGiftService.save(userGift) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @ResponseBody
    @RequiresPermissions("userGift:update")
    public R update(@ModelAttribute UserGiftDO userGift) {
        userGiftService.update(userGift);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("userGift:remove")
    public R remove(Long id) {
        if (userGiftService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("userGift:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        userGiftService.batchRemove(ids);

        return R.ok();
    }

}
