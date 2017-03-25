package myselenium.commands;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
 
	
	@DataProvider
	public static Object[][] credentials() {
		
		Object [][] mydata ={
		{"testuser_2", "Test@123","Authenticate User" },
		{"testuser_3", "Test@123","Authenticate User" },
		{"testuser_4", "Test@123","Authenticate User" },
		{"testuser_5", "Test@123","Authenticate User" },
		{"testuser_6", "Test@123","Authenticate User" },
		{"testuser_7", "Test@123","Authenticate User" },
		{"testuser_8", "Test@123","Authenticate User" },
		{"testuser_9", "Test@123","Authenticate User" }
		};
		return mydata;
	}
	
static int count=1;	
 
@Test(dataProvider="credentials")
  public void login(String username,String password) {
	 System.out.println("Iteration count "+count +" : "+username+" : "+password +" : ");
	 count++;
	 
 }

}
