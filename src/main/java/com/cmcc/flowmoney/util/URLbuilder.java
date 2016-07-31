package com.cmcc.flowmoney.util;

import com.cmcc.flowmoney.util.biz.InterfaceType;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by ech0 on 2016/3/13.
 */
public class URLbuilder {

    public static String HOST = "";
    public static String PORT = "";
    public static String PATH = "";
    public static String INTERFACE = "";


    public static String buildRequestUrl(InterfaceType interfaceType) {


        String url = null;
        try {
//            String encodedXML = URLEncoder.encode(xml, "UTF-8");



            url = "http://" + HOST + ":" + PORT + PATH + interfaceType.getInterfaceName();


            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return url;
    }


}
