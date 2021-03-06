/**
 * 
 */
package com.BECloud.base_classes;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Avijit_Chatterjee
 *
 */
public class BECloud_automation_properties {

	public final static String BASEURL = "BASEURL";
	public final static String PROPERTY_FILENAME = "config/beCloud_automation.properties";
	private Properties _beCloud_automation_properties = new Properties();
	public final static String XLS_DATA = "XLS_DATA";
	public final static String USERS_LIST = "USERS_LIST";
	public final static String BROWSER = "BROWSER";
	
	public BECloud_automation_properties(){
	
		try {
			_beCloud_automation_properties.load(new FileInputStream(PROPERTY_FILENAME));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assert !_beCloud_automation_properties.isEmpty();
	}
	
	/**
	 * returns the value of the property denoted by key
	 * 
	 * @param key
	 * @return
	 */
	public String getProperty(final String key) {
		String property = _beCloud_automation_properties.getProperty(key);
		return property != null ? property.trim() : property;
	}
}
