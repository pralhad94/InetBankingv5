package com.inetbanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass {

	@Test (dataProvider="LoginData")
	public void LoginDDT (String user,String pwd) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPasssword(pwd);
		logger.info("password is provided");
		lp.clicksubmit();
		logger.info("clicked on submit");
		Thread.sleep(5111);
		
		
		if (isAlertPresent()==true)  //fail scenario
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("login failed");
			Thread.sleep(1999);
		}
		else // pass scenario
		{
			Assert.assertTrue(true); 
			logger.info("login success");
			lp.clicklogout();
			logger.info("logout success");
			driver.switchTo().alert().accept(); //close alert box of logout button
			driver.switchTo().defaultContent();
			Thread.sleep(3111);
			
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e) 
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/TestData/LoginData.xlsx";
		
		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for (int i=1;i<rownum;i++)
		{
			for (int j=0;j<colcount;j++)
			{
				logindata [i-1][j] = XLUtils.getCellData(path, "sheet1", i, j); // i=1 and j=0
				
			}
		}
		
		return logindata;
		
		
		
		
		
		
		
		
	}
}
