package com.automation.utilites;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.base.BaseTest;

public interface ScreenShotUtility {

	public static void TakesScreenShot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) BaseTest.getDriver();
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(BaseTest.getCurDir()+"\\ScreenShots\\"+BaseTest.getTcName()+".jpeg"));
	}
	public static String TakesScreenShot( String tcname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) BaseTest.getDriver();
		File file=ts.getScreenshotAs(OutputType.FILE);
		String imagepath=BaseTest.getCurDir()+"\\ScreenShots\\"+tcname+".jpeg";
		FileUtils.copyFile(file, new File(imagepath));
		return imagepath;
	}
	

}
