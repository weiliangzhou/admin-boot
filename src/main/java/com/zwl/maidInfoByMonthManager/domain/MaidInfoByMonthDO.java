package com.zwl.maidInfoByMonthManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:36:31
 */
@Data
public class MaidInfoByMonthDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //获得分佣的userid
    private String userId;
    //分佣金额按照分为单位存储
    private Integer maidMoney;
    //百分比
    private Integer maidPercent;
    //总业绩
    private Integer totalPerformance;
    //0团队奖1纵向奖
    private Integer maidType;
    //
    private String merchantId;
    //
    private Date recordTime;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;
    //推荐人手机号
    private String referrerMobile;
    //推荐人真实姓名
    private String referrerRealName;


}
