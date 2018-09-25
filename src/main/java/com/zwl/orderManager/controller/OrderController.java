package com.zwl.orderManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.orderManager.domain.OrderDO;
import com.zwl.orderManager.service.OrderService;
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
 * @date 2018-08-29 10:28:37
 */
@Controller
@RequestMapping("/orderManager")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping()
    @RequiresPermissions("order:order")
    String Order() {
        return "orderManager/order";
    }

    @ResponseBody
    @GetMapping("/list")
//    @RequiresPermissions("demo:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);
        List<OrderDO> orderList = orderService.list(query);
        int total = orderService.count(query);
        PageUtils pageUtils = new PageUtils(orderList, total);
        return pageUtils;
    }

    @GetMapping("/add")
        //@RequiresPermissions("blog:bComments")
    String add() {
        return "orderManager/add";
    }

    @GetMapping("/edit/{orderNo}")
        //@RequiresPermissions("blog:bComments")
    public String edit(@PathVariable("orderNo") String orderNo, Model model) {
        OrderDO order = orderService.get(orderNo);
        model.addAttribute("Order", order);
        return "orderManager/edit";
    }

    @GetMapping("/info/{orderNo}")
        //@RequiresPermissions("blog:bComments")
    public String info(@PathVariable("orderNo") String orderNo, Model model) {
        OrderDO order = orderService.get(orderNo);
        model.addAttribute("Order", order);
        return "orderManager/info";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{orderNo}")
    @RequiresPermissions("order:info")
    public R info(@PathVariable("orderNo") String orderNo) {
        OrderDO order = orderService.get(orderNo);
        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("demo:save")
    public R save(OrderDO order) {
        if (orderService.save(order) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("demo:update")
    public R update(@RequestBody OrderDO order) {
        orderService.update(order);

        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("demo:remove")
    public R remove(String orderNo) {
        if (orderService.remove(orderNo) > 0) {
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
    public R remove(@RequestParam("ids[]") String[] orderNos) {
        orderService.batchRemove(orderNos);

        return R.ok();
    }

}
