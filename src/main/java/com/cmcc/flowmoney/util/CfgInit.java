package com.cmcc.flowmoney.util;

import com.cmcc.flowmoney.util.biz.ExcelInfo;
import com.cmcc.flowmoney.util.biz.InterfaceInfo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ech0 on 2016/3/17.
 */
@Component
public class CfgInit {

    public void init() {

        System.out.println("init");

        InputStream is = Object.class.getResourceAsStream("/config.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MD5Generator.MD5_KEY = (String) properties.get("MD5_KEY");

        URLbuilder.HOST = (String) properties.get("HOST");
        URLbuilder.PORT = (String) properties.get("PORT");
        URLbuilder.PATH = (String) properties.get("PATH");
        InterfaceInfo.publish = (String) properties.get("Interface_publish");

        ExcelInfo.ExcelSheetName_publish = (String) properties.get("ExcelSheetName_publish");
//        InterfaceInfo.publish =  (String) properties.get("Interface_publish");


        ExcelInfo.ExcelFileName = (String) properties.get("ExcelFileName");


    }
}
