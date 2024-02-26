package testrunner;

//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".\\src\\test\\resources\\FeatureFiles\\doctordetails.feature", ".\\src\\test\\resources\\FeatureFiles\\storedata.feature"},
		glue = "stepDefinitions",
		plugin= {"pretty", "html:reports/myreport.html", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
		        dryRun=false,//to check the mapping between feature file steps and stepdefiniton methods
			    monochrome=true,    // to avoid junk characters in output
				publish=true  // to publish report in cucumber server
		)

public class testRunner extends AbstractTestNGCucumberTests{

}                                                                                                                                                                                                  

