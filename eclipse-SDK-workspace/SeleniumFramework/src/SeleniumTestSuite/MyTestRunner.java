package SeleniumTestSuite;

import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
//import java.util.logging.Level;
import frameworkLogging.MyTestLogger;

public class MyTestRunner {
	//private final static Logger TestRunnerLOGGER = Logger.getLogger(MyTestRunner.class.getName());
	
	public static void main(String[] args) {
		System.out.println("I am in manin- MyTesRunner");
		//AntJUnitCall.CreateHTMLReport();
		//System.out.println("Out Ant class call- MyTesRunner");
							
		try {
			MyTestLogger.Init();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Problems with creating the log files");
		}
			
		List<String> classList = new ArrayList<String>();
		//classList.add("SearchResult");
		classList.add("BingHomeTests");
		classList.add("BECloudTests");
		classList.add("SearchResultTests");
		
		for (String className : classList) {
			Result result = JUnitCore.runClasses((GetClassName(className)));
			
			for(Failure fail : result.getFailures()){
				System.out.println(fail.getClass().toString());
			}
		}
		
		System.out.println("I am out of main- MyTesRunner");
	}
	
	private static Class<?> GetClassName(String name){
		switch(name.trim().toLowerCase())
		{
		case "searchresulttests":
			return new SearchResultTests().getClass();
			
		case "binghometests":
			return new BingHomeTests().getClass();
			
		case "becloudtests":
			return new BECloudTests().getClass();
		default : 
			return new BingHomeTests().getClass();
		}		
	}	

}
