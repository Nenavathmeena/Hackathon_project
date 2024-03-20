package stepDefinitions;
 
import java.io.IOException;
 
import org.openqa.selenium.WebDriver;
 
import DriverSetup.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DoctordetailsPage;
import pageObjects.RegressionPage;
import pageObjects.SmokePage;
 
public class Smoke {
	SmokePage smoke = new SmokePage(BaseClass.getDriver());	     
	@Given("user navigates to the practo home page")
	public void user_navigates_to_the_practo_home_page() {
	    //smoke = new SmokePage(BaseClass.getDriver());
	}
 
	@When("user clicks on find doctors in navigation bar of practo home page")
	public void user_clicks_on_find_doctors_in_navigation_bar_of_practo_home_page() {
	    smoke.finddoctorsClick();
	    }
 
	@When("user clear the location field in practo home page")
	public void user_clear_the_location_field_in_practo_home_page() {
	   smoke.clearLocation();
	}
 
	@When("user enters {string} in location field of practo home page")
	public void user_enters_in_location_field_of_practo_home_page(String string) {
	    smoke.enterLocation();
	}
 
	@When("user enters {string} in search bar of practo home page")
	public void user_enters_in_search_bar_of_practo_home_page(String string) {
	    smoke.enterspecalist();
	}
 
	@Then("user should see a list of ophthalmologist in bangalore location of relevant filter")
	public void user_should_see_a_list_of_ophthalmologist_in_bangalore_location_of_relevant_filter() throws InterruptedException, IOException {
	    smoke.details();
	}
 
	@When("user clicks on surgeries in the practo home page navigation bar")
	public void user_clicks_on_surgeries_in_the_practo_home_page_navigation_bar() {
	    smoke.clickOnSurgeries();
	}
 
	@Then("user validates the surgeries page")
	public void user_validates_the_surgeries_page() {
	    smoke.validateSurgeriesPage();
	}
 
	@Then("user stores the list of popular surgeries and print them")
	public void user_stores_the_list_of_popular_surgeries_and_print_them() {
	    smoke.surgeriesList();
	}
 
	@When("user clicks on for corporates dropdown in practo home page navigation bar")
	public void user_clicks_on_for_corporates_dropdown_in_practo_home_page_navigation_bar() throws InterruptedException {
	   smoke.forCorporates();
	}
 
	@When("user selects health and wellness plans in for corporates dropdown")
	public void user_selects_health_and_wellness_plans_in_for_corporates_dropdown() {
	    smoke.healthWellness();
	}
	@Then("user navigates health and wellness plans page and validate the page")
	public void user_navigates_health_and_wellness_plans_page_and_validate_the_page() {
		smoke.validate();
	}
 
	@When("user provide invalid email id and valid details for other fields in the form")
	public void user_provide_invalid_email_id_and_valid_details_for_other_fields_in_the_form() throws IOException {
	    smoke.invalidEmail();
	}
 
	@Then("user validates schedule a demo button is enabled in the health and wellness plans page")
	public void user_validates_schedule_a_demo_button_is_enabled_in_the_health_and_wellness_plans_page() {
	   smoke.validateSchedule();
	}
 
	@When("user enters valid email id and clicks on schedule a demo button")
	public void user_enters_valid_email_id_and_clicks_on_schedule_a_demo_button() throws IOException, InterruptedException {
	    smoke.validEmail();
	}
 
	@Then("user validates the thank you message and print in console")
	public void user_validates_the_thank_you_message_and_print_in_console() throws InterruptedException {
	    smoke.validateThankyou();
	}
 
}