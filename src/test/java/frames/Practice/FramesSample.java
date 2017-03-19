package frames.Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesSample {
	

	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.guru99.com/selenium/guru99home/");
		driver.manage().window().maximize();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
	   List<WebElement> web= driver.findElements(By.tagName("iframe"));
	   for(WebElement w: web)
	   {
		   String att=w.getAttribute("id");
		   driver.switchTo().frame(att);
		   
		   System.out.println(att);
	   }
	   
		
		driver.close();

	}

}
