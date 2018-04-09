/**
 * 
 */
package com.BECloud.base_classes;
import org.openqa.selenium.NoSuchElementException;

/**
 * @author Avijit_Chatterjee
 *
 */
public interface BaseElement {
	
	// webdriver calls to determine if this is the page.
	abstract public boolean onPage() throws NoSuchElementException; 
	
	/**
	 * 
	 * @return
	 */
	abstract public boolean waitForPage();
	
}
