package com.testng.P16.HYR.DataProviderTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;



public class DataSupplier {


	// Allowed return types of Data Provider are
	/*
	 * Object[] > String[],Integer[],Long[]..., Object[][] >
	 * String[][],Integer[][],Long[][].., Iterator<Object> , Iterator<Object[]>
	 */


	@DataProvider(name = "dataProvider1")
	public String[] dataProvider1() {

		String[] data1 = new String[] { "Apple", "Orange", "Mango", "Banana" };
		return data1;
	}
	
	@DataProvider(name = "dataProvider2")
	public Integer[] dataProvider2() {

		Integer[] data2 = new Integer[] { 1,2,3, };
		return data2;
	}
	
	@DataProvider(name = "dataProvider3")
	public Object[] dataProvider3() {

		Object[] data3 = new Object[] { 1,2,3,"number 1","number 2" };
		return data3;
	}	
	
	@DataProvider(name = "dataProvider4")
	public Object[][] dataProvider4() {

		Object[][] data4 = new Object[][]{ { "123","Apple" },{"456","Mango"},{"789","Orange"}};
		
		return data4;
	}
	
	@DataProvider(name = "dataProvider5")
	public Iterator<String> dataProvider5() {

		List<String> data5 = new ArrayList<String>();
		data5.add("Mobile");
		data5.add("System");
		data5.add("TV");
		return data5.iterator();
	}
	
	@DataProvider(name = "dataProvider6")
	public Iterator<String> dataProvider6() {

		Set<String> data6 = new HashSet<String>();
		data6.add("Sun");
		data6.add("Moon");
		data6.add("Earth");
		data6.add("Earth");
		return data6.iterator();
	}
	
	@DataProvider(name = "dataProvider7")
	public Iterator<String[]> dataProvider7() {

		Set<String[]> data7 = new HashSet<String[]>();
		data7.add(new String[] {"abc","def","xyz"});
		data7.add(new String[] {"123","456","789"});
		
		return data7.iterator();
	}
	
	@DataProvider(name = "dataProvider8")
	public Iterator<Object[]> dataProvider8() {

		Set<Object[]> data7 = new HashSet<Object[]>();
		data7.add(new String[] {"abc","def","xyz","xyz"});
		data7.add(new Integer[] {123,456,789,789});		
		return data7.iterator();
	}

	
	//indices
	
	@DataProvider(name = "dataProvider9",indices = {0,2})
	public String [] dataProvider9() {
		String[] data9 = new String[] { "Rose", "lilly", "jasmin", "datura" };				
		return data9;
	}
	
	@DataProvider(name = "dataProvider10" ,parallel = true)
	public String[] dataProvider10() {
		
		String[] data1 = new String[] { "Apple", "Orange", "Mango", "Banana" };
		return data1;

	}
	
	
}
