package com.testng.P25.HYR.ListenersTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ListenersTest.class})
public class TestClass1 {

	@Test
	public void testMethod1() {
		System.out.println("TestClass1 >> testMethod1 >> I am In side TestMethod 1" );
	}
	
	@Test
	public void testMethod2() {
		System.out.println("TestClass1 >> testMethod2 >>  I am In side TestMethod 2" );
		Assert.assertTrue(false);
	}
	
	@Test(timeOut=1000)
	public void testMethod3() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("TestClass1 >> testMethod3 >> I am In side TestMethod 3" );
	}
	
	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {
		System.out.println("TestClass1 >> testMethod4 >>  I am In side TestMethod 4");
	}
}
