package com.automation.utilites;

import java.io.IOException;


import com.automation.base.BaseTest;
import com.automation.supporters.ExcelReader;
import com.automation.supporters.PropertyReader;

public class PojoUility extends BaseTest {
	static String configfilepath=getCurDir()+"\\config.properties";
	static String orfilepath=getCurDir()+"\\src\\main\\java\\com\\automation\\properties\\or.properties";
	static String excelfilepath=getCurDir()+"\\src\\main\\java\\com\\automation\\testdata\\testdata1.xlsx";

	public static PropertyReader getconfig() throws IOException {
		PropertyReader procon=new PropertyReader(configfilepath);
		return procon;
	}public static PropertyReader getor() throws IOException {
		PropertyReader proOr=new PropertyReader(orfilepath);
		return proOr;
	}
	public static ExcelReader getexcelreader() throws IOException {
		
		ExcelReader excelreader=new ExcelReader(excelfilepath);
		return excelreader;

	}

}
