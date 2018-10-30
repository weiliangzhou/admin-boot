package com.zwl.giftManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.giftManager.domain.UserGiftDO;
import com.zwl.giftManager.service.UserGiftService;
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
 * @date 2018-10-30 15:56:39
 */
@Controller
@RequestMapping("/userGift")
public class UserGiftController {
    @Autowired
    private UserGiftService userGiftService;

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
        Query query = new Query(params);
        List<UserGiftDO> userGiftList = userGiftService.list(query);
        int total = userGiftService.count(query);
        PageUtils pageUtils = new PageUtils(userGiftList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("userGift:add")
    String add() {
        return "giftManager/userGift/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("userGift:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        UserGiftDO userGift = userGiftService.get(id);
        model.addAttribute("userGift", userGift);
        return "giftManager/userGift/edit";
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
    @RequiresPermissions("userGift:update")
    public R update(@RequestBody UserGiftDO userGift) {
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
