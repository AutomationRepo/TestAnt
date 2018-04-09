package PageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import seleniumTestDriver.Page;

public class BingHome extends Page{
	private WebDriver driver;
	//private StringBuffer verificationErrors = new StringBuffer();
	
	public BingHome(WebDriver driver){
		this.driver = driver;
	}
	
	public BingHome EnterSearchItem(String searchItem){
		driver.findElement(By.id("sb_form_q")).clear();
		driver.findElement(By.id("sb_form_q")).sendKeys(searchItem);
		return this;
	}
	
	public void ClickSearchButton(){
		driver.findElement(By.id("sb_form_go")).click();
	}
	
}
