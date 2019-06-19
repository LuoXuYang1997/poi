package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;


import java.io.FileOutputStream;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-18 20:04
 **/
public class Test1 {
    public static void main(String[] args) throws Exception {
        //创建实例，新建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //建立输出流，设置创建的Excel的输出路径：D:\poi你好.xls
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\poi你好.xls");
        ((HSSFWorkbook) workbook).write(fileOutputStream);
        //关闭输出流
        fileOutputStream.close();
    }
}
