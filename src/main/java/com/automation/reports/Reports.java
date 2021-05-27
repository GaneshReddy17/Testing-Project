package com.automation.reports;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reports {

	public static void main(String[] args) {
		ExtentReports extentreports=new ExtentReports("E:\\projects\\Testing\\Reports\\repots.html");
		Map<String,String>map=new HashMap<>();
		map.put("name", "Ganesh");
		map.put("phnum", "8179225826");
		extentreports.addSystemInfo(map);
		ExtentTest extenttest=extentreports.startTest("demo1");
		extenttest.log(LogStatus.PASS, "open browser");
		extenttest.log(LogStatus.PASS, "browser navigated");
		extentreports.endTest(extenttest);
		extentreports.flush();
		extentreports.close();
		

}}
