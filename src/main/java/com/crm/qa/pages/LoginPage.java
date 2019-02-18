package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//PageFactory or OR
	@FindBy(xpath="//input[contains(@class,'form-control')][1]")
	public WebElement username;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//*[@id='navbar-collapse']//a[text()='Sign Up']")
	public WebElement singUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	public WebElement crmLogo;
	
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public Boolean validateCRMImage(){
		return crmLogo.isDisplayed();
		
	}
	
	public HomePage login(String un,String pw){
		username.sendKeys(un);
		password.sendKeys(pw);
		loginBtn.click();
		return new HomePage();
	}
	
	
	

}
