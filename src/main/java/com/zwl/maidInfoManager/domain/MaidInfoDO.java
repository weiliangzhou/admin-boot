package com.zwl.maidInfoManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 14:53:30
 */
@Data
public class MaidInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String orderNo;
    //获得分佣的userid
    private String userId;
    //产生分佣的userid
    private String maidUserId;
    //分佣金额按照分为单位存储
    private Integer maidMoney;
    //
    private Integer maidPercent;
    //
    private Integer orderActualMoney;
    //
    private String merchantId;
    //
    private String productId;
    //
    private String productName;
    //
    private Integer level;
    //
    private String levelName;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;

    //推荐人手机号码
    private String referrerMobile;
    //推荐人真实姓名
    private String referrerRealName;
    //推荐人手机号码
    private String maidMobile;
    //推荐人真实姓名
    private String maidRealName;

}
