package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	ContactsPage contactspage;
	LoginPage loginpage;
	HomePage homepage;
	
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		contactspage = new ContactsPage();
		loginpage= new LoginPage();
		homepage = new HomePage();
		 TestUtil.shortWait();
		 TestUtil.removeModelPopup();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		TestUtil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
		
	}
	@Test
	public void verifyCOntactsPageLabel(){
		Assert.assertTrue(contactspage.verfiyContactsLabel(),"contacts label is missing on the page");
	}
	

	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
