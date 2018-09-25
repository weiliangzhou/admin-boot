package com.zwl.workOrderManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-09-19 14:26:45
 */
@Data
public class WorkOrderDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    //推荐人userId
    private String referrerUserId;
    //推荐人手机
    private String referrerPhone;
    //推荐人等级
    private Integer referrerLevel;
    //需要修复返佣金额
    private Integer maidMoney;
    //购买人userId
    private String userId;
    //订单支付金额
    private Integer orderMoney;
    //购买产品等级
    private Integer productLevel;
    //购买人手机
    private String phone;
    //购买订单号
    private String orderNo;
    //状态  0待处理1处理完成
    private Integer status;
    //备注
    private String remark;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available = 1;


}
