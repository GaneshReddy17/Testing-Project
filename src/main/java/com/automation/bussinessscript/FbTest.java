package com.automation.bussinessscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.utilites.PojoUility;
import com.relevantcodes.extentreports.LogStatus;

public class FbTest extends BaseTest {
	@Test
	public void fblogin() throws InterruptedException, IOException {
		System.out.println(Thread.currentThread().getId());
		getExtenttest().log(LogStatus.PASS, "browser opened");
		String url = PojoUility.getconfig().getStringvalue("fb_url");

		getDriver().get(url);
		getExtenttest().log(LogStatus.PASS, "browser navigated gmail url");

		String uname = PojoUility.getor().getStringvalue("fb_uname_id");

		WebElement fb_un = getDriver().findElement(By.id(uname));
		fb_un.clear();
		String undata = PojoUility.getconfig().getStringvalue("fb_uname_value");

		fb_un.sendKeys(undata);
		getExtenttest().log(LogStatus.PASS, "username entered");

		String pwd_id = PojoUility.getor().getStringvalue("fb_pwd_id");

		WebElement fb_pass = getDriver().findElement(By.id(pwd_id));
		fb_pass.clear();
		String pwddata = PojoUility.getconfig().getStringvalue("fb_pwd_value");
		getExtenttest().log(LogStatus.PASS, "password entered");

		fb_pass.sendKeys(pwddata);
		String login_id = PojoUility.getor().getStringvalue("fb_login_name");

		WebElement fb_login = getDriver().findElement(By.name(login_id));
		fb_login.click();
		getExtenttest().log(LogStatus.PASS, "gmail login");

		Thread.sleep(3000);
	}
	@Test
	public void second() {
		getDriver().get("https://www.rameshsoft.com");

		System.out.println("Second Test");
		System.out.println(Thread.currentThread().getId());
	}

}
