package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ListdetailsPage;

public class Storeprint {
	static WebDriver driver = BaseClass.getDriver();
	ListdetailsPage  storeprint;		
	@Given("user navigate back to the previous page")
	public void user_navigate_back_to_the_previous_page() {
	    //driver.navigate().back();
		storeprint = new ListdetailsPage(BaseClass.getDriver());
	}        

	@When("user clicks on surgeries and validates the page")
	public void user_clicks_on_surgeries_and_validates_the_page() {
		storeprint.validatesurgeries();
	}

	@Then("user extracts and stores the list of surgery names and prints them in a list")
	public void user_extracts_and_stores_the_list_of_surgery_names_and_prints_them_in_a_list() throws IOException {
		storeprint.listOfSurgeries();
	}

	@Given("user is on practo home page")
	public void user_is_on__practo_home_page() {
		//driver.navigate().back();.
		storeprint = new ListdetailsPage(BaseClass.getDriver());
	}

	@When("user clicks on for corporates and clicks on health and wellness plans in practo home page")
	public void user_clicks_on_for_corporates_and_clicks_on_health_and_wellness_plans_in_practo_home_page() {
		storeprint.forprovidersHealth();
		}

	@Then("user navigates to health and wellness plans page and validate the page")
	public void user_navigates_to_health_and_wellness_plans_page_and_validate_the_page() {
		storeprint.validateDemoPage();
	}

	@Then("user provide invalid email and validate schedule a demo button and print the invalid email in console and enter valid email")
	public void user_provide_invalid_email_and_validate_schedule_a_demo_button_and_print_the_invalid_email_in_console_and_enter_valid_email() throws InterruptedException, IOException {
		storeprint.details();
	}


	@Then("User validates the thankyou message")
	public void user_validates_the_thankyou_message() throws InterruptedException {
		Thread.sleep(9000);
		storeprint.thankyou();
	}



}