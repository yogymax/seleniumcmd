package com.demo.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.demo.pageobjects.PracticeForm;
import com.demo.util.MyConstants.MyBrowsers;
/**
 * @author Progvaltion_11
 */
public class InitializeDrivers {

/**	
 * 
 * @param typeofBrowser
 * @return
 */
	private static WebDriver initializeDrivers(MyBrowsers typeofBrowser){
		WebDriver driver =null;
		switch (typeofBrowser) {
		case Firefox:
			driver = new FirefoxDriver();
			break;
		case Chrome:
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Progvaltion_11\\Desktop\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case InternetExplorer:
			driver= new InternetExplorerDriver();
			break;
		case Safari:
			driver = new SafariDriver();
			break;
		default:
			Assert.fail("Expected browser is not available");
			break;
		}
		return driver;
	}

	
	public static PracticeForm enterAppURL(MyBrowsers browser) {
		WebDriver driver = initializeDrivers(browser);
		driver.get(MyConstants.APPLICATION_URL);
		return PageFactory.initElements(driver, PracticeForm.class);
		
	}
}
