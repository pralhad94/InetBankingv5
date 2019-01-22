package com.inetbanking.TestCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass

{
	
	@Test
	public void loginTest () throws IOException
	{
		driver.get(baseURL);
		logger.info("url opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username entered");
		lp.setPasssword(password);
		logger.info("password entered");
		lp.clicksubmit();
		logger.info("clicked on sumbit");
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else 
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}
	
	
	
}
