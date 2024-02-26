package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DoctordetailsPage;

public class doctorDetails {
    static WebDriver driver = BaseClass.getDriver();
    DoctordetailsPage doctorDetails;
	@Given("user is on the practo home page")
	public void user_is_on_the_practo_home_page() {
	    doctorDetails = new  DoctordetailsPage(BaseClass.getDriver());
	}

	@Then("user validates the practo home page title")
	public void user_validates_the_practo_home_page_title() 
	{
	    doctorDetails.homepageValidate();
	}

	@When("user clicks on find doctors and clear the location field")
	public void user_clicks_on_find_doctors_and_clear_the_location_field() 
	{
		doctorDetails.searchCity();
	}

	@When("user enters bangalore and ophthalmologist in search textbox")
	public void user_enters_bangalore_and_ophthalmologist_in_search_textbox() throws InterruptedException {
		doctorDetails.locationSpecalist();
	}

	@When("user selects patient stories field for ophthalmologist")
	public void user_selects_patient_stories_field_for_ophthalmologist() throws InterruptedException {
		doctorDetails.patientStories();
	}

	@When("user selects experience field for ophthalmologist")
	public void user_selects_experience_field_for_ophthalmologist() throws InterruptedException {
		doctorDetails.experience();
	}

	@When("user selects fees for ophthalmologist")
	public void user_selects_fees_for_ophthalmologist() throws InterruptedException {
		doctorDetails.fee();                                                             
	}

	@When("user selects availability field for ophthalmologist")
	public void user_selects_availability_field_for_ophthalmologist() throws InterruptedException {
		doctorDetails.availability();
	}

	@When("user selects sortby field for ophthalmologist")
	public void user_selects_sortby_field_for_ophthalmologist() throws InterruptedException {
		doctorDetails.sortby();                                                         
	}

	@Then("user stores the top five doctors in a list and prints their detials")
	public void user_stores_the_top_five_doctors_in_a_list_and_prints_their_detials() throws IOException {
		doctorDetails.details();                                                                                                         
	}


 
}
