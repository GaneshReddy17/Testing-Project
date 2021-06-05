package com.automation.bussinessscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utilites.PojoUility;
import com.relevantcodes.extentreports.LogStatus;

public class FlipKart extends BaseTest {
	@Test
	public void login() throws InterruptedException, IOException {
		getExtenttest().log(LogStatus.PASS, "browser opened");

		String url = PojoUility.getconfig().getStringvalue("flipkart_url");

		getDriver().get(url);
		String uname = PojoUility.getor().getStringvalue("flipkart_un_xpath");

		WebElement un = getDriver().findElement(By.xpath(uname));
		un.clear();
		String un_data = PojoUility.getconfig().getStringvalue("flipkart_u_name");


		un.sendKeys(un_data);
		getExtenttest().log(LogStatus.PASS, "user name entered");

		String pwd_xpath = PojoUility.getor().getStringvalue("flipkart_pwd_xpath");
		WebElement pass = getDriver().findElement(By.xpath(pwd_xpath));
		pass.clear();
		String pwd_data = PojoUility.getconfig().getStringvalue("flipkart_pwd_value");

		pass.sendKeys(pwd_data);
		getExtenttest().log(LogStatus.PASS, "password entered");

		String login_xpath = PojoUility.getor().getStringvalue("flipkart_login_xpath");

		WebElement loginbtn = getDriver().findElement(By.xpath(login_xpath));
		loginbtn.click();
		getExtenttest().log(LogStatus.PASS, "flipkart login");

		Thread.sleep(3000);
		System.out.println("New Code Added");
	}

}
