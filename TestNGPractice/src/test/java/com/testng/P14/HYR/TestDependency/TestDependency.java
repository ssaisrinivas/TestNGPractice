package com.testng.P14.HYR.TestDependency;

import org.testng.annotations.Test;

public class TestDependency {
	static String trackingNumber = null;

	//@Ignore
	@Test(priority = 0)
	public void createShipment() {
		int a = 10 / 0;
		System.out.println("Shipment Created  ");
		trackingNumber = "ABC123";
	}

	@Test(priority = 1,dependsOnMethods = {"createShipment"},alwaysRun = true)
	public void trackShipment() throws Exception {
		//int a = 10 / 0;
		if (trackingNumber != null) {
			System.out.println("Shipment Tracked  " + trackingNumber);
		} else {
			throw new Exception("invalid tracking number");
		}

	}

	@Test(priority = 3,dependsOnMethods = {"createShipment","trackShipment"},ignoreMissingDependencies = true)
	public void cancleShipment() throws Exception {

		if (trackingNumber != null) {
			System.out.println("Shipment Cancled");
		} else
			throw new Exception("invalid tracking number  " + trackingNumber);
	}

}
