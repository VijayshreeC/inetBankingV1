package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test(groups= {"sanity","regression"})
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		Thread.sleep(2000);
		lp.clickSubmit();
		logger.info("Clicked on submit Button");
		Thread.sleep(3000);

		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login is successful");
		} else {
			logger.info("Login is not successful");
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);

		}
	}

}
