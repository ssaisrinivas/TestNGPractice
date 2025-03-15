package com.testng.base;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

    @AfterMethod
    public void afterMethodTest() {
	driver.quit();
    }

}
