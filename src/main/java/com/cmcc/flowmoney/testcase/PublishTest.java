package com.cmcc.flowmoney.testcase;

import com.alibaba.fastjson.JSONObject;
import com.cmcc.flowmoney.model.TestData;
import com.cmcc.flowmoney.model.json.input.InputJsonData;
import com.cmcc.flowmoney.model.json.output.OutputJsonData;
import com.cmcc.flowmoney.util.HttpResponse;
import com.cmcc.flowmoney.util.biz.InterfaceType;
import com.cmcc.flowmoney.util.TestBase;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class PublishTest extends TestBase {

    @DataProvider(name = "testData_publish")
    public Object[][] testData_publish() {

        List<TestData> testDataList = getTestData(InterfaceType.publish);

        Object[][] allTestData = new Object[testDataList.size()][3];

        for (int i = 0; i < testDataList.size(); i++) {
            InputJsonData inputJsonData = testDataList.get(i).getInputJsonData();
            OutputJsonData outputJsonData = testDataList.get(i).getOutputJsonData();
            String desc = testDataList.get(i).getDesc();

            Object[] testData = {inputJsonData, outputJsonData, desc};
            allTestData[i] = testData;
        }

        return allTestData;

    }

    @Test(dataProvider = "testData_publish", groups = "publish")
    public void test(InputJsonData inputJsonData, OutputJsonData outputJsonData, String desc) {
        HttpResponse response = test(inputJsonData, InterfaceType.publish);

        try {
            String content = response.getContent();
            JSONObject jsonObject =  JSONObject.parseObject(response.getContent());

//            if (jsonObject!=null&& jsonObject instanceof )
            String expectedReturnCode = outputJsonData.getRoot().getBody().getReturnCode();
            String expectedReturnMsg = outputJsonData.getRoot().getBody().getReturnMsg();
            Assert.assertTrue(content.contains(expectedReturnCode));
            Assert.assertTrue(content.contains(expectedReturnMsg));

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
