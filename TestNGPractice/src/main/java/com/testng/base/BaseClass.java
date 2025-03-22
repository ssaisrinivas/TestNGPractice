package com.testng.base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class BaseClass {

    public static WebDriver driver;
    public static String screenShortsSubFolderName;

    @BeforeMethod
    public void beforeMethodTest() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
    }

    @Parameters("browserName")
    // @Parameters({"Admin","paswrd"})
    // @BeforeSuite
    public WebDriver browserInitialization(@Optional("chrome") String browser) throws InterruptedException {

	switch (browser) {

	case "chrome":
	    // WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    return driver;

	case "edge":
	    // WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    return driver;

	case "firefox":
	    // WebDriverManager.firefoxdriver().setup();
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    return driver;

	default:
	    System.err.println("Browser Name is invalid");
	    return null;
	}

    }

    @Parameters("url")
    // @BeforeMethod
    public void launchApp(String url) {
	driver.get(url);
    }

    public void captureScreenShort(String name) throws IOException {

	if (screenShortsSubFolderName == null) {
	    LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
	    String formattedDate = myDateObj.format(myFormatObj);
	    screenShortsSubFolderName = formattedDate;
	}

	File path = new File("D:/Eclipse-23-24/TestNGPractice/Screenshot/" + screenShortsSubFolderName);
	path.mkdir();
	String str = path.getAbsolutePath();
	TakesScreenshot tss = (TakesScreenshot) driver;
	File src = tss.getScreenshotAs(OutputType.FILE);

	File dst = new File(str + "/" + name + "_" + java.time.LocalDate.now().toString() + ".jpeg");

	try {
	    System.out.println(dst.getName());
	    Files.copy(src, dst);
	    System.out.println("ScreenShot Saved successfully");
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    // @AfterMethod
    public void screenShortCapture(ITestResult results) throws IOException {
	if (results.getStatus() == ITestResult.FAILURE) {
	    captureScreenShort(results.getTestContext().getName());
	}
    }

    @Test
    public void Test() throws InterruptedException {
	// Loading Orange HRM Home page
	driver.get("https://sourceforge.net/auth/");
	Thread.sleep(1000);
	String loginpageTitle = driver.getTitle();
	System.out.println(loginpageTitle);
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.xpath("//a[text()='Forgot your username/password?']")).isDisplayed());
	driver.findElement(By.cssSelector("[placeholder=\"Username\"]")).sendKeys("ssaisrinivas22");
	driver.findElement(By.cssSelector("[placeholder=\"Password\"]")).sendKeys("$Ss9704312287");
	driver.findElement(By.cssSelector("[type=\"submit\"][value=\"Login\"]")).click();
	Thread.sleep(1000);
	String accountTitle = driver.getTitle();
	System.out.println(accountTitle);
	Thread.sleep(1000);
	Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Me ▾')]"))).perform();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//ul[@id='account-menu']//a[normalize-space()='Account Settings']")).click();
	Thread.sleep(1000);
	List<WebElement> webelements = driver.findElements(By.cssSelector("fieldset.preferences a"));
	for (WebElement webElement : webelements) {
	    System.out.println(webElement.getAccessibleName());
	}

	Thread.sleep(1000);

	// OAuth Page

	driver.findElement(By.xpath("//*[@id='account_oauth']/a")).click();

	boolean value = driver.getPageSource().contains("Sai Srinivas Git ");

	if (value) {
	    driver.findElement(By.xpath("//input[@value='Delete App']")).click();
	    driver.switchTo().alert().accept();
	}

	else {
	    driver.findElement(By.xpath("//input[@name='application_name'][@tabindex='6']")).sendKeys("Sai Srinivas");
	    Thread.sleep(3000);

	    driver.findElement(By.xpath("//textarea[@name='application_description'][@tabindex='7']"))
		    .sendKeys("These are applications you have authorized to act on your behalf.");

	    driver.findElement(By.xpath("//input[@name='redirect_url_1'][@tabindex='8']"))
		    .sendKeys("https://github.com/ssaisrinivas?tab=repositories");
	    driver.findElement(By.xpath("//input[@name='redirect_url_2'][@tabindex='9']"))
		    .sendKeys("https://github.com/ssaisrinivas?tab=repositories");
	    driver.findElement(By.xpath("//input[@name='redirect_url_3'][@tabindex='10']"))
		    .sendKeys("https://github.com/ssaisrinivas?tab=repositories");
	    Thread.sleep(8000);
	    driver.findElement(By.xpath("//input[@value='Register new Application']")).click();
	    Thread.sleep(5000);
	    String name = driver.findElement(By.cssSelector("div > div.content")).getText();
	    System.out.println(name);

	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//input[@value='Delete App']")).click();
	    driver.switchTo().alert().accept();
	}

	System.out.println();
	System.out.println(value);
	Thread.sleep(8000);
    }

    @AfterMethod
    public void afterMethodTest() {
	driver.quit();
    }

}
