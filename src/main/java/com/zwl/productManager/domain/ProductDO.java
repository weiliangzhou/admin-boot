package com.zwl.productManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 15:00:27
 */
@Data
public class ProductDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //会员等级
    private Integer level;
    //等级名称
    private String levelName;
    //产品名称
    private String productName;
    //分佣比例 /100
    private Integer maidPercent;
    //有效期按照天为单位存储
    private Integer validityTime;
    //价格
    private Integer price;
    //
    private String merchantId;
    //商品图片url
    private String imageUrl;
    //商品介绍（带格式）
    private String content;
    //商品介绍（不带格式）
    private String contentText;
    //购买的人数
    private Integer buyCount;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;


}
