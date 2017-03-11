package com.demo.pageobjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.demo.util.MyConstants;

public class PracticeForm {

	/**
	 * Yogesh
	 */
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/h1")
	WebElement practiceFormHeading;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/legend/strong")
	WebElement personalInfoLabel;
	
	@FindBy(partialLinkText="Partial Link Test")
	WebElement partialLinkText;
	
	@FindBy(linkText="Link Test")
	WebElement linkText;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[1]/strong[1]")
	WebElement firstNameLbl;
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[1]/input[1]")
	WebElement firstNameInput;

	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[1]/strong[2]")
	WebElement lastNameLbl;
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[1]/input[2]")
	WebElement lastNameInput;
	
	@FindBy(id="content")
	WebElement practiceFormInfo;

	@FindBy(name="sex")
	List<WebElement> gender;
	
	@FindBy(name="exp")
	List<WebElement> yearsOfExpRadioBtns;
	
	@FindBy(name="profession")
	List<WebElement> profession;
	
	
	@FindBy(id="datepicker")
	WebElement date;
	
	
	
	/**
	 * Sangeeta
	 */
	
	@FindBy(xpath="html/body/div[1]/div[5]/div[2]/div/div/form/fieldset/div[12]/p/strong/label")
	WebElement continentsLabel;
	
	@FindBy(id="continents")
	WebElement continentsComboBox;
	
	@FindBy(xpath="html/body/div[1]/div[5]/div[2]/div/div/form/fieldset/div[13]/p/strong/label")
	WebElement seleniumCmdLabel;
	
	@FindBy(id="selenium_commands")
	WebElement seleniumCmdComboBox;
	
	@FindBy(id="submit")
	WebElement submitBtn;
	
	@FindBy(className="bcd")
	WebElement text1Span;
	
	@FindBy(id="NextedText")
	WebElement text2Label;

	
	/**
	 * Vasudha
	 */
	
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[5]/strong/label")
	WebElement ProfilePictureAttach;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[5]/input")
	WebElement BrowseProfilePicture;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[7]/strong")
	WebElement DowloadFramework;

	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[8]/a")
	WebElement LinkHybridFramework;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[9]/a")
	WebElement LinkDownloadTestFile;
	
	@FindBy(xpath="/html/body/div/div[5]/div[2]/div/div/form/fieldset/div[11]/strong/label")
	WebElement LabelAutomationTool;
	
	@FindBy(name="tool")
	List<WebElement> Tools; 

	private void enterDetails(String fname,String lname){
		firstNameInput.clear();
		firstNameInput.sendKeys(fname);
		
		lastNameInput.clear();
		lastNameInput.sendKeys(lname);
		
	}
	
	private void selectGender(String gendertype){
		
		int count=0;
		for (WebElement item : gender) {
		if(gendertype.equals(MyConstants.MALE)){
			item.click();
			break;
		}
		if(gendertype.equals(MyConstants.FEMALE) && count==1){
			item.click();
			break;
		}
		count++;
			
		}
	}
	
	
	public void fillPracticeForm(String fname,String lname,String gender){
		this.enterDetails(fname,lname);
		this.selectGender(gender);		
	}
	
	
	//sangeetha
	private void selectExp(String exp)
	{
		
		for(WebElement item:yearsOfExpRadioBtns)
		{
			if((item.getAttribute("value").toString()).equals(exp))
			{
				item.click();
				break;
			}
		}
	}
	
	
	private void SelectProfession(String Prof)
	{
		if(Prof.toLowerCase().equals("manual"))
		{
			profession.get(0).click();
		}
		else if(Prof.toLowerCase().equals("auto"))
		{
			profession.get(1).click();
		}
	}
	
	public void SelectAutoTool(String toolName)
	{
		for(WebElement item :Tools)
		{
			if((item.getAttribute("value").toString()).equals(toolName))
			{
				item.click();
				break;
			}
		}	
	}				
	
	public void SelectContinent(String contName)
	{
		Select option=new Select(continentsComboBox);
		option.selectByVisibleText(contName);
	}
	
	public void SelectSelComd(String command)
	{
		Select option=new Select(seleniumCmdComboBox);
		option.selectByVisibleText(command);
	}
	
	public void FillDetails(String exp,String dateinput,String prof, String toolNm, String cont, String comm)
	{
		selectExp(exp);
		date.sendKeys(dateinput);
		SelectProfession(prof);
		SelectAutoTool(toolNm);
		SelectContinent(cont);
		SelectSelComd(comm);
	}
	
	}

