package com.cmcc.flowmoney.model;

import com.cmcc.flowmoney.model.json.input.Body;
import com.cmcc.flowmoney.model.json.input.BusiInfo;
import com.cmcc.flowmoney.model.json.input.InputJsonData;
import com.cmcc.flowmoney.model.json.input.Root;
import com.cmcc.flowmoney.model.json.output.OutputJsonData;
import com.cmcc.flowmoney.util.ExcelUtil;
import com.cmcc.flowmoney.util.biz.ExcelFieldEnum;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LIGHTNING on 2016/7/31.
 */
public class TestData {

    private InputJsonData inputJsonData;

    private OutputJsonData outputJsonData;
    //    private List<String> expectedResults;
    private String desc;

    public InputJsonData getInputJsonData() {
        return inputJsonData;
    }

    public void setInputJsonData(InputJsonData inputJsonData) {
        this.inputJsonData = inputJsonData;
    }

    public OutputJsonData getOutputJsonData() {
        return outputJsonData;
    }

    public void setOutputJsonData(OutputJsonData outputJsonData) {
        this.outputJsonData = outputJsonData;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public TestData() {
    }

    public TestData(boolean init) {
        if (init == true) {
            //init inputJsonData
            InputJsonData inputJsonData = new InputJsonData();
            Root root = new Root();
            Body body = new Body();
            BusiInfo busiInfo = new BusiInfo();
            inputJsonData.setRoot(root);
            root.setBody(body);
            body.setBusiInfo(busiInfo);
            //init outputJsonData
            OutputJsonData outputJsonData = new OutputJsonData();
            com.cmcc.flowmoney.model.json.output.Root outputRoot = new com.cmcc.flowmoney.model.json.output.Root();
            com.cmcc.flowmoney.model.json.output.Body outputBody = new com.cmcc.flowmoney.model.json.output.Body();
            outputJsonData.setRoot(outputRoot);
            outputRoot.setBody(outputBody);

            this.setInputJsonData(inputJsonData);
            this.setOutputJsonData(outputJsonData);
        }
    }

    public List<TestData> build(List<XSSFRow> xssfRowList) {

        XSSFRow firstXssfRow = xssfRowList.get(1);
        Map<Integer, String> xlsFieldMap = new HashMap<Integer, String>();
        for (int i = 1; i <= firstXssfRow.getLastCellNum(); i++) {
            xlsFieldMap.put(i, ExcelUtil.getValue(firstXssfRow.getCell(i - 1)));
        }
        xssfRowList.remove(0);
        xssfRowList.remove(0);
        List<TestData> testDataList = new ArrayList<TestData>();
        for (XSSFRow xssfRow : xssfRowList) {
            TestData testData = new TestData(true);

            for (Map.Entry<Integer, String> integerStringEntry : xlsFieldMap.entrySet()) {
                int fieldNO = integerStringEntry.getKey();
                String fieldName = integerStringEntry.getValue();
                XSSFCell fieldValue = xssfRow.getCell(fieldNO - 1);
                setTestDataFiled(testData, fieldName, fieldValue);
            }

            testDataList.add(testData);
        }
        return testDataList;

    }


    public static void setTestDataFiled(TestData testData, String fieldName, XSSFCell fielValue) {

        BusiInfo busiInfo = testData.getInputJsonData().getRoot().getBody().getBusiInfo();
        com.cmcc.flowmoney.model.json.output.Body outPutBody = testData.getOutputJsonData().getRoot().getBody();
        if (ExcelFieldEnum.migusum.equals(fieldName)) {
            busiInfo.setMigusum((ExcelUtil.getValue(fielValue)));
        } else if (ExcelFieldEnum.passId.equals(fieldName)) {
            busiInfo.setPassId((ExcelUtil.getValue(fielValue)));
        } else if (ExcelFieldEnum.count.equals(fieldName)) {
            busiInfo.setCount((ExcelUtil.getValue(fielValue)));
        }

        // TODO: 2016/7/31


        else if (ExcelFieldEnum.desc.equals(fieldName)) {
            testData.setDesc((ExcelUtil.getValue(fielValue)));
        } else if (ExcelFieldEnum.returnCode.equals(fieldName)) {
            outPutBody.setReturnCode((ExcelUtil.getValue(fielValue)));
        } else if (ExcelFieldEnum.returnMessage.equals(fieldName)) {
            outPutBody.setReturnMsg((ExcelUtil.getValue(fielValue)));
        }
    }


}