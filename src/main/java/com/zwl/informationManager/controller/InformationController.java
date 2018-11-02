package com.zwl.informationManager.controller;

import com.zwl.common.utils.*;
import com.zwl.informationManager.domain.InformationDO;
import com.zwl.informationManager.service.InformationService;
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
 * @date 2018-08-30 15:44:24
 */
@Controller
@RequestMapping("/informationManager")
public class InformationController {
    @Autowired
    private InformationService informationService;

    @GetMapping()
    @RequiresPermissions("information:information")
    public String Information() {
        return "informationManager/information";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("information:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        //查询列表数据
        Query query = new Query(params);
        List<InformationDO> informationList = informationService.list(query);
        int total = informationService.count(query);
        PageUtils pageUtils = new PageUtils(informationList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    //@RequiresPermissions("blog:bComments")
    public String add() {
        return "informationManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("information:edit")
    String edit(ModelMap model, @PathVariable("id") Integer id) {
        InformationDO information = informationService.get(id);
        model.addAttribute("Information", information);
        return "informationManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("demo:info")
    public R info(@PathVariable("id") Integer id) {
        InformationDO information = informationService.get(id);
        return R.ok().put("information", information);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("information:save")
    public R save(@ModelAttribute InformationDO information) {
        information.setMerchantId(ShiroUtils.getMerchantId());
        information.setAvailable(1);
//        information.setContentText(EditUtil.delHtmlTag(information.getContent()));
        if (informationService.save(information) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("information:update")
    @ResponseBody
    public R update(@ModelAttribute InformationDO information) {
        informationService.update(information);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("information:delete")
    public R remove(Integer id) {
        if (informationService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("information:delete")
    public R remove(@RequestParam("ids[]") Integer[] ids) {
        informationService.batchRemove(ids);

        return R.ok();
    }

}
