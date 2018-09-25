package com.zwl.certificationManager.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * @author ${author}
 * @email 382308664@qq.com
 * @date 2018-08-31 10:38:51
 */
@Data
public class UserCertificationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //0未提交1审核中 2审核通过 3未通过
    private Integer status;
    //审核人员id
    private String operator;
    //真实姓名
    private String realname;
    //身份证
    private String idCard;
    //身份证正面照
    private String img1Url;
    //身份证国徽面
    private String img2Url;
    //手持身份证
    private String img3Url;
    //
    private String userId;
    //商户所属id
    private String merchantId;
    //驳回原因
    private String rejectReason;
    //审核时间
    private Date auditTime;
    //
    private Date createTime;
    //
    private Date modifyTime;
    //
    private Integer available;

    //绑定手机号
    private String registerMobile;


}
