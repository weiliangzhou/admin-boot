package com.zwl.giftManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author th 2 brother
 * @email 382308664@qq.com
 * @date 2018-10-30 15:56:39
 */
@Data
public class UserGiftDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    private String userId;

    /**
     * 礼品编号
     */
    private Long giftId;
    /**
     * 价格(分)
     */
    private Integer price;
    /**
     * 礼品展示图
     */
    private String giftMainImg;
    /**
     * 标题
     */
    private String giftTitle;

    /**
     * 号码
     */
    private String phone;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 地址
     */
    private String address;

    /**
     * 快递单号
     */
    private String expressNo;

    /**
     * 快递公司 1韵达 2圆通 3EMS 4申通
     */
    private Integer expressCompany;

    private String merchantId;

    /**
     * 订单状态 0:待发货 1:已发货
     */
    private Integer orderState;

    private Date createTime;

    private Date modifyTime;

    private Integer available;

}
