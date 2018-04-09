package seleniumTestDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import seleniumTestDriver.Common.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	// Get date time with System
	public static String GetDateTime() throws Exception {
		// get current date time with Date() to create unique file name
		DateFormat dateFormat = new SimpleDateFormat("hh_mm_ssaa_dd_MMM_yyyy");
		// get current date time with Date()
		Date date = new Date();
		// To identify the system
		//InetAddress ownIP = InetAddress.getLocalHost();
		return (dateFormat.format(date));
	}
	
	
	
	public static void Wait(int MilliSec) {
		try {
			Thread.sleep(MilliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void WaitForPageLoadComplete(){
		//IWait<IWebDriver> wait = new OpenQA.Selenium.Support.UI.WebDriverWait(driver, TimeSpan.FromSeconds(30.00));
		//wait.Until(driver1 => ((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState").Equals("complete"));
	}
	
	/*public static void Print(String Text) {
		System.out.println(Text);
		Reporter.log(Text);
		String Temp = Text;
		sMessages = sMessages + Temp.replaceAll(" ", "_") + "#";
		//System.out.println(Temp);
		//System.out.println(sMessages);
	}*/
	
	
	public static void KillProcess(String processName) throws Exception{
		Runtime.getRuntime().exec("taskkill /F /IM "+ processName + " /T");
		Wait(3000);
	}
	
	public static void TakeScreenShot(WebDriver driver) throws Exception{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("c:\\Temp\\screenshot2.jpg"));
	}
	
	public static boolean IsFileExist(String filePath) throws Exception{
		throw new UnsupportedOperationException();
	}
	
	public static boolean MakeFileCopy(String Source, String Destination) throws Exception{
		throw new UnsupportedOperationException();
	}
	
	public static boolean DeleteFile(String filePath) throws Exception{
		throw new UnsupportedOperationException();
	}
	
	

}
