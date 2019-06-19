package com.java.poi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @program: IdeaProjects
 * @description:
 * @author: Lxy
 * @create: 2019-06-18 22:23
 **/
public class Test5 {
    public static void main(String[] args) throws Exception {
        //建立输入流
        InputStream is = new FileInputStream("D:\\3.xls");
        //接受一个输入流
        POIFSFileSystem fs = new POIFSFileSystem(is);
        //创建了一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        //获取第一个sheet页
        HSSFSheet hssfSheet = wb.getSheetAt(0);
        //判断Sheet是否为空
        if (hssfSheet == null) {
            return;
        }
        //遍历行row
        //continue只是终止本次循环，接着还执行后面的循环
        for (int rownum = 0; rownum <= hssfSheet.getLastRowNum(); rownum++) {
            //获取到每一行
            HSSFRow sheetRow = hssfSheet.getRow(rownum);
            if (sheetRow == null) {
                continue;
            }
            //遍历列cell
            for (int cellnum = 0; cellnum <= sheetRow.getLastCellNum(); cellnum++) {
                HSSFCell cell = sheetRow.getCell(cellnum);
                if (cell == null) {
                    continue;
                }
                //获取单元格的值
                System.out.print(" " + getValue(cell));
            }
            System.out.println();

        }


    }

    /**
     * 静态方法获取值
     *
     * @param hssfCell
     * @return
     */
    private static String getValue(HSSFCell hssfCell) {
        //hssfCell.getCellType() 获取当前列的类型
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}
