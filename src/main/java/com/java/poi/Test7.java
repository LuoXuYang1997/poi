package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-19 09:45
 **/
public class Test7 {
    public static void main(String[] args) throws Exception {

        Workbook wb=new HSSFWorkbook();
        Sheet sheet = wb.createSheet("sheet页");
        Row row=sheet.createRow(1);

        //创建一个字体
        Font font=wb.createFont();
        font.setFontHeightInPoints((short) 24);
        font.setFontName("Courier New ");
        font.setItalic(true);
        font.setStrikeout(true);

        CellStyle style=wb.createCellStyle();
        style.setFont(font);

        Cell cell = row.createCell((short) 1);
        cell.setCellValue("this is test of fonts");
        cell.setCellStyle(style);

        FileOutputStream is=new FileOutputStream("D:\\3.xls");
        wb.write(is);
        is.close();
    }
}
