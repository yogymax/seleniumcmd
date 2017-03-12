package myselenium.commands;

import org.testng.annotations.Test;

import com.demo.pageobjects.PracticeForm;
import com.demo.util.InitializeDrivers;
import com.demo.util.MyConstants;
import com.demo.util.MyConstants.MyBrowsers;

public class PracticeFormTest {
 
	
  @Test
  public void fillPracticeFrom() {
	 PracticeForm practiceForm= InitializeDrivers.enterAppURL(MyBrowsers.Firefox);
	 practiceForm.fillPracticeForm("Abcd", "Pqrs",MyConstants.FEMALE);
	 practiceForm.FillDetails("5","12/03/2017","Auto","QTP","Africa","Wait Commands","Browser Commands");
  }
  
  


}
