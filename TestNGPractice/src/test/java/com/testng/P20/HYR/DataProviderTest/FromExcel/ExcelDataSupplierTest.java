package com.testng.P20.HYR.DataProviderTest.FromExcel;

import org.testng.annotations.Test;

public class ExcelDataSupplierTest {

    @Test(dataProvider = "getExcelData", dataProviderClass = ExcelDataSupplier.class)
    public void getExcelDataTest(String[] s) throws InterruptedException {

	for (int i = 0; i < s.length; i++) {
	    System.out.println(s[i]);
	}
    }
}
