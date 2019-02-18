package com.crm.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
		public static long PAGE_LOAD_TIMEOUT = 30;
		public static long IMPLICIT_WAIT = 20;
		
		public  static void shortWait(){
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		public static  void removeModelPopup(){
			driver.switchTo().frame("intercom-borderless-frame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
			driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();
			
		}
		public static  void switchToFrame(){
			driver.switchTo().frame("mainpanel");
			
		}

	}


