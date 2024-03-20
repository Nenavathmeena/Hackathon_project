package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DoctordetailsPage;

public class doctorDetails {
    DoctordetailsPage doctorDetails = new  DoctordetailsPage(BaseClass.getDriver());
	@Given("user is on the practo home page")
	public void user_is_on_the_practo_home_page() {
		BaseClass.getLogger().info("Practo Home page....");
	}

	@Then("user validates the practo home page title")
	public void user_validates_the_practo_home_page_title() 
	{
		BaseClass.getLogger().info("Validates the practo page");
	    doctorDetails.homepageValidate();
	}

	@When("user clicks on find doctors and clear the location field")
	public void user_clicks_on_find_doctors_and_clear_the_location_field() 
	{
		BaseClass.getLogger().info("Clicks on find doctors....");
		doctorDetails.searchCity();
	}

	@When("user enters bangalore and ophthalmologist in search textbox")
	public void user_enters_bangalore_and_ophthalmologist_in_search_textbox() throws InterruptedException {
		BaseClass.getLogger().info("enters the location....");
		doctorDetails.locationSpecalist();
	}

	@When("user selects patient stories field for ophthalmologist")
	public void user_selects_patient_stories_field_for_ophthalmologist() throws InterruptedException {
		BaseClass.getLogger().info("selects patient stories dropdown....");
		doctorDetails.patientStories();
	}

	@When("user selects experience field for ophthalmologist")
	public void user_selects_experience_field_for_ophthalmologist() throws InterruptedException {
		BaseClass.getLogger().info("selects experience dropdown....");
		doctorDetails.experience();
	}

	@When("user selects fees for ophthalmologist")
	public void user_selects_fees_for_ophthalmologist() throws InterruptedException {
		BaseClass.getLogger().info("selects fees from all filter dropdown....");
		doctorDetails.fee();                                                             
	}

	@When("user selects availability field for ophthalmologist")
	public void user_selects_availability_field_for_ophthalmologist() throws InterruptedException {
		BaseClass.getLogger().info("selects availability from all filter dropdown....");
		doctorDetails.availability();
	}

	@When("user selects sortby field for ophthalmologist")
	public void user_selects_sortby_field_for_ophthalmologist() throws InterruptedException {
		BaseClass.getLogger().info("selects sortby dropdown....");
		doctorDetails.sortby();                                                         
	}

	@Then("user stores the top five doctors in a list and prints their detials")
	public void user_stores_the_top_five_doctors_in_a_list_and_prints_their_detials() throws IOException, InterruptedException {
		BaseClass.getLogger().info("stores first five doctor details....");
		doctorDetails.details();      
	}
}




