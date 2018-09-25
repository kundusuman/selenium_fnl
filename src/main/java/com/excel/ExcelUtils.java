package com.excel;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Suman Kundu
 * @Date 22/8/2018
 * @throws IOException
 *             FileNotFoundException
 *
 */
public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static String file2;

	public ExcelUtils(String file1) {
		this.file2 = file1;
		File file = new File(file2);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ExcelWBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Object[][] getSheetAsArray(String SheetName) {

		String[][] tabArray = null;

		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int startRow = 0;
		int startCol = 0;
		int ci, cj;
		int totalRows = ExcelWSheet.getLastRowNum() + 1;
		int totalCols = ExcelWSheet.getRow(1).getLastCellNum();
		tabArray = new String[totalRows][totalCols];
		ci = 0;
		for (int i = startRow; i < totalRows; i++, ci++) {
			cj = 0;
			for (int j = startCol; j < totalCols; j++, cj++) {
				tabArray[ci][cj] = getCellData(i, j);
			}

		}
		return (tabArray);
	}

	private String getCellData(int RowNum, int ColNum) {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if (dataType == 3) {
				return "";
			} else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}

	}// end of get cell data function

	public String getCellData(int RowNum, int ColNum, String sheet) {
		try {
			ExcelWSheet = ExcelWBook.getSheet(sheet);
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			int dataType = Cell.getCellType();
			if (dataType == 3) {
				return "";
			} else {
				String CellData = Cell.getStringCellValue();
				return CellData;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}

	}// end of get cell data function



}