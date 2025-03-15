package com.testng.P21.HYR.ParallelTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testng.P16.HYR.DataProviderTest.DataSupplier;

public class ParllelTestExecution {
	
	@Test(dataProvider = "dataProvider10", dataProviderClass = DataSupplier.class)	
	public void dataProviderTest10(String  string) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle = "HYR Tutorial - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		Thread.sleep(3000);
		System.out.println(string);	
		driver.quit();
	}
	
	    @Test(timeOut=5000)
	    //@Parameters(value="browserName") //String  string
		public void dataProviderTest11() throws InterruptedException {
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
			System.out.println(driver.getTitle());
			String expectedTitle = "HYR Tutorial - Google Search";
			String actualTitle = driver.getTitle();
			assertEquals(actualTitle, expectedTitle);
			//Thread.sleep(3000);
			//System.out.println(string);	
			driver.quit();
		}

}
