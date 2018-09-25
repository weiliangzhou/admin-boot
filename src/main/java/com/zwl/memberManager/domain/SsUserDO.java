package com.zwl.memberManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 *
 *
 * @author 二师兄超级帅
 * @email 382308664@qq.com
 * @date 2018-08-27 16:35:27
 */
@Data
public class SsUserDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String userId;
    //微信openid
    private String wechatOpenid;
    //微信unionID
    private String wechatUnionId;
    //商户号
    private String merchantId;
    //从什么渠道注册。1、wechat 微信注册 2、线下导入
    private Integer registerFrom;
    //绑定手机号
    private String registerMobile;
    //真实姓名
    private String realName;
    //
    private String logoUrl;
    //推荐人user_id
    private String referrer;
    //会员等级
    private Integer memberLevel;
    //会员等级名称
    private String levelName;
    //是否购买
    private Integer isBuy;
    //会员到期时间
    private Date expiresTime;
    //注册时间
    private Date registerTime;
    //更新时间
    private Date modifyTime;
    private Integer available;

    //推荐人手机号码
    private String referrerMobile;
    //推荐人真实姓名
    private String referrerRealName;
    //下线人数
    private Integer xiaxianCount;
    //消费金额
    private Integer actualMoney;
    //总业绩
    private Integer totalPerformance;

}
