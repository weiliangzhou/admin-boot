package com.zwl.giftManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.giftManager.domain.GiftDO;
import com.zwl.giftManager.service.GiftService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 16:11:40
 */
@Controller
@RequestMapping("/gift")
public class GiftController {
    @Autowired
    private GiftService giftService;

    @GetMapping()
    @RequiresPermissions("gift:gift")
    String Gift() {
        return "giftManager/gift/gift";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("gift:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        Query query = new Query(params);
        List<GiftDO> giftList = giftService.list(query);
        int total = giftService.count(query);
        PageUtils pageUtils = new PageUtils(giftList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("gift:add")
    String add() {
        return "giftManager/gift/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("gift:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        GiftDO gift = giftService.get(id);
        model.addAttribute("gift", gift);
        return "giftManager/gift/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("gift:info")
    public R info(@PathVariable("id") Long id) {
        GiftDO gift = giftService.get(id);
        return R.ok().put("gift", gift);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("gift:save")
    public R save(@ModelAttribute GiftDO gift) {
        String merchantId = ShiroUtils.getMerchantId();
        gift.setCreateTime(new Date());
        gift.setAvailable(1);
        gift.setBuyCount(0);
        gift.setMerchantId(merchantId);
        if (giftService.save(gift) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @ResponseBody
    @RequestMapping("/update")
    @RequiresPermissions("gift:update")
    public R update(@ModelAttribute GiftDO gift) {
        giftService.update(gift);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("gift:remove")
    public R remove(Long id) {
        if (giftService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("gift:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        giftService.batchRemove(ids);

        return R.ok();
    }

}
