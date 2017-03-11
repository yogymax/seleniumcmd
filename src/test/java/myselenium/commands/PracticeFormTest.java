package myselenium.commands;

import org.testng.annotations.Test;

import com.demo.pageobjects.PracticeForm;
import com.demo.util.InitializeDrivers;
import com.demo.util.MyConstants;
import com.demo.util.MyConstants.MyBrowsers;

public class PracticeFormTest {
 
	
  @Test
  public void fillPracticeFrom1() {
	 PracticeForm practiceForm= InitializeDrivers.enterAppURL(MyBrowsers.Firefox);
	 practiceForm.fillPracticeForm("Abcd", "Pqrs",MyConstants.FEMALE);
  }
  
  


}
