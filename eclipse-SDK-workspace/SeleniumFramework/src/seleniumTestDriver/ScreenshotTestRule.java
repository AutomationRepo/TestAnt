package seleniumTestDriver;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotTestRule implements TestRule {
	WebDriver driver = null;
	public ScreenshotTestRule(WebDriver driver){
		this.driver = driver;
	}
	
	public Statement apply(final Statement statement, final Description description){
		return new Statement(){
			@Override
			public void evaluate() throws Throwable{
				try{
					statement.evaluate();
				} catch(Throwable t){
					captureScreenshot(description.getMethodName());
                    throw t; // rethrow to allow the failure to be reported to JUnit
				}
			}
			
			public void captureScreenshot(String fileName) {
		        try {
		        	/*
		            new File("target/surefire-reports/").mkdirs(); // Insure directory is there
		            FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
		            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
		            out.close();
		            
		            
		        	File currentDirectory = new File(new File(".").getAbsolutePath()+"\\Screenshots\\");
		        	System.out.println(currentDirectory.getCanonicalPath());
		        	System.out.println(currentDirectory.getAbsolutePath());
		        	*/
		        	File currentDirectory = new File(new File(".").getAbsolutePath());
		        	new File(currentDirectory+"\\Screenshots\\").mkdir();
		            String filePath = currentDirectory.toString().replace(".","")+"\\Screenshots\\"+fileName+"_failed"+".jpg";
		            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    		FileUtils.copyFile(scrFile, new File(filePath));
		            
		        } catch (Exception e) {
		            // No need to crash the tests if the screenshot fails
		        }
		    }
		};
	}	
}
