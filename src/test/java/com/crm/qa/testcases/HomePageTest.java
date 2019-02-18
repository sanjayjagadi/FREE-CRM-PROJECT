package com.crm.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage tasksPage;
	
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		initialization();
		 loginpage = new LoginPage();
		 TestUtil.shortWait();
		 TestUtil.removeModelPopup();
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		// test = extent.createTest("verifyHomePageTitleTest");
		String homePageTitle = driver.getTitle();
		Assert.assertEquals(homePageTitle, "CRMPR","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest(){
		// test = extent.createTest("verifyUsernameTest");
		TestUtil.switchToFrame();
		
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifContactsLinkTest(){
		// test = extent.createTest("verifContactsLinkTest");
		TestUtil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	}
	@Test(priority=4)
	public void verfiyDealsLinkTest(){
		//test = extent.createTest("verfiyDealsLinkTest");
		TestUtil.switchToFrame();
	 dealspage = homepage.clickOnDealsPage();
	 
	}
	
	

	@Test(priority=5)
	public void verfiyTasksLinkTest(){
		// test = extent.createTest("verfiyTasksLinkTest");
		TestUtil.switchToFrame();
		 tasksPage = homepage.clickOnTasksPage();
	}
	
	

	
	@AfterMethod

	public void tearDown(){
		  driver.quit();
		 }

}
