package com.zwl.withdrawManager.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-29 15:47:25
 */
@Data
public class WithdrawDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String withdrawId;
    //提现金额
    private Integer money;
    //
    private String openId;
    //
    private String realName;
    //
    private String userId;
    //收款账户
    private String account;
    // 0未提交 1 审核中 2审核通过(前端显示到款中) 3未通过 4成功（到账）
    private Integer status;
    //支付方式：目前只支持微信1 余额2
    private Integer payWay;
    //审核人员
    private String operator;
    //
    private String remark;
    //审核通过时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date successTime;
    //
    private String merchantId;
    //提现微信订单号
    private String paymentNo;
    //到账时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date paymentTime;
    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    //
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    //
    private Integer available;
    //下线人数
    private Integer xiaxianCount;
    //消费金额
    private Integer actualMoney;
    //可用余额
    private Integer balance;
    //累计返佣
    private Integer totalMaidAmount;
    //身份证号码
    private String idCard;
    //手机号码
    private String phone;
    // 银行卡用户名
    private String bankName;
    //银行卡 省
    private String bankProvince;
    //银行卡 市
    private String bankCity;
    //银行卡 区
    private String bankArea;
    //银行卡 支行
    private String bankBranch;
    //银行卡地址 省+市+区
    private String bankAddress;
}
