package com.qa.rediff.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;



public class TestUtility {
	@DataProvider(name="dp")
	public Object[][] getData(Method m)
	{
		String sheetName=m.getName();
		Object[][] data=ExcelUtility.getTestData(sheetName);
		
		
		return data;
			
				
	}
	

}
