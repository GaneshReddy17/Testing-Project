package com.automation.bussinessscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utilites.PojoUility;
import com.relevantcodes.extentreports.LogStatus;

public class GmailTest extends BaseTest {
	@Test
	public void gmailogin() throws InterruptedException, IOException {
		//getExtenttest().log(LogStatus.PASS, "browser opened");

		String url = PojoUility.getconfig().getStringvalue("gmail_url");
		getDriver().get(url);
		String uname = PojoUility.getor().getStringvalue("gmail_uname_id");
		WebElement user = getDriver().findElement(By.id(uname));
		user.clear();
		String undata = PojoUility.getconfig().getStringvalue("gmail_uname_value");
		user.sendKeys(undata);
		//getExtenttest().log(LogStatus.PASS, "sername enterd");

		String nxt_id = PojoUility.getor().getStringvalue("gmail_nxtbtn_id");

		WebElement nxtbtn = getDriver().findElement(By.id(nxt_id));
		nxtbtn.click();
		//getExtenttest().log(LogStatus.PASS, "nxtbtn login suceessfully");

		Thread.sleep(3000);
	}

}
