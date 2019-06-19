package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-18 21:47
 **/
public class Test4 {
    public static void main(String[] args) throws Exception {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("创建sheet页");
        Row row = sheet.createRow(0);//创建行
        Cell cell = row.createCell(0);//创建一个单元格， 第一列
        cell.setCellValue(new Date());  //给单元格设置值

        //公共接口CreationHelper
        //一个对象，用于处理实例化HSSF和XSSF所需的各种实例的具体类
        CreationHelper creationHelper = wb.getCreationHelper();

        //创建工作簿的样式
        CellStyle cellStyle = wb.createCellStyle();
        //设置日期格式
        cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy/mm/dd hh:mm:ss"));
        cell = row.createCell(1);//创建二个单元格， 第一列
        cell.setCellValue(new Date());  //第二个单元格
        cell.setCellStyle(cellStyle);

        //第二种样式
        //Calendar.getInstance()是获取一个Calendar对象并可以进行时间的计算，时区的指定
        //new Date()是创建了一个date对象，默认是utc格式的。
        cell = row.createCell(2);
        cell.setCellValue(Calendar.getInstance());
        cell.setCellStyle(cellStyle);


        FileOutputStream fileOutputStream = new FileOutputStream("D:\\4.xls");
        ((HSSFWorkbook) wb).write(fileOutputStream);
        fileOutputStream.close();
    }
}
