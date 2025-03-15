package com.testng.P8.HYR.ParametersTesting;

import org.openqa.selenium.By;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testng.base.BaseClass;

public class ParametersTesting extends BaseClass {

    @Test
    @Parameters({ "browserName", "url" })
    public void googleTest(@Optional("firefox") String browser, String url) throws InterruptedException

    {
	driver = browserInitialization(browser);
	driver.get(url);
	System.out.println("Browse is  :" + browser);
	System.out.println("URL is  :" + url);

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.name("username")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();

	Thread.sleep(3000);
	driver.findElement(By.tagName("h6")).isDisplayed();
	System.out.println(driver.findElement(By.tagName("h6")).getText());
    }

}
