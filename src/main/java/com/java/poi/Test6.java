package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-19 09:22
 **/
public class Test6 {

    public static void main(String[] args) throws Exception {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("创建sheet页");
        Row row = sheet.createRow(2);//创建行
        row.setHeightInPoints(30);
        createCell(wb, row, (short) 0, (short) 600, (short) 600);

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\3.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();
    }

    /**
     * 创建一个单元格，并为其指定对其的方式
     *
     * @param wb
     * @param row
     * @param colunm
     * @param halign
     * @param valign
     */
    private static void createCell(Workbook wb, Row row, short colunm, short halign, short valign) {
        Cell cell = row.createCell(colunm);
        cell.setCellValue(new HSSFRichTextString(" Align  it")); //设置值
        CellStyle cellStyle = wb.createCellStyle();  //设置样式
        cellStyle.setAlignment(HorizontalAlignment.forInt(halign)); //设置水平方向的对其方式
        cellStyle.setVerticalAlignment(VerticalAlignment.forInt(valign)); //设置垂直方法的对齐方式
        cell.setCellStyle(cellStyle); //设置单元格样式

    }
}