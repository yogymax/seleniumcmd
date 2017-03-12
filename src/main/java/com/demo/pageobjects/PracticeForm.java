package com.demo.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.datepicker.AppPageFactory;
import com.demo.util.InitializeDrivers;
import com.demo.util.MyConstants;

public class PracticeForm extends AppPageFactory{

	/**
	 * Yogesh
	 *  
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
	
	@FindBy(id="photo")
	WebElement browseProfilePicture;
	
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
		else if(count==1){
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
		
		scrollpage();
	}
	
	
	private void scrollpage() {
		WebDriver driver = InitializeDrivers.getWebdriver();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	public void SelectSelComd(String ...command)
	{
		Select option=new Select(seleniumCmdComboBox);
		for (String item : command) {
			option.selectByVisibleText(item);
		}
		
	}
	
	public void FillDetails(String exp,String dateinput,String prof, String toolNm, String cont, String ...comm)
	{
		selectExp(exp);
		date.sendKeys(dateinput);
		SelectProfession(prof);
		SelectAutoTool(toolNm);
		SelectContinent(cont);
		SelectSelComd(comm);
	}

	
	public void browsePicture() {
		try {
			Thread.sleep(2000);
			scrollpage();
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		browseProfilePicture.click();
		
		
		try {
			//uploadFileWithRobotClasses();
			uploadFileWithAutoItV3();
		} catch (Exception e) {e.printStackTrace();	}
		
	}

	private void uploadFileWithAutoItV3() throws IOException {
		Runtime.getRuntime().exec("C:\\Users\\Progvaltion_11\\Desktop\\AutoItDemo\\FileUpload.exe");
	}

	private void uploadFileWithRobotClasses() throws Exception {
		Robot robot = new Robot();
        Thread.sleep(2000); // Thread.sleep throws InterruptedException	
        //robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button	
        
        setDateToClipBoard("C:\\Users\\Progvaltion_11\\Downloads\\uploadfile\\test.txt");
        
        Thread.sleep(2000);  // sleep has only been used to showcase each event separately	
        robot.keyPress(KeyEvent.VK_CONTROL);	
        Thread.sleep(2000);	
        robot.keyPress(KeyEvent.VK_V);	
        Thread.sleep(2000);	
        
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);	
        Thread.sleep(2000);	
        
        robot.keyRelease(KeyEvent.VK_TAB);
        Thread.sleep(2000);
        
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        robot.keyRelease(KeyEvent.VK_ENTER);
    // press enter key of keyboard to perform above selected action	
		
	}

	private void setDateToClipBoard(String path) {
		StringSelection stringSelection = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard()
		        .setContents(stringSelection, null);	
	}

	@Override
	public boolean isPageLoaded() {
		return isElementPresent(firstNameInput) && isElementPresent(lastNameInput);
	}

	
	
}

