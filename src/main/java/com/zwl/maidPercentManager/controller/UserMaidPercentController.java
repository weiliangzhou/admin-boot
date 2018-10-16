package com.zwl.maidPercentManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.maidPercentManager.domain.UserMaidPercentDO;
import com.zwl.maidPercentManager.service.UserMaidPercentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-16 15:46:13
 */
@Controller
@RequestMapping("/maidPercentManager")
public class UserMaidPercentController {
    @Autowired
    private UserMaidPercentService userMaidPercentService;

    @GetMapping()
    @RequiresPermissions("maidPercentManager:maidPercentManager")
    String UserMaidPercent() {
        return "maidPercentManager/userMaidPercent";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("maidPercentManager:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<UserMaidPercentDO> userMaidPercentList = userMaidPercentService.list(query);
        int total = userMaidPercentService.count(query);
        PageUtils pageUtils = new PageUtils(userMaidPercentList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("maidPercentManager:add")
    String add() {
        return "maidPercentManager/add";
    }


    @GetMapping("/edit/{id}")
    @RequiresPermissions("maidPercentManager:edit")
    String edit(@PathVariable("id") Integer id, Model model) {
        UserMaidPercentDO userMaidPercent = userMaidPercentService.get(id);
        model.addAttribute("userMaidPercent", userMaidPercent);
        return "maidPercentManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("maidPercentManager:info")
    public R info(@PathVariable("id") Integer id) {
        UserMaidPercentDO userMaidPercent = userMaidPercentService.get(id);
        return R.ok().put("userMaidPercent", userMaidPercent);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("maidPercentManager:save")
    public R save(UserMaidPercentDO userMaidPercent) {
        String merchantId = ShiroUtils.getMerchantId();
        userMaidPercent.setAvailable(1);
        userMaidPercent.setMerchantId(merchantId);
        if (userMaidPercentService.save(userMaidPercent) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("maidPercentManager:update")
    @ResponseBody
    public R update(@ModelAttribute UserMaidPercentDO userMaidPercent) {
        userMaidPercentService.update(userMaidPercent);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("maidPercentManager:remove")
    public R remove(Integer id) {
        if (userMaidPercentService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("maidPercentManager:remove")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        userMaidPercentService.batchRemove(ids);

        return R.ok();
    }

}
