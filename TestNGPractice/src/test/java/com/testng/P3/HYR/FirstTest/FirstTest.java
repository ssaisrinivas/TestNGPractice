package com.testng.P3.HYR.FirstTest;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testng.base.BaseClass;

public class FirstTest extends BaseClass {

	@Test
	public void googleTest() throws InterruptedException

	{
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle = "HYR Tutorial - Google Search";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		Thread.sleep(3000);
	}

	@Test
	public void facebookTest() throws InterruptedException

	{
		SoftAssert softAssert = new SoftAssert();
		driver.get("https://www.facebook.com/");
		// Title Assertion
		driver.findElement(By.name("email")).sendKeys("HYR Tutorial", Keys.ENTER);
		System.out.println(driver.getTitle());
		String expectedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		softAssert.assertEquals(actualTitle, expectedTitle, "Title is mismathced");
		Thread.sleep(3000);

		// URL Assertion

		System.out.println(driver.getCurrentUrl());
		String expectedUrl = "https://www.facebook.com/";
		Thread.sleep(3000);
		String actualUrl = driver.getCurrentUrl();
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismathced");
		Thread.sleep(3000);

		// Text Assertion

		driver.findElement(By.name("email")).getAttribute("value");
		System.out.println(driver.getTitle());
		String expectedText = "Log in to Facebook1";
		String actualText = driver.getTitle();
		softAssert.assertEquals(actualText, expectedText, "User nametext is mismathced");
		Thread.sleep(3000);

		// Error Message 
				
		String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		String actualError = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
		softAssert.assertEquals(actualError, expectedError, "Username error message is mismathced");
		
		softAssert.assertAll();
	}
}
