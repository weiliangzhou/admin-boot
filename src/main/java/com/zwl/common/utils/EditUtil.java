package com.zwl.common.utils;

public class EditUtil {
    public static String delHtmlTag(String str) {
        String newstr = "";
        newstr = str.replaceAll("<[.[^>]]*>", "");
        newstr = newstr.replaceAll(" ", "");
        newstr = newstr.replaceAll("&nbsp;","");
        return newstr;
    }
}
