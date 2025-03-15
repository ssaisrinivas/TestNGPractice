package com.testng.P26.HYR.ScreenShotsTest;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testng.base.BaseClass;

public class ITestListenerClass extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

	try {
	    captureScreenShort(result.getName());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

    @Override
    public void onTestSuccess(ITestResult result) {

	try {
	    captureScreenShort(result.getName());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
