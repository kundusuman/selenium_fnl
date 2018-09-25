package com.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils1 {

	private  XSSFSheet ExcelWSheet;

	private  XSSFWorkbook ExcelWBook;

	private  XSSFCell Cell;

	private  XSSFRow Row;
	private  String path2;

	public ExcelUtils1(String Path) {
		this.path2 = Path;
		FileInputStream ExcelFile=null;
		try {
			ExcelFile = new FileInputStream(Path);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// Access the required test data sheet

		try {
			ExcelWBook = new XSSFWorkbook(ExcelFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// This method is to set the File path and to open the Excel file, Pass Excel
	// Path and Sheetname as Arguments to this method

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num

	public  String getCellData(String SheetName, int RowNum, int ColNum) throws Exception {

		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public  void setCellData(String SheetName, String Result, int RowNum) throws Exception {

		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			Row = ExcelWSheet.getRow(RowNum);

			Cell = Row.getCell(Row.getLastCellNum());

			if (Cell == null) {

				Cell = Row.createCell(Row.getLastCellNum());

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(path2);

			ExcelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}
