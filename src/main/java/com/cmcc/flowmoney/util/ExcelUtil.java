package com.cmcc.flowmoney.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by echo on 2016/7/17.
 */
public class ExcelUtil {

    public static String getValue(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return null;
        }
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            xssfCell.setCellType(Cell.CELL_TYPE_STRING);
            return String.valueOf(xssfCell.getStringCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_STRING){
            // 返回字符串类型的值
            return String.valueOf(xssfCell.getStringCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BLANK) {
            return String.valueOf(xssfCell.getStringCellValue());
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }


    public static void write(XSSFWorkbook xssfWorkbook,String sheetName,boolean testResult) {
//        XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
//        xssfSheet.;
    }
    public static List<XSSFRow> convertXLS(XSSFWorkbook xssfWorkbook,String sheetName) {

        List<XSSFRow> xssfRowList = new ArrayList<XSSFRow>();
        if (xssfWorkbook == null) {
            return xssfRowList;
        }
        // 循环工作表Sheet
//        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
//            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            if (xssfSheet == null) {
                return xssfRowList;
            }
            // 循环行Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) {
                    continue;
                }
//                readRowData(xssfRow);
                xssfRowList.add(xssfRow);
            }
        return xssfRowList;
//        }
    }
    public static XSSFWorkbook readTestData(String filePath) {

//        fileName = "testdata/payaccount-testdata.xlsx";
//        String projectPath = System.getProperty("user.dir");
//        StringBuilder filePath = new StringBuilder();
//        filePath.append(projectPath).append(File.separator)
//                .append("src").append(File.separator)
//                .append("main").append(File.separator)
//                .append("resources").append(File.separator)
////                .append("poi").append(File.separator)
//                .append("testdata").append(File.separator)
//                .append(fileName);
//
//        System.out.println(filePath);
        XSSFWorkbook xssfWorkbook = null;
        InputStream inputStream = null;
        try {
//            inputStream =Resources.getResourceAsStream(fileName);
            inputStream = new FileInputStream(filePath);
            xssfWorkbook = new XSSFWorkbook(inputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return xssfWorkbook;

    }

    public static void writeTestData(String filePath,XSSFWorkbook xssfWorkbook) {
        OutputStream outputStream = null;
        try {
            outputStream= new FileOutputStream(filePath);
            xssfWorkbook.write(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
