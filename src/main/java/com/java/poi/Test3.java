package com.java.poi;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-18 21:21
 **/
public class Test3 {
    public static void main(String[] args) throws Exception {
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("创建sheet页");
        //创建行,传入参数0,表明创建的是第一行
        Row row = sheet.createRow(0);
        //创建列，传入参数0,表明创建的是第一列，即第一个单元格
        Cell cell = row.createCell(0);
        //给单元格设置值
        cell.setCellValue("第一行第一列");
        //创建第二列，即第二个单元格
        row.createCell(1).setCellValue(1111);

        //创建第二行
        Row row1 = sheet.createRow(1);
        //创建第二行的第一列
        row1.createCell(0).setCellValue("第二行第一列");
        //创建第二行的第二列
        row1.createCell(1).setCellValue(2222);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\3.xls");
        ((HSSFWorkbook) workbook).write(fileOutputStream);
        fileOutputStream.close();
    }
}
