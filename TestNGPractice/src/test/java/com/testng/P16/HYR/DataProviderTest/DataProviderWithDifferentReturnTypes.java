package com.testng.P16.HYR.DataProviderTest;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.testng.P20.HYR.DataProviderTest.FromExcel.ExcelDataSupplier;
import com.testng.base.BaseClass;

public class DataProviderWithDifferentReturnTypes extends BaseClass {
	@Test(dataProvider = "dataProvider1", dataProviderClass = DataSupplier.class)
	public void dataProviderTest1(String fruits) throws InterruptedException {
		
		System.out.println(fruits);					
	}
	
	@Test(dataProvider = "dataProvider2", dataProviderClass = DataSupplier.class)
	public void dataProviderTest2(Integer intVal) throws InterruptedException {
		
		System.out.println(intVal);					
	}
	
	

	@Test(dataProvider = "dataProvider3", dataProviderClass = DataSupplier.class)
	public void dataProviderTest3(Object values) throws InterruptedException {
		
		System.out.println(values);					
	}
	
	@Test(dataProvider = "dataProvider4", dataProviderClass = DataSupplier.class)
	public void dataProviderTest4(Object[] values) throws InterruptedException {
		
		System.out.println(values[0] +" == >"+ values[1]);					
	}
	
	@Test(dataProvider = "dataProvider4", dataProviderClass = DataSupplier.class)
	public void dataProviderTest5(String username, String password) throws InterruptedException {
		
		System.out.println(username+ " == > " + password);					
	}

	@Test(dataProvider = "dataProvider5", dataProviderClass = DataSupplier.class)
	public void dataProviderTest6(String str) throws InterruptedException {
		
		System.out.println(str);					
	}
	
	@Test(dataProvider = "dataProvider6", dataProviderClass = DataSupplier.class)
	public void dataProviderTest7(String str) throws InterruptedException {
		
		System.out.println(str);					
	}
	
	@Test(dataProvider = "dataProvider7", dataProviderClass = DataSupplier.class)
	public void dataProviderTest8(String[] str) throws InterruptedException {
		
		for (String string : str) {
			System.out.println(string);
		}
							
	}
	

	@Test(dataProvider = "dataProvider8", dataProviderClass = DataSupplier.class)
	public void dataProviderTest9(Object[] obj) throws InterruptedException {
		for (Object ob : obj) {	
		
			System.out.println(ob);
		}
		

		
							
	}
	
	@Test(dataProvider = "dataProvider9", dataProviderClass = DataSupplier.class)
	public void dataProviderTest10(String  string) throws InterruptedException {
		
		System.out.println(string);							
	}
	// Reading  the Excel sheet data 
	
	
	@Test(dataProvider = "getExcelData", dataProviderClass = ExcelDataSupplier.class)
	public void dataProviderTest11(String[]  string) throws InterruptedException {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(6000);
		driver.findElement(By.name("username")).sendKeys(string[0]);
		driver.findElement(By.name("password")).sendKeys(string[1]);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);
		driver.findElement(By.tagName("h6")).isDisplayed();
		System.out.println(driver.findElement(By.tagName("h6")).getText());
		String actual = driver.findElement(By.tagName("h6")).getText();
		String expected="Dashboard";
		assertEquals(actual,expected,"UserName or Password is correct");
		//driver.quit();
	}	

}
