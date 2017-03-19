package frames.Practice;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandler {

	public static void main(String[] args) {
		WebDriver driver= new FirefoxDriver();
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");      

        String handle= driver.getWindowHandle();
        System.out.println("windowhandle"+handle); 
      //  WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.presenceOfElementLocated());
       // driver.findElement(By.name("New Message Window")).click();
        Set<String> handles = driver.getWindowHandles();
        System.out.println(handles);
        for (String handle1 : handles)
        {
        	System.out.println(handle1);
        	driver.switchTo().window(handle1);
        }     
        driver.switchTo().window(handle); //switchig back to parent
        
        driver.close();        

	}

}
