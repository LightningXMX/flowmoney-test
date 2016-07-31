package com.cmcc.flowmoney.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class JsonUtil {

    public static String convertToJsonString(Object object){
        String jsonString = "";

        try {
            jsonString = JSON.toJSONString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
