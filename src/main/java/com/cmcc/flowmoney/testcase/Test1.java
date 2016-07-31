package com.cmcc.flowmoney.testcase;

import com.alibaba.fastjson.JSON;
import com.cmcc.flowmoney.model.json.input.Body;
import com.cmcc.flowmoney.model.json.input.InputJsonData;
import com.cmcc.flowmoney.model.json.input.Root;
import com.cmcc.flowmoney.model.json.input.BusiInfo;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class Test1 {
    public static void main(String[] args) {
        Root root = new Root();
        Body body = new Body();
        root.setBody(body);
        BusiInfo busiInfo = new BusiInfo();
        busiInfo.setMigusum("migusum1");
        body.setBusiInfo(busiInfo);
        InputJsonData jsonData = new InputJsonData();
        jsonData.setRoot(root);
        String string = JSON.toJSONString(jsonData);
        System.out.println(string);
    }
}
