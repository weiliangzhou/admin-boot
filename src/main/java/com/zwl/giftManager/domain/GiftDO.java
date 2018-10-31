package com.zwl.giftManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 17:50:24
 */
@Data
public class GiftDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //主标题
    private String giftMainTitle;
    //副标题
    private String giftViceTitle;
    //购买最低要求
    private Integer minRequirement;
    //产品主图
    private String giftMainImg;
    //产品附图1
    private String giftViceImg1;
    //产品附图2
    private String giftViceImg2;
    //产品附图3
    private String giftViceImg3;
    //价格
    private Integer price;
    //快递费
    private Integer expressFee;
    //库存
    private Integer stock;
    //
    private String giftDesc;
    //是否推荐，0不推荐，1推荐
    private Integer isRecommend;
    //是否展示，0不展示，1展示
    private Integer isShow;
    //商户号
    private String merchantId;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;


}
