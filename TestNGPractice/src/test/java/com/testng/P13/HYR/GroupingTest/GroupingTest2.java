package com.testng.P13.HYR.GroupingTest;

import org.testng.annotations.Test;

import com.testng.base.BaseClass;
//@Ignore
public class GroupingTest2 extends BaseClass {
	@Test(groups={"sanity"})
	public void testMethod1() {

		System.out.println("testMethod1 > GroupingTest2 > sanity");
	}

	@Test(groups={"smoke"})
	public void testMethod2() {

		System.out.println("testMethod2 > GroupingTest2 > smoke");
	}

	@Test(groups={"functional"})
	public void testMethod3() {

		System.out.println("testMethod3 > GroupingTest2 > functional");
	}

}
