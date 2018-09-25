package com.zwl.common.utils;

import com.zwl.system.domain.SysUserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtils {
    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前用户的user
     * @return
     */
    public static SysUserDO getUser() {
        return (SysUserDO) getSubjct().getPrincipal();
    }
    /**
     * 获取当前用户的userId
     * @return
     */
    public static Long getUserId() {
        return getUser().getUserId();
    }
    /**
     * 获取当前用户的用户名
     * @return
     */
    public static String getUserName() {
        return getUser().getUsername();
    }

    /**
     * 获取当前用户的商户号
     * @return
     */
    public static String getMerchantId() {
        return getUser().getMerchantId();
    }

    public static void logout() {
        getSubjct().logout();
    }

}
