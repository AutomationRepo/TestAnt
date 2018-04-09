package frameworkLogging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.XMLFormatter;
//import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MyTestLogger {
	
	static String logDirectory = System.getProperty("user.dir")+"\\Logs";
	static private FileHandler fileTxt;
	static private SimpleFormatter formatterTxt;
	
	static private FileHandler fileXML;
	static private XMLFormatter formatterXML;

	static private FileHandler fileHTML;
	static private Formatter formatterHTML;

	static public void Init() throws IOException {

	    // Get the global logger to configure it
	    //Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	    Logger logger = Logger.getLogger("");
	    //LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.FINE);
	
	    logger.setLevel(Level.INFO);
	    
	    new File(logDirectory).mkdir();
	    fileTxt = new FileHandler(logDirectory+"\\Logging.txt");
	    fileXML = new FileHandler(logDirectory+"\\Logging.xml");
	    fileHTML = new FileHandler(logDirectory+"\\Logging.html");
	
	    // Create txt Formatter
	    formatterTxt = new SimpleFormatter();
	    fileTxt.setFormatter(formatterTxt);
	    logger.addHandler(fileTxt);
	    
	 // Create xml Formatter
	    formatterXML = new XMLFormatter();
	    fileXML.setFormatter(formatterXML);
	    logger.addHandler(fileXML);
	
	    // Create HTML Formatter
	    formatterHTML = new MyHtmlFormatter();
	    fileHTML.setFormatter(formatterHTML);
	    logger.addHandler(fileHTML);
	    
	}
	
	static public void Close(){
		fileTxt.close();
		fileXML.close();
		fileHTML.close();
	}

}
