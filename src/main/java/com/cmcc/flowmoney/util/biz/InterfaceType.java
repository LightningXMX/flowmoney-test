package com.cmcc.flowmoney.util.biz;

/**
 * Created by LIGHTNING on 2016/7/24.
 */
public enum  InterfaceType {

    publish(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    freeze(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    deFreeze(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    createAccount(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    donateC2U(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    freezeTrans(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    transflowU2U(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    changeflow(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    queryBalance(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish),
    updateAccount(InterfaceInfo.publish,ExcelInfo.ExcelSheetName_publish);


    private String interfaceName;
    private String sheetName;

    InterfaceType(String interfaceName, String sheetName) {
        this.interfaceName = interfaceName;
        this.sheetName = sheetName;
    }

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
}
