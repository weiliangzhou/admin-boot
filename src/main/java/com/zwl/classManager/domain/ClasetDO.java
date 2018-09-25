package com.zwl.classManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-28 21:17:13
 */
@Data
public class ClasetDO implements Serializable {
    private static final long serialVersionUID = 1L;
    //
    private Long id;
    //套课标题
    private String title;
    //横幅广告图
    private String bannerUrl;
    //
    private String content;
    //所属分类
    private Integer categoryId;
    //所属商户id
    private String merchantId;
    //该字段 是否发布状态 默认0不发布 1发布
    private Integer isShow;
    //观看要求的最低会员等级
    private Integer requiredMemberLevel;
    //
    private Date createTime = new Date();
    //
    private Date modifyTime;
    //
    private Integer available = 1;
    //不带格式的介绍
    private String contentText;
    //
    private Integer style;
    //
    private Integer isRecommend;
    //
    private String frontCover;
    //分类名称
    private String categoryName;

}
