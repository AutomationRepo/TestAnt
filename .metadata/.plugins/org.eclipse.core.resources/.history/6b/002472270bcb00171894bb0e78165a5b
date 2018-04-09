package hotel.regression;

import static org.junit.Assert.*;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hotel.pages.HomePage;
import hotel.pages.SearchHotelPage;
import hotel.utilty.ReadExcel;
import hotel.logging.Log;
import hotel.logging.Log.eLogLevel;

public class HomePageTests {
	
	HomePage objHome;
	ReadExcel objRS;
	SearchHotelPage objSearch;		
	
	@Before
	public void setUP()
	{	
		PropertyConfigurator.configure("config\\log4j.properties");
		objHome = new HomePage();
		objSearch = new SearchHotelPage();
		objRS = new ReadExcel();			
	}
	
	@Test
	public void loginTest()
	{
		String user = objRS.getCellData("TestCases", "TC_1", "UserName");
		String pwd = objRS.getCellData("TestCases", "TC_1", "Password");
		String result = objRS.getCellData("ExpectedResult", "TC_1", "ProfileName");
		objHome.userLogin(user, pwd);		
		String res = objSearch.getProfileName();
		assertEquals(result, res);		
		Log.write(eLogLevel.DEBUG,"Test Case is passed");
	}
	
	@After
	public void closeBrowser()
	{
		objHome.close();
	}

}
