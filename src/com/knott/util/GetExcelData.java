package com.knott.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	//设定要操作Excel的文件路径和Excel文件中的Sheet名称
	//在读/写Excel的时候，均需要先调用此方法，设定要操作的Excel文件路径和要操作的Sheet名称
	public static void setExcelFile(String Path,String SheetName){
		FileInputStream ExcelFile;
		try {
			//实例化Excel文件的FileInputStream对象
			ExcelFile = new FileInputStream(Path);
			//实例化Excel文件的XSSFWorkbook对象
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*实例化XSSFSheet对象，指定Excel文件中的Sheet名称，
			 * 后续用于Sheet中行、列和单元格的操作
			 */
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//读取Excel文件指定单元格的函数
	public static String getCellData(int RowNum,int ColNum){
		//通过函数参数指定单元格的行号和列号，获取指定的单元格对象
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getCellType()==XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue()+""
				:String.valueOf(Math.round(Cell.getNumericCellValue()));
		return CellData;
		
	}
}
