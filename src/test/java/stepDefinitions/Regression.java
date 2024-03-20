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
 
public class Regression {
    WebDriver driver;
    RegressionPage regression = new RegressionPage(BaseClass.getDriver());
	@Given("user navigates to practo home page")
	public void user_navigates_to_practo_home_page() {
		
	}
	
	@When("user clicks on find doctors in practo home page")
	public void user_clicks_on_find_doctors_in_practo_home_page() {
	    regression.clickDoctor();
	    }
 
	@When("user clear the location field")
	public void user_clear_the_location_field() {
		regression.clearLoc();
	}
 
	@When("user enters {string} in location field")
	public void user_enters_in_location_field(String string) {
		regression.Location();
	}
 
	@When("user enters {string} in search bar")
	public void user_enters_in_search_bar(String string) {
		regression.specalist();
	}
 
	@When("user select {string} in the patient stories field for ophthalmologist")
	public void user_select_in_the_patient_stories_field_for_ophthalmologist(String string) throws InterruptedException {
	    regression.patientsField();
	}
	
	
	@When("user select {string} in the experience field for ophthalmologist")
	public void user_select_in_the_experience_field_for_ophthalmologist(String string) throws InterruptedException {
	   regression.experienceField();
	}
	
	@When("user select {string} in the fees field for ophthalmologist")
	public void user_select_in_the_fees_field_for_ophthalmologist(String string) throws InterruptedException {
	    regression.feeField();
	}
 
	@When("user select {string} in the availability field for ophthalmologist")
	public void user_select_in_the_availability_field_for_ophthalmologist(String string) throws InterruptedException {
	    regression.availabilityField();
	}
	
	@When("user select {string} in the sortby field for ophthalmologist")
	public void user_select_in_the_sortby_field_for_ophthalmologist(String string) throws InterruptedException{
		regression.sortbyField();
		}
	
	@Then("user should see a list of ophthalmologist in Bangalore location of relevant filter")
	public void user_should_see_a_list_of_ophthalmologist_in_Bangalore_location_of_relevant_filter() throws IOException {
		regression.doctors();
	}
	
	@When("user clicks on surgeries page")
	public void user_clicks_on_surgeries_page() {
		regression.listSurgeries();
	}
	
	
	@Then("user verifies the surgeries page")
	public void user_verifies_the_surgeries_page() {
		regression.surgeriesValidate();
	}
 
	@When("user leaves name field empty and fill all other fields and clicks on schedule a demo button")
	public void user_leaves_name_field_empty_and_fill_all_other_fields_and_clicks_on_schedule_a_demo_button() throws IOException {
	    regression.emptyName();
	}
 
	@When("user leaves organization name field empty and fill all other fields")
	public void user_leaves_organization_name_field_empty_and_fill_all_other_fields() throws IOException {
	   regression.emptyOrg();
	   
	}
 
	@When("user leaves contact number field empty and fill all other fields")
	public void user_leaves_contact_number_field_empty_and_fill_all_other_fields() throws IOException {
	    regression.emptyContact();
	}
 
	@When("user enters incorrect number of digits in contact field and fill all other fields")
	public void user_enters_incorrect_number_of_digits_in_contact_field_and_fill_all_other_fields() throws IOException {
	    regression.invalidContact();
	}
 
	@When("user enters number that starts with less than five in contact field and fill all other fields")
	public void user_enters_number_that_starts_with_less_than_five_in_contact_field_and_fill_all_other_fields() throws IOException {
	   regression.lessthanFive();
	}
 
	@When("user leaves official email field empty and fill all other fields")
	public void user_leaves_official_email_field_empty_and_fill_all_other_fields() throws IOException {
	    regression.emptyEmail();
	}
 
	@When("user does not select any option from oraganization size dropdown and fill all other fields")
	public void user_does_not_select_any_option_from_oraganization_size_dropdown_and_fill_all_other_fields() throws IOException {
	    regression.orgSize();
	}
 
	@When("user does not select any option from interested in dropdown and fill all other fields")
	public void user_does_not_select_any_option_from_interested_in_dropdown_and_fill_all_other_fields() throws IOException, InterruptedException {
	   regression.intrested();
	}
 
    @Then("user verifies schedule a demo button")
    public void user_verifies_schedule_a_demo_button() {
    	regression.Validatedemo();
    	}


 
 
}
 