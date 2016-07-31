package com.cmcc.flowmoney.util;

import com.cmcc.flowmoney.model.TestData;
import com.cmcc.flowmoney.model.json.input.InputJsonData;
import com.cmcc.flowmoney.util.biz.ExcelInfo;
import com.cmcc.flowmoney.util.biz.InterfaceType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ech0 on 2016/3/13.
 */
public class TestBase {

    private static ApplicationContext context;
    protected static HttpClientUtil httpClientUtil;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        initHttpClient();
//        initMybatis();
    }

    private static void initHttpClient() {
        httpClientUtil = (HttpClientUtil) context.getBean("httpClientUtil");

    }
//
//    private static void initMybatis() {
//        String resource = "org/mybatis/example/mybatis-config.xml";
//        InputStream inputStream = null;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session = sqlSessionFactory.openSession();
//    }


    protected List createExpectedResult() {
        return new ArrayList<String>();
    }

    protected List getTestData(InterfaceType interfaceType) {
        String filePath = getFilePath();
        XSSFWorkbook xssfWorkbook = ExcelUtil.readTestData(filePath);
        String sheetName = interfaceType.getSheetName();
        TestData testData = new TestData();
//        if (InterfaceType.publish.equals(interfaceType)){
//             sheetName = ExcelInfo.ExcelRefundSheetName;
//             testData = new RefundTestData();
//        }else if (InterfaceType.askForPay.equals(interfaceType)){
//            sheetName = ExcelInfo.ExcelAskForPaySheetName;
//        }else if (InterfaceType.settlePeriodChange.equals(interfaceType)){
//            sheetName = ExcelInfo.ExcelChangeSettlePeriodSheetName;
//        }
        List<XSSFRow> refundRowList = ExcelUtil.convertXLS(xssfWorkbook, sheetName);


        List testDataList = testData.build(refundRowList);
        return testDataList;
    }


    protected HttpResponse test(InputJsonData inputJsonData, InterfaceType interfaceType) {

        String jsonString = JsonUtil.convertToJsonString(inputJsonData);

        String url = URLbuilder.buildRequestUrl(interfaceType);

//        HttpResponse response = HttpClientUtil.get(url);

        HttpResponse response = HttpClientUtil.post(url,jsonString);
        return response;

    }

    protected String getFilePath() {
        StringBuilder filePath = new StringBuilder().
                append(System.getProperty("user.dir")).append(File.separator)
                .append("src").append(File.separator)
                .append("main").append(File.separator)
                .append("resources").append(File.separator)
                .append("testdata").append(File.separator)
                .append(ExcelInfo.ExcelFileName);

        return filePath.toString();
    }
}
