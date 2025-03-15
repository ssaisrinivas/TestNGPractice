package com.testng.P16.HYR.DataProviderTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.testng.base.BaseClass;

public class DataProviderTest extends BaseClass{
	@Test(dataProvider = "loginTestData")
	public void loginToOrangeHRMApplication(String userName,String password) throws InterruptedException {

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(3000);
		driver.findElement(By.tagName("h6")).isDisplayed();
		System.out.println(driver.findElement(By.tagName("h6")).getText());
		String actual = driver.findElement(By.tagName("h6")).getText();
		String expected="Dashboard";
		assertEquals(actual,expected);
		Thread.sleep(3000);
	}
	
	@DataProvider(name="loginTestData")
	public Object[][] loginData1() {
		
		Object[][] data = new Object[2][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "Admin";
		data[1][1] = "asds";
		return data;
	}
	
	/*
	 * @DataProvider public void loginData2() {}
	 * 
	 * @DataProvider public void loginData3() {}
	 * 
	 * @DataProvider public void loginData4() {}
	 */


}
