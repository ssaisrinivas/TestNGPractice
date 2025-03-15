package com.testng.P13.HYR.GroupingTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
//@Ignore
public class GroupingTest3 {
  @Test(groups={"smoke"})
  public void testMethod1() {
	  
	  System.out.println("testMethod1 > GroupingTest3 > smoke");
  }
  
  @Test(groups={"functional"})
  public void testMethod2() {
	  
	  System.out.println("testMethod2 > GroupingTest3 > functional");
  }
  
  @Test(groups={"sanity"})
  public void testMethod3() {
	  
	  System.out.println("testMethod3 > GroupingTest3 > sanity");
  }
  

}
