package myselenium.commands;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
 
	
	@DataProvider
	public static Object[][] credentials() {
		
		//Rows - Number of times your test has to be repeated.
		//Columns - Number of parameters in test data.
		//3 rows and 2 columns
		Object [][] mydata = new Object[9][3];
		mydata[0][0] = "testuser_2";
		mydata[0][1] = "Test@123";
		mydata[0][2] = "Authenticate User";
		
		return mydata;
		
		
		/*
		{"testuser_2", "Test@123","Authenticate User" },
		{"testuser_3", "Test@123","Authenticate User" },
		{"testuser_4", "Test@123","Authenticate User" },
		{"testuser_5", "Test@123","Authenticate User" },
		{"testuser_6", "Test@123","Authenticate User" },
		{"testuser_7", "Test@123","Authenticate User" },
		{"testuser_8", "Test@123","Authenticate User" },
		{"testuser_9", "Test@123","Authenticate User" }*/
	};
	 
	
static int count=1;	
 @Test(dataProvider="credentials")
  public void login(String username,String password) {
	 System.out.println("Iteration count "+count +" : "+username+" : "+password +" : ");
	 count++;
	 
 }

}
