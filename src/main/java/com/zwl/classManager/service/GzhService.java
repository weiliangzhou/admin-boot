package com.zwl.classManager.service;


import java.util.List;

/**
 * @author 二师兄超级帅
 * @Title: GZHService
 * @ProjectName parent
 * @Description: TODO
 * @date 2018/8/2211:59
 */
public interface GzhService {
    /**
     * 发送单个消息
     *
     * @param openId
     * @param className
     * @param merchantId
     * @param gzAppId
     * @param gzAppKey
     * @param templateId
     */
    public void sendGzhMsgByOne(String openId, String className, String classType, String teacherName, String classTime, String merchantId, String gzAppId, String gzAppKey, String xcxAppId, String templateId);

    /**
     * 获取公众号openidList
     *
     * @param merchantId
     * @param appid
     * @param appSecret
     * @return
     */
    public List getGzhOpenIdList(String merchantId, String appid, String appSecret);

    /**
     * 发送全部关注公众号
     *
     * @param className
     * @param merchantId
     */
    public void sendGzhMsgByAll(String className, String classType, String teacherName, String classTime, String merchantId);

}
