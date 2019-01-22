package com.inetbanking.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.PageObjects.AddCustomerPage;
import com.inetbanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPasssword(password);
		lp.clicksubmit();
		logger.info("login is completed");
		
		Thread.sleep(3111);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		
        addcust.clickAddNewCustomer();
		
		logger.info("providingcustomer details...");
		addcust.custName("Pralhad");
		addcust.custgender("Male");
		addcust.custdob("11", "15", "1985");
		Thread.sleep(3111);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("411151");
		addcust.custtelephoneno("9896989689");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		System.out.println(email);
		
		addcust.custpassword("dsjksdj");
		addcust.custsubmit();
		
		logger.info("validating adding new customer");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true)
		{
			Assert.assertTrue(true);
		}
		
		else 
		{
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
	}
	
	

}
