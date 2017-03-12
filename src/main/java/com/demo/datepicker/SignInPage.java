package com.demo.datepicker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.demo.util.InitializeDrivers;

public class SignInPage extends AppPageFactory{

	WebElement userName;
	WebElement password;
	WebElement signIn;
	
	
	
	public AppPageFactory clickSignin(String uname,String pwd,boolean expectedHome){
		enterUserName(uname);
		enterPassword(pwd);
		signIn.click();
		if(expectedHome){
			 return PageFactory.initElements(InitializeDrivers.getWebdriver(), HomePage.class);
		}else{
			return PageFactory.initElements(InitializeDrivers.getWebdriver(), SignInPage.class);
		}
	}



	private void enterPassword(String pwd) {
		this.password.clear();
		this.password.sendKeys(pwd);
	}



	private void enterUserName(String uname) {
		this.userName.clear();
		this.userName.sendKeys(uname);
	}



	@Override
	public boolean isPageLoaded() {
		return isElementPresent(userName) && isElementPresent(signIn);
	}
	
}
