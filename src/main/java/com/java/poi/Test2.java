package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;

/**
 * @program: IdeaProjects
 * @description: 创建一个sheet页
 * @author: Lxy
 * @create: 2019-06-18 21:15
 **/
public class Test2 {
    public static void main(String[] args) throws Exception {
        //创建实例，新建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建sheet页
        workbook.createSheet("第一个sheet");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\创建sheel页.xls");
        ((HSSFWorkbook) workbook).write(fileOutputStream);
        fileOutputStream.close();
    }
}
