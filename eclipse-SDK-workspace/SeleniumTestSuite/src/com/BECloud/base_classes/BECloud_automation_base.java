/**
 * 
 */
package com.BECloud.base_classes;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Avijit_Chatterjee
 *
 */
public class BECloud_automation_base {
	
	public static WebDriver _driver;
	private static String URL = null;
	private static String BROWSER = null;
	protected static BECloud_automation_properties _properties = new BECloud_automation_properties();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public BECloud_automation_base(){
		if(URL == null){
			URL = _properties.getProperty(BECloud_automation_properties.BASEURL);
		}
		assert URL.contains("http");
		
		if(BROWSER == null){
			BROWSER = _properties.getProperty(BECloud_automation_properties.BROWSER);
		}
	}
	
	/**
	 * * JUnit setup should call this via super.setUp()
	 * By doing so, the mentioned Driver for WebDriver will be instantiated.
	 * @param BROWSER
	 * @throws Exception
	 */
	public void Setup(final String BROWSER) throws Exception {
		
		switch(BROWSER.trim().toLowerCase()){
		case "ie":
			_driver = new InternetExplorerDriver();
			break;
		case "firefox":
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
			_driver = new FirefoxDriver(firefoxProfile);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "InputTestData/chromedriver.exe");
			_driver = new ChromeDriver();
			break;
		default:
			FirefoxProfile firefoxProfileD = new FirefoxProfile();
			firefoxProfileD.setAssumeUntrustedCertificateIssuer(false);
			_driver = new FirefoxDriver(firefoxProfileD);
			break;
		}
		
		_driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		_driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	

}
