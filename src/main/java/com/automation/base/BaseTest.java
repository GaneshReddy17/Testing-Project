package com.automation.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.utilites.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private static WebDriver driver;
	private static String TcName;
	private static String curDir;
	private static ExtentReports extentreports;
	private static ExtentTest extenttest;
	@Parameters("browser")
	@BeforeSuite
	public void OpenBrowser(@Optional("chrome") String browser) {
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			init();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			init();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			init();
		}
	}

	public void init() {
		curDir=System.getProperty("user.dir");
		System.out.println(curDir);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	@BeforeTest
	public void initireports() {
		extentreports=new ExtentReports(getCurDir()+"\\Reports\\repots.html");
		Map<String,String>map=new HashMap<>();
		map.put("name", "Ganesh");
		map.put("phnum", "8179225826");
		extentreports.addSystemInfo(map);
		
	}
	@AfterTest
	public void generteRepots() {
		if(extentreports!=null) {
			extentreports.close();
		}else {
			System.out.println("null pointer exception");
		}
	}

	@BeforeMethod
	public void beforemethod(Method mehod) {
		 String tcname = mehod.getName();
		System.out.println("current execution testcase name  :" + tcname);
		extenttest= extentreports.startTest(tcname);
		 //extenttest.log(LogStatus.PASS, "current execution test case  :"+tcname);
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		 TcName = result.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("test case success :" + TcName);
			extenttest.log(LogStatus.PASS, " test case passed :"+TcName);

			ScreenShotUtility.TakesScreenShot();
		} else if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("testcase failed  :" + TcName);
			// extenttest.log(LogStatus.PASS, " test case failed :"+TcName);
		String imagepath=ScreenShotUtility.TakesScreenShot(TcName);
			extenttest.addScreenCapture(imagepath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("test case skipped  :" + TcName);
			// extenttest.log(LogStatus.PASS, " test case skipped :"+TcName);
			
		}
		extentreports.endTest(extenttest);
		extentreports.flush();
		

	}

	@AfterSuite
	public void close() {
		if (driver != null) {
			driver.close();

		} else {
			System.out.println("null pointer exception");
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static String getTcName() {
		return TcName;
	}
	
	
	public static String getCurDir() {
		
		return curDir;
	}
	public static ExtentTest getExtenttest() {
		return extenttest;
	}

}
