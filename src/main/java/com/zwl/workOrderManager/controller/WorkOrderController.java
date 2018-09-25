package com.zwl.workOrderManager.controller;

import com.zwl.common.utils.PageUtils;
import com.zwl.common.utils.Query;
import com.zwl.common.utils.R;
import com.zwl.common.utils.ShiroUtils;
import com.zwl.memberManager.domain.SsUserDO;
import com.zwl.memberManager.service.SsUserService;
import com.zwl.orderManager.domain.OrderDO;
import com.zwl.orderManager.service.OrderService;
import com.zwl.productManager.domain.ProductDO;
import com.zwl.productManager.service.ProductService;
import com.zwl.workOrderManager.domain.WorkOrderDO;
import com.zwl.workOrderManager.service.WorkOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
 * @date 2018-09-19 14:26:45
 */
@Controller
@RequestMapping("/workOrder")
@Slf4j
public class WorkOrderController {
    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private SsUserService ssUserService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @GetMapping()
    @RequiresPermissions("workOrder:workOrder")
    String WorkOrder() {
        return "workOrderManager/workOrder";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("workOrder:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        //查询列表数据
        params.put("merchantId", ShiroUtils.getMerchantId());
        params.put("available", 1);
        Query query = new Query(params);

        List<WorkOrderDO> workOrderList = workOrderService.list(query);
        int total = workOrderService.count(query);
        PageUtils pageUtils = new PageUtils(workOrderList, total);
        return pageUtils;
    }

    @GetMapping("/add")
    @RequiresPermissions("workOrder:add")
    String add() {
        return "workOrderManager/add";
    }

    @GetMapping("/edit/{id}")
    @RequiresPermissions("workOrder:edit")
    String edit(@PathVariable("id") Long id, Model model) {
        WorkOrderDO workOrder = workOrderService.get(id);
        model.addAttribute("workOrder", workOrder);
        return "workOrderManager/edit";
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    @RequiresPermissions("workOrder:info")
    public R info(@PathVariable("id") Long id) {
        WorkOrderDO workOrder = workOrderService.get(id);
        return R.ok().put("workOrder", workOrder);
    }

    /**
     * 保存
     */
    @ResponseBody
    @PostMapping("/save")
    @RequiresPermissions("workOrder:save")
    public R save(WorkOrderDO workOrder) {
        //根据推荐人手机号 查询是否存在推荐人
        String referrerPhone = workOrder.getReferrerPhone();
        String phone = workOrder.getPhone();
        String remark = workOrder.getRemark();
        Integer productLevel = workOrder.getProductLevel();
        if (productLevel == null)
            return R.error(444, "购买产品不能为空！");
        String merchantId = ShiroUtils.getMerchantId();
        SsUserDO referrerUserDO = ssUserService.getUserByPhone(referrerPhone, merchantId);
        if (referrerUserDO == null)
            return R.error(444, "推荐人不存在！");
        if(referrerUserDO.getMemberLevel()<=1)
            return R.error(444, "推荐人没有购买产品！");
        //根据购买手机号 查询是否存在
        // 如果存在
        // 查询是否存在推荐人，
        // 如果存在 则直接报错=已存在推荐人
        SsUserDO ssUserDO = ssUserService.getUserByPhone(phone, merchantId);
        Integer referrerLevel = referrerUserDO.getMemberLevel();
        if (ssUserDO == null)
            return R.error(444, "会员不存在！");
        else if (StringUtils.isNotBlank(ssUserDO.getReferrer()))
            return R.error(444, "已存在推荐人！");
        //记录workOrder
        String referrerUserId= referrerUserDO.getUserId();
        String userId=ssUserDO.getUserId();
        workOrder.setReferrerUserId(referrerUserId);
        //推荐人等级
        workOrder.setReferrerLevel(referrerLevel);
        //需要修复返佣金额
        Integer maidMoney = 0;
        ProductDO productDO = productService.getProductByLevel(ssUserDO.getMemberLevel(), ShiroUtils.getMerchantId());
        Integer maidPercent_referrer = productDO.getMaidPercent();

        Integer price = productDO.getPrice();
        switch (productLevel) {
            case 1:
                maidMoney = 8910;
                break;
            default:
                maidMoney = price * maidPercent_referrer / 100;
                break;
        }
        workOrder.setMaidMoney(maidMoney);
        //购买人userId
        workOrder.setUserId(userId);
        //订单支付金额
        workOrder.setOrderMoney(price);
        //购买人手机
        workOrder.setPhone(phone);
        //购买订单号
        OrderDO orderDO = orderService.getOrderByLevelAndUserId(productLevel, userId);
        if (orderDO == null)
            return R.error(444, "此会员没有购买任何产品！");
        String orderNo = orderDO.getOrderNo();
        //根据此订单号查询返佣表，如果存在  则报出已经返佣(已经在返佣表做订单号唯一索引)
        workOrder.setOrderNo(orderNo);
        // 需要手动确认
        workOrder.setCreateTime(new Date());
        workOrder.setRemark(remark);
        workOrder.setStatus(0);
        workOrder.setReferrerPhone(referrerPhone);
        if (workOrderService.save(workOrder) > 0) {
            log.info("INSERT INTO `ss_maid_info` (`order_no`,`user_id`,`maid_user_id`,`maid_money`,`maid_percent`,`order_actual_money`,`merchant_id`,`product_id`,`product_name`,`level`,`level_name`,`create_time`,`modify_time`,`available`) VALUES(\'" +
                    orderNo + "\',\'" +
                    referrerUserId + "\',\'" +
                    userId + "\'," +
                    maidMoney + "," +
                    maidPercent_referrer + "," +
                    price + ",\'" +
                    ssUserDO.getMerchantId() + "\'," +
                    productDO.getId() + ",\'" +
                    productDO.getProductName() + "'," +
                    productDO.getLevel() + ",\'" +
                    productDO.getLevelName() + "\'," +
                    "now(),NOW(),1);\n" +
                    "\n" +
                    "UPDATE ss_user set referrer =\'" +
                    referrerUserId +"\'"+
                    " where user_id in(\'" +
                    userId+
                    "\');" +
                    "\n" +
                    "update ss_user_account set balance =balance+"+
                      maidMoney+
                    " where user_id=\'" +
                    referrerUserId +
                    "\';");
            return R.ok();
        }
        return R.error();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("workOrder:update")
    @ResponseBody
    public R update(@ModelAttribute WorkOrderDO workOrder) {
        workOrderService.update(workOrder);
        return R.ok();
    }


    /**
     * 删除
     */
    @PostMapping("/remove")
    @ResponseBody
    @RequiresPermissions("workOrder:remove")
    public R remove(Long id) {
        if (workOrderService.remove(id) > 0) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 删除
     */
    @PostMapping("/batchRemove")
    @ResponseBody
    @RequiresPermissions("workOrder:remove")
    public R remove(@RequestParam("ids[]") Long[] ids) {
        workOrderService.batchRemove(ids);

        return R.ok();
    }

}
