package com.zwl.informationManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-30 15:44:24
 */
@Data
public class InformationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //资讯连接
    private Integer id;
    //所属商户id
    private String merchantId;
    //外部链接
    private String url;
    //是否发布状态 默认0不发布 1发布
    private Integer isShow;
    //
    private String title;
    //
    private String logoUrl;
    //音频地址
    private String audioUrl;
    //
    private String content;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;
    //不带格式的介绍
    private String contentText;

}
