package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import DriverSetup.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	public static WebDriver driver;
	 static Properties p;
    
	@BeforeAll
   public static void setup() throws IOException
   {
   	driver=BaseClass.initilizeBrowser();	
   	p=BaseClass.getProperties();
   	driver.get(p.getProperty("appURL"));
   	driver.manage().window().maximize(); 
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));//implicit wait
	}
      
	
	@AfterAll
	public static void tearDown() {
		driver.quit();
	}
	
   @AfterStep
   public void addScreenshot(Scenario scenario) {
   	// this is for cucumber junit report
       if(!scenario.isFailed()) {
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());
       }
   }
  

}
