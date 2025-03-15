package com.testng.P20.HYR.DataProviderTest.FromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {

    @DataProvider(name = "getExcelData", parallel = true)
    public static String[][] getExcelData() throws IOException {
	// For Reading the Excel sheet data need to follow this flow

	/*
	 * Read the Excel sheet from Machine => WorkBook = > Sheet = > Row = > Cell
	 */

	File excelFile = new File(
		"D:\\Eclipse-23-24\\TestNGPractice\\src\\test\\resources\\dataproviderwithexcel.xlsx");
	System.out.println(excelFile.exists());
	FileInputStream fis = new FileInputStream(excelFile);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("TestAuthentication");
	int noOfRows = sheet.getPhysicalNumberOfRows();
	System.out.println(noOfRows);
	int noOfColumns = sheet.getRow(0).getLastCellNum();
	System.out.println(noOfColumns);
	String[][] data = new String[noOfRows - 1][noOfColumns];
	for (int i = 0; i < noOfRows - 1; i++) {
	    for (int j = 0; j < noOfColumns; j++) {
		DataFormatter df = new DataFormatter();
		data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
		// System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
	    }
	    System.out.println();
	}
	workbook.close();
	fis.close();

	return data;

    }

    public static void main(String[] args) throws IOException {
	String[][] excelData = getExcelData();

	for (String[] row : excelData) {
	    System.out.println("From Row: " + row.toString());
	    for (String coloumn : row) {

		System.out.println("From Coloumn: " + coloumn);

	    }
	}
    }

}
