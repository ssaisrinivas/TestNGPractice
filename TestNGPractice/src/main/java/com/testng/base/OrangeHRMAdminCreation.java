package com.testng.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class OrangeHRMAdminCreation extends BaseClass {

    @Test
    public void Test() throws InterruptedException {

	// Loading Orange HRM Admin page

	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Admin']")).click();
	Thread.sleep(3000);

	driver.findElement(By.cssSelector("[class='oxd-icon bi-plus oxd-button-icon']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//label[text()='Username']/following::div[1]/input")).sendKeys("Sai Srinivas");
	Thread.sleep(3000);

	boolean userExistance = driver.getPageSource().contains("Already exists");
	if (userExistance) {

	    // User Deletion
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("[class='oxd-button oxd-button--medium oxd-button--ghost']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//label[text()='Username']/following::div[1]/input")).sendKeys("Sai Srinivas");
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("[class='oxd-icon bi-trash']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(
		    "[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"))
		    .click();
	    Thread.sleep(3000);

	    System.out.println("Existing Admin User Deleted !!!!");

	    // Create Admin

	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("[class='oxd-icon bi-plus oxd-button-icon']")).click();
	    Thread.sleep(3000);

	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='ESS']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='Enabled']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("s");
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom > div:nth-child(1) > span"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Username']/following::div[1]/input")).sendKeys("Sai Srinivas");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Password']/following::div[1]/input"))
		    .sendKeys("$Ss9704312287");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Confirm Password']/following::div[1]/input"))
		    .sendKeys("$Ss9704312287");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(2000);
	    WebElement success = driver.findElement(By.xpath("//p[text()='Successfully Saved']"));

	    System.out.println("Success Displayed !!!" + success.isDisplayed());
	    System.out.println("New Admin User Created !!!!");

	}

	else {
	    // User Creation

	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(1) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='ESS']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(3) > div > div:nth-child(2) > div > div > div.oxd-select-text--after > i"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//span[text()='Enabled']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("s");
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector(
		    "#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(1) > div > div:nth-child(2) > div > div:nth-child(2) > div > div.oxd-autocomplete-dropdown.--positon-bottom > div:nth-child(1) > span"))
		    .click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Password']/following::div[1]/input"))
		    .sendKeys("$Ss9704312287");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Confirm Password']/following::div[1]/input"))
		    .sendKeys("$Ss9704312287");
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);

	    driver.findElement(By.xpath("//label[text()='Username']/following::div[1]/input")).sendKeys("Sai Srinivas");
	    Thread.sleep(3000);
	    driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	    Thread.sleep(3000);

	    System.out.println("Admin User Created Newly !!!!");

	    // User Deletion
	    /*
	     * if (value) { System.out.println("Sai Srinivas Was present : " + value);
	     * Thread.sleep(3000);
	     * driver.findElement(By.cssSelector("[class='oxd-icon bi-trash']")).click();
	     * Thread.sleep(5000); driver.findElement(By.cssSelector(
	     * "[class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"
	     * )) .click(); Thread.sleep(3000); } else {
	     * System.out.println("Sai Srinivas Was Deleted : " + value); }
	     */
	}

    }

}
