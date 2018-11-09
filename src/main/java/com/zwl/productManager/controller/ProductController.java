package com.zwl.productManager.controller;

import com.zwl.common.utils.*;
import com.zwl.productManager.domain.ProductDO;
import com.zwl.productManager.service.ProductService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:00:27
 */
@Controller
@RequestMapping("/productManager")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    @RequiresPermissions("productManager:product")
    String Product() {
        return "productManager/product";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("productManager:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<ProductDO> productList = productService.list(query);
        int total = productService.count(query);
        PageUtils pageUtils = new PageUtils(productList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("productManager:save")
    String add() {
        return "productManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("productManager:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        ProductDO product = productService.get(id);
        model.addAttribute("product", product);
        return "productManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("productManager:info")
    public R info(@PathVariable("id") Long id) {
        ProductDO product = productService.get(id);
        return R.ok().put("product", product);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("productManager:save")
    public R save(ProductDO product) {
        if (productService.save(product) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("productManager:update")
    @ResponseBody
    public R update(@ModelAttribute ProductDO product) {
//        String contentText=EditUtil.delHtmlTag(product.getContent());
//        product.setContentText(contentText);
        productService.update(product);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("productManager:remove")
    public R remove(Long id) {
        if (productService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("productManager:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        productService.batchRemove(ids);

        return R.ok();
    }

}
