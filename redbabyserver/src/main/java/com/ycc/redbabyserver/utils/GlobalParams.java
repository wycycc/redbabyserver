package com.ycc.redbabyserver.utils;

/**
 * Created by Administrator on 2016/12/14.
 */
public class GlobalParams {
    public static String getTitle(String name){
        return "response\":\""+name+"\",";
    }
    public static String getError(String name){
        return   "{\"response\": \"error\",\"error\": {\"text\": \""+name+"\"}}";
    }
}
