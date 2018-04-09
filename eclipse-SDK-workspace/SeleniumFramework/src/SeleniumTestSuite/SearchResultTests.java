package SeleniumTestSuite;

import PageObject.Pages.*;
import seleniumTestDriver.ScreenshotTestRule;
import seleniumTestDriver.Utility;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchResultTests extends Utility{
	private static WebDriver driver;
	private static String baseUrl;
	//private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	private final BingHome BingHomePageObj = new BingHome(driver);
	
	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule(driver);
	
	@BeforeClass
	public static void PreTest() throws Exception{
		//driver = new FirefoxDriver();
	
		System.setProperty("webdriver.chrome.driver","E:\\Avijit\\eclipse-SDK-workspace\\SeleniumFramework\\External\\chromedriver.exe");
		driver = new ChromeDriver();
	    baseUrl = "http://www.bing.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);	    
	}
	
	@AfterClass
	public static void PostTest() throws Exception{
		driver.manage().deleteAllCookies();
		driver.quit();
		  String verificationErrorString = verificationErrors.toString();
		  if (!"".equals(verificationErrorString)) {
		    fail(verificationErrorString);
		  }
		  Utility.KillProcess("iexplore.exe");
	}
	
	@Before
	public void setUp() throws Exception {
		/*driver = new FirefoxDriver();
	    baseUrl = "http://www.bing.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);*/
	  }
	
	@After
	public void tearDown() throws Exception {
	  /*driver.quit();
	  String verificationErrorString = verificationErrors.toString();
	  if (!"".equals(verificationErrorString)) {
	    fail(verificationErrorString);
	  }*/
	}
		
	@Test
	public void VerifySearch(){
		BingHomePageObj.EnterSearchItem("Automation");
	    BingHomePageObj.ClickSearchButton();
	    Wait(3000);
	    assertTrue(driver.getCurrentUrl().contains("q=Automation"));
	}
	
	
		
}
