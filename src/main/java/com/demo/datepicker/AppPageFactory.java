package com.demo.datepicker;

import org.openqa.selenium.WebElement;

public abstract class AppPageFactory {

	abstract public boolean isPageLoaded();
	
	
	public boolean isElementPresent(WebElement element){
		 try{
			 return element.isDisplayed();
		 }catch(Exception e){
			 return false;
		 }
	}
}
