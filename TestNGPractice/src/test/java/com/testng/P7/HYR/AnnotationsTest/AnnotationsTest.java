package com.testng.P7.HYR.AnnotationsTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsTest {
  @Test
  public void testMethod1() {
	  
	  System.out.println("testMethod1 > @Test");
  }
  
  @Test
  public void testMethod2() {
	  
	  System.out.println("testMethod2 > @Test");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("beforeMethod > @BeforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("afterMethod > @AfterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("beforeClass > @BeforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass > @AfterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("beforeTest > @BeforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest > @AfterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("beforeSuite > @BeforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite > @AfterSuite");
  }

}
