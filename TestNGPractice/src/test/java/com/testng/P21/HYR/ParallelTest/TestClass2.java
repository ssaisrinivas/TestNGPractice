package com.testng.P21.HYR.ParallelTest;

import org.testng.annotations.Test;

public class TestClass2 {

	@Test
	public void testMethod1() {
		System.out.println("TestClass2 >> testMethod1 >>  "+ Thread.currentThread().getName());
	}
	
	@Test
	public void testMethod2() {
		System.out.println("TestClass2 >> testMethod2 >>  "+ Thread.currentThread().getName());
	}
	
	@Test
	public void testMethod3() {
		System.out.println("TestClass2 >> testMethod3 >>  "+ Thread.currentThread().getName());
	}
	
	@Test
	public void testMethod4() {
		System.out.println("TestClass2 >> testMethod4 >>  "+ Thread.currentThread().getName());
	}
}
