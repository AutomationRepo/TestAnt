/**
 * 
 */
package com.BECloud.base_classes;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * @author Avijit_Chatterjee
 *
 */
public interface BaseNavigation {
	
	/**
	 * Should retrieve all clickable elements 
	 * @return List<WebElement> allelements
	 */
	abstract public List<WebElement> getAllElements();
	
	/**
	 * Should return only the selected link
	 * Which usually corresponds to the currently displayed page
	 * @return WebElement selected
	 */
	abstract public WebElement getSelectedElement();
	
	abstract public boolean isNavPresent();
	
	/**
	 * Locates the link by name, and clicks it
	 * @param elementName
	 * @return BaseElement page
	 */
	abstract public BaseElement clickElement(String elementName);

}
