package com.scce.utils;

import com.scce.pojo.Room;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.InputStream;
import java.util.List;

public class ExcelUtil {
	/**
	 * 封装Excel的集合
	 * @param list
	 * @param wb
	 * @param headers
	 * @throws Exception
	 */
	public static void fillExcelData(List list, Workbook wb, String[] headers)throws Exception{
		int rowIndex=0;
		Sheet sheet=wb.createSheet();
		Row row=sheet.createRow(rowIndex++);
		for(int i=0;i<headers.length;i++){
			row.createCell(i).setCellValue(headers[i]);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			Room room= (Room) list.get(i);
			row=sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(room.getRoomNumber());
				row.createCell(1).setCellValue((room.getPrice()));
				row.createCell(2).setCellValue(room.getRoomType());
				row.createCell(3).setCellValue(room.getDeposit());
				row.createCell(4).setCellValue(room.getStatusstr());
		}
	}

	/**
	 * 读取模板，将数据一个一个的放在模板中
	 * @param list
	 * @param templateFileName
	 * @return
	 * @throws Exception
	 */
	public static Workbook fillExcelDataWithTemplate(List list, String templateFileName)throws Exception{
		System.out.println("进入fillExcelDataWithTemplate:"+templateFileName);
		//Class.getResourceAsStream(String path) ： path 不以’/'开头时默认是从此类所在的包下取资源
		// ，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源。
		//getResourceAsStream(String path)  com.scce.template
		InputStream inp=ExcelUtil.class.getResourceAsStream("/com/scce/template/"+templateFileName);
		System.out.println(inp);
		//POIFSFileSystem 进行解析Excel
		POIFSFileSystem fs=new POIFSFileSystem(inp);
		Workbook wb=new HSSFWorkbook(fs);
		Sheet sheet=wb.getSheetAt(0);
		int rowIndex=1;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			Room room= (Room) list.get(i);
			Row row=sheet.createRow(rowIndex++);
			row=sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(room.getRoomNumber());
			row.createCell(1).setCellValue((room.getPrice()));
			row.createCell(2).setCellValue(room.getRoomType());
			row.createCell(3).setCellValue(room.getDeposit());
			row.createCell(4).setCellValue(room.getStatusstr());
		}
		return wb;
	}
	/**
	 * @param hssfCell
	 * @return
	 */
	public static String formatCell(HSSFCell hssfCell){
		if(hssfCell==null){
			return "";
		}else{
			if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_BOOLEAN){
				return String.valueOf(hssfCell.getBooleanCellValue());
			}else if(hssfCell.getCellType()==HSSFCell.CELL_TYPE_NUMERIC){
				return String.valueOf(hssfCell.getNumericCellValue());
			}else{
				return String.valueOf(hssfCell.getStringCellValue());
			}
		}
	}

}
