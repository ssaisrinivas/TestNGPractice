package com.testng.P26.HYR.ScreenShotsTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.testng.base.BaseClass;

@Listeners(ITestListenerClass.class)
public class ScreenShotsTest extends BaseClass {

    @Test(priority = 0, testName = "googletest")
    public void googleTest() throws InterruptedException, IOException

    {

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	driver.findElement(By.tagName("h6")).isDisplayed();
	System.out.println(driver.findElement(By.tagName("h6")).getText());

    }

    @Test(priority = 1, testName = "facebooketest")
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
	softAssert.assertEquals(actualText, expectedText, "User name text is mismathced");

	// Error Message

	String expectedError = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
	String actualError = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
	softAssert.assertEquals(actualError, expectedError, "Username error message is mismathced");
	softAssert.assertAll();
    }

    @Test(testName = "orangeLoginTest")
    public void loginToOrangeHRMApplication() throws InterruptedException {

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin12");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	driver.findElement(By.tagName("h6")).isDisplayed();
	System.out.println(driver.findElement(By.tagName("h6")).getText());

	Thread.sleep(3000);
    }

}
