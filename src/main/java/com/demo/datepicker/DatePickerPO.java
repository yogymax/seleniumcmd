package com.demo.datepicker;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePickerPO {

	
	public static void main(String[] args) {
		
			StringSelection stringSelection = new StringSelection("abcdssedads");
			Toolkit.getDefaultToolkit().getSystemClipboard()
			        .setContents(stringSelection, null);	

		System.out.println("");
		//WebDriver driver = new FirefoxDriver();
		//automatateDatePicker("11-02-2016",driver);
	}

	private static void automatateDatePicker(String date,WebDriver driver) {
		
		driver.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");
		driver.manage().window().maximize();
		
		WebElement datePickerItem = driver.findElement(By.id("datetimepicker"));
		WebElement selectDateIcon = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/span/span/span/span[1]/span"));
		
		System.out.println(datePickerItem.getText());
		System.out.println(selectDateIcon.getText());
		
		selectDateIcon.click();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement incrementDate = driver.findElement(By.className("k-nav-prev"));
		WebElement decrementDate = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/a[1]/span"));
		WebElement actualMonthNYear = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/a[1]/span "));
		System.out.println(incrementDate.getText());
		System.out.println(decrementDate.getText());
		
		System.out.println(actualMonthNYear.getText());
		
		String [] dateArray = date.split("-");
		String expectedDate = dateArray[0];
		String month=null;
		try {
			 month = getMonth(Integer.parseInt(dateArray[1]));
		} catch (Exception e){
			e.printStackTrace();
		}
		
		for(int i=0;i<12;i++){
			if(actualMonthNYear.getText().contains(month))
				break;
			else{
				selectDateIcon.click();	
				incrementDate.click();
			}
		}

		WebElement temp =null;
		List<WebElement> items = driver.findElements(By.className("k-link"));
		for (WebElement item : items) {
			if(item.getText().equals(expectedDate))
				temp=item;
		}
		temp.click();
		
		
		
		///html/body/div[5]/div/div/div[1]/a[3]/span  //incrementmonth
		///html/body/div[5]/div/div/div[1]/a[1]/span  //decrementmonth
		
		///html/body/div[5]/div/div/div[1]/a[1]/span  - actualMonthYear
		
		
		
	}

	private static String getMonth(int num) throws InvaliDateException {
		if(num>12 && num<0)
			throw new InvaliDateException("Please enter valid date");
		
		String[] str = {"January",      
				   "February",
				   "March",        
				   "April",        
				   "May",          
				   "June",         
				   "July",         
				   "August",       
				   "September",    
				   "October",      
				   "November",     
				   "December"};
		
		return str[num-1];
	}
	
	
}
