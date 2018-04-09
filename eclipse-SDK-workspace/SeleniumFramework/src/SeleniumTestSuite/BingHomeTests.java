package SeleniumTestSuite;

import SeleniumTestSuite.MyTestRunner;
import seleniumTestDriver.Utility;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import seleniumTestDriver.*;

public class BingHomeTests extends Utility{
	// Always use the classname, this way you can refractor
	 private final static Logger TestLOGGER = Logger.getLogger(MyTestRunner.class.getName());
	 	
	private static WebDriver driver;
	private static String baseUrl;
	//private boolean acceptNextAlert = true;
	private static StringBuffer verificationErrors = new StringBuffer();
	
	public BingHomeTests(){
		
	}
	
	@Rule
	public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule(driver);
	
	@BeforeClass
	public static void PreTest() throws Exception{
		driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","E:\\Avijit\\IDE_Platform\\selenium\\chromedriver_win_23.0.1240.0\\chromedriver.exe");
		//driver = new ChromeDriver();
		//driver = new InternetExplorerDriver();
	    baseUrl = "http://www.bing.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	    
	}
	
	@AfterClass
	public static void PostTest() throws Exception{
		driver.manage().deleteAllCookies();
		driver.quit();
		/*
		  String verificationErrorString = verificationErrors.toString();
		  if (!"".equals(verificationErrorString)) {
		    fail(verificationErrorString);
		  }
		  */
		  Utility.KillProcess("iexplore.exe");		  
	}
	
	@Before
	public void setUp() throws Exception {
				
	  }
	
	@After
	public void tearDown() throws Exception {		
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			//TestLOGGER.log(Level.INFO, "error: "+ verificationErrorString);
			fail(verificationErrorString);
		}
		
	}
		
	@Rule
	public TestWatcher testWatcher = new TestWatcher() {
	    protected void failed(Throwable e, Description description) {
	      //System.out.println("" + description.getDisplayName() + " failed " + e.getMessage());
	      TestLOGGER.log(Level.INFO, description.getDisplayName()+":Test failed with ex: "+e.getMessage());
	      super.failed(e, description);
	    }
	    protected void succeeded(Description description){
	    	TestLOGGER.log(Level.INFO, description.getDisplayName()+":Test Passed");
	    }
	    protected void starting(Description description){
	    	TestLOGGER.log(Level.INFO, description.getDisplayName()+":*****Test Started*****");
	    }
	    protected void finished(Description description){
	    	TestLOGGER.log(Level.INFO, description.getDisplayName()+":Test Finished");
	    }

	  };
	
	@Test
	public void VerifyBingLogoText(){
		assertEquals("Bingk", driver.getTitle());
	}
	
	@Test
	public void VerifyCheckedDomain(){
		assertTrue("Show All is not selected",driver.findElement(By.id("nofiltA")).isSelected());
	}
		
	@Test
	public void IsSearchTextBoxExist(){
		assertTrue(isElementPresent(By.id("sb_form_q")));
	}
	
	@Test
	public void IsSearchButtonPresent() throws Exception{
		//TakeScreenShot(driver);
		assertTrue(isElementPresent(By.id("sb_form_go")));
	}
	
	private boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	    
	}

}
