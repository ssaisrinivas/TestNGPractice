package com.testng.P4.HYR.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.testng.base.BaseClass;

public class OrangeHRM extends BaseClass {

    @Test(priority = 1)

    public void loginToOrangeHRMApplication() throws InterruptedException {

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	Thread.sleep(3000);
	driver.findElement(By.tagName("h6")).isDisplayed();
	System.out.println(driver.findElement(By.tagName("h6")).getText());
    }

    @Test(priority = 2)

    public void navigateToMyInfo() throws InterruptedException {

	driver.findElement(By.cssSelector(
		"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > aside:nth-child(1) > nav:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(6) > a:nth-child(1) > span:nth-child(2)"))
		.click();
	Thread.sleep(3000);

    }

    @Test(priority = 3)

    public void varifyMyInfo() throws InterruptedException {
	System.out.println(driver.findElement(By.cssSelector(".employee-image")).isDisplayed());
	Thread.sleep(3000);
    }

    @Test(priority = 4)

    public void varifyLogin() throws InterruptedException {
	WebElement element = driver.findElement(By.cssSelector(
		"body > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
	element.isDisplayed();
	System.out.println(element.getText());
	Thread.sleep(3000);
    }

}
