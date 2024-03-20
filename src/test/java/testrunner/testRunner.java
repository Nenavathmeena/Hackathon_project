package testrunner;


//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
 
//@RunWith(Cucumber.class)
@CucumberOptions(features = //{".\\src\\test\\resources\\FeatureFiles\\doctordetails.feature",".\\src\\test\\resources\\FeatureFiles\\storedata.feature"},
                             //{".\\src\\test\\resources\\FeatureFiles/smoke.feature"}, 
                            {".\\src\\test\\resources\\FeatureFiles/regression.feature"}, 
				             //{".\\src\\test\\resources\\FeatureFiles"},                                                                                                                                      
                              glue = {"stepDefinitions" }, 
							 plugin = {"pretty", "html:reports/myreport.html",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
							 dryRun = false, 	//to check the mapping between feature steps and step definitions
							 monochrome = false, 	//to avoid junk characters in output
							 publish = true		// to publish report in cucumber server
							 )

public class TestRunner extends AbstractTestNGCucumberTests{
 
}
