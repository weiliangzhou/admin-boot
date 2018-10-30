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
    //
    private Long id;
    //
    private String userId;
    //书籍名称
    private Integer giftTitle;
    //收货人手机
    private String phone;
    //省
    private String province;
    //市
    private String city;
    //区
    private String area;
    //收货人地址
    private String address;
    //快递单号
    private String expressNo;
    //快递公司 1韵达 2圆通 3EMS
    private Integer expressCompany;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;


}
