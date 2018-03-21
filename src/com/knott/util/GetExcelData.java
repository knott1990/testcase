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
	//�趨Ҫ����Excel���ļ�·����Excel�ļ��е�Sheet����
	//�ڶ�/дExcel��ʱ�򣬾���Ҫ�ȵ��ô˷������趨Ҫ������Excel�ļ�·����Ҫ������Sheet����
	public static void setExcelFile(String Path,String SheetName){
		FileInputStream ExcelFile;
		try {
			//ʵ����Excel�ļ���FileInputStream����
			ExcelFile = new FileInputStream(Path);
			//ʵ����Excel�ļ���XSSFWorkbook����
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			/*ʵ����XSSFSheet����ָ��Excel�ļ��е�Sheet���ƣ�
			 * ��������Sheet���С��к͵�Ԫ��Ĳ���
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
	
	//��ȡExcel�ļ�ָ����Ԫ��ĺ���
	public static String getCellData(int RowNum,int ColNum){
		//ͨ����������ָ����Ԫ����кź��кţ���ȡָ���ĵ�Ԫ�����
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getCellType()==XSSFCell.CELL_TYPE_STRING?Cell.getStringCellValue()+""
				:String.valueOf(Math.round(Cell.getNumericCellValue()));
		return CellData;
		
	}
}
