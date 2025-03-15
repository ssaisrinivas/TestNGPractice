package com.testng.P15.HYR.GroupDependencyTest;

import org.testng.annotations.Test;

public class GroupDependencyTest {

	@Test(groups = { "smoke" })
	public void testMethod1() {

		System.out.println("testMethod1 > GroupDependencyTest > smoke");
	}

	@Test(groups = { "sanity" })
	public void testMethod2() {

		System.out.println("testMethod2 > GroupDependencyTest > sanity");
	}

	@Test(groups = { "regression","smoke" })
	public void testMethod3() {

		System.out.println("testMethod3 > GroupDependencyTest > regression");
	}

	@Test(groups = { "smoke","sanity" })
	public void testMethod4() {

		System.out.println("testMethod4 > GroupDependencyTest > smoke ");
	}
	// for methods dependsOnMethods = {"createShipment"}
	// for groups dependsOnGroups = {"createShipment"}

	//@Test(dependsOnGroups = { "sanity" }, alwaysRun = true)
	public void testMethod0() {

		System.out.println("testMethod5 > GroupDependencyTest > Main Test");
	}

}
