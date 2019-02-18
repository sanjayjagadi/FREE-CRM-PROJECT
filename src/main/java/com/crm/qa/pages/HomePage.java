package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement dealsLink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement tasksLink;
	@FindBy(xpath="//td[contains(text(),'User: Naveen AutomationLabs')]")
	private WebElement userNameLabel;
	
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsPage(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksPage(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName(){
		TestUtil.shortWait();
	return	userNameLabel.isDisplayed();
	}
	
	

}
