package PageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumTestDriver.Page;

public class BECloudHome extends Page{
	private WebDriver driver;
	
	public BECloudHome(WebDriver driver){
		this.driver = driver;
	}
	
	public BECloudHome EnterUserName(String userName){
		driver.findElement(By.id("emailAddress")).clear();
		driver.findElement(By.id("emailAddress")).sendKeys(userName);
		return this;
	}
	
	public BECloudHome EnterPassword(String password){
		driver.findElement(By.id("accountPassword")).clear();
		driver.findElement(By.id("accountPassword")).sendKeys(password);
		return this;
	}
	
	public void ClickSignIn(){
		driver.findElement(By.linkText("Sign In")).click();
	}
	
	public BECloudHome EnterLoginCredential(String userName, String password){
		EnterUserName(userName);
		EnterPassword(password);
		ClickSignIn();
		return this;
		
	}
	

}
