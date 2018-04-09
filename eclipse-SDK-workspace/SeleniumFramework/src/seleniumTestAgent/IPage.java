package seleniumTestAgent;
import org.openqa.selenium.*;


public interface IPage extends IBrowser{
	String PageTitleCust();
	String PageUrlCust();
	String PageSourceCust();
	boolean WaitForPageLoadCompleteCust(int timeout);
	boolean WaitForTextOnPageCust(String text);
	boolean WaitForElementOnPageCust(WebElement element);

}
