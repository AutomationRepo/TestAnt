//Whole code is commented because to reorganize all

/*
package SeleniumTestSuite;
//import org.apache.tools.ant.taskdefs.optional.j.apache.tools.ant.taskdefs.optional.junit.JUnitTask;
import java.io.File;
//import java.text.Format;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.Target;
//import org.apache.tools.ant.taskdefs.Definer.Format;
//import org.apache.tools.ant.taskdefs.Definer.Format;
import org.apache.tools.ant.taskdefs.optional.junit.*;
//import org.apache.tools.ant.taskdefs.optional.junit.AggregateTransformer.Format;
//import org.apache.tools.ant.taskdefs.optional.junit.AggregateTransformer.Format;
import org.apache.tools.ant.types.FileSet;
*>
//import com.opera.core.systems.scope.protos.UmsProtos.Format;

public class AntJUnitCall {
	
	public static void mail(String[] args){
		CreateHTMLReport();
		
	}
	
	public static void CreateHTMLReport(){
		
		Project project = new Project();
		project.setName("AntJUnitCall");
		project.init();

		Target target = new Target();
		target.setName("junitreport");
		project.addTarget(target);
		
		FileSet fs = new FileSet();
		//fs.setDir(new File(".."));
		fs.setDir(new File("E:\\Avijit\\NN"));
		fs.createInclude().setName("*.xml");
		XMLResultAggregator aggregator = new XMLResultAggregator();
		aggregator.addFileSet(fs);
		AggregateTransformer transformer = aggregator.createReport();
		//transformer.setFormat(Format.FRAMES);
		//transformer.setFormat(null);
		transformer.setTodir(new File("E:\\NN"));
		
		target.addTask(aggregator);
		project.executeTarget("junitreport");
	}

}
*/