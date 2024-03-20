package pageObjects;

import java.io.IOException;
import java.util.List;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utility.Excel;

public class DoctordetailsPage extends BasePage{

	public DoctordetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String File = System.getProperty("user.dir")+"/src/test/resources/surgeries.xlsx";
	//div[@class='product-tab__title'][normalize-space()='Find Doctors']
	//div[text()='Find Doctors']
	@FindBy(xpath = "//div[text()='Find Doctors']")
	WebElement finddoctors;
	
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement searchlocation;
	
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchspecalist;
	                        
	@FindBy(xpath = "//div[normalize-space()='Ophthalmologist']")
	WebElement clickspecalist;
	
	@FindBy(xpath = "//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientstories;
	
	@FindBy(xpath = "//div[@data-qa-id='doctor_review_count_section']//li")
	List<WebElement> clickpatientstories;
	
	@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']")
	WebElement experience;
	
	@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']//li")
	List<WebElement> clickexperience;
	
	@FindBy(xpath = "//span[@class='u-spacer--right-thin']")
	WebElement allfilters;
	
	@FindBy(xpath = "//label[@class='u-c-pointer u-d-block c-filter__label']//span/span")
	List<WebElement> allfilterslist;
	
	@FindBy(xpath = "//div[@data-qa-id='sort_by_section']")
	WebElement sortby;
                          	
	@FindBy(xpath = "//div[@data-qa-id='sort_by_section']//li")
	List<WebElement> clicksortby;
	
	@FindBy(xpath = "//div[@class='info-section']")
	List<WebElement> doctorprofile;
	
	//Action methods
	//user validates the practo home page title
	public void homepageValidate() {
		String homepagetitle = driver.getTitle();		//gets the title of the homepage
		System.out.println("Title of the homepage is : " + homepagetitle);		//prints the title of the homepage on console
		String homepage="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";		//stores the title in a variable
		Assert.assertEquals(homepagetitle,homepage);		//validates the title of the homepage
	}
	
	//user clicks on find doctors and clear the location field
	public void searchCity() {
		finddoctors.click();		//clicks on find doctors in practo home page
		searchlocation.clear();		//clears the location in location search field
	}
	
	//user enters bangalore and ophthalmologist in search textbox
	public void locationSpecalist() throws InterruptedException {
		searchlocation.sendKeys("Bangalore");		//enters the Bangalore location in location search field
		searchspecalist.sendKeys("Ophthalmologist");		//enters the ophthalmologist specalist in search field
		Thread.sleep(3000);		//waits for specalist to appear in the page
		clickspecalist.click();		//clicks on the ophthalmologist
	}
	
	//user selects patient stories field for ophthalmologist
	public void patientStories() throws InterruptedException {
		patientstories.click();		//clicks on patient stories dropdown
		Thread.sleep(3000);			//waits till patient stories appears
		for(WebElement ps:clickpatientstories) {		//loop to click element
			if(ps.getText().equalsIgnoreCase("10+ Patient Stories")) {			
				ps.click();			//clicks on "10+ patient stories" element
				Thread.sleep(3000);			//waits till the page is loaded
				break;		
			}
		}
	}
	
	//user selects experience field for ophthalmologist
	public void experience() throws InterruptedException {
	    experience.click();			//clicks on experience dropdown
		Thread.sleep(2000);			//waits till experience appears
		for(WebElement exp:clickexperience) {			//loop to click element
			if(exp.getText().equalsIgnoreCase("5+ Years of experience")) {
				exp.click();			//clicks on "5+ Years of experience" element
				Thread.sleep(3000);		//waits till the page is loaded
				break;
			}
		}
	}
	
	//user selects fees for ophthalmologist
	public void fee() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", allfilters);		//clicks on allfilter dropdown	
			Thread.sleep(3000);			//waits till allfilters appears
			for(WebElement exp:allfilterslist) {		//loop to click element
				if(exp.getText().equalsIgnoreCase("Above ₹500")) {
					js.executeScript("arguments[0].click();", exp);			//clicks on "Above ₹500" element
					Thread.sleep(3000);			//waits till the page is loaded
					break;
				}
			}
	}
	
	//user selects availability field for ophthalmologist
	public void availability() throws InterruptedException {
			Thread.sleep(2000);
				allfilters.click();		//clicks on allfilter dropdown
				for(WebElement exp:allfilterslist) {		//loop to click element
				if(exp.getText().equalsIgnoreCase("Available Tomorrow")) {
					exp.click();			//clicks on "Available Tomorrow" element
					Thread.sleep(2000);		//waits till the page is loaded
					break;                                          
				}
			}
	}
	
	//user selects sortby field for ophthalmologist
	public void sortby() throws InterruptedException {
	    sortby.click();			//clicks on sortby dropdown
		for(WebElement sort:clicksortby) {		//loop to click element
			if(sort.getText().equalsIgnoreCase("Experience - High to Low")) {
				sort.click();		//clicks on "Experience - High to Low" element
				Thread.sleep(3000);			//waits till the page is loaded
				break;
			}
		}
	}
	
	//user stores the top five doctors in a list and prints their detials                                                                    
	public void details() throws IOException, InterruptedException {
		System.out.println("Total number of doctors in a page : " + doctorprofile.size());		//prints the total number of doctors available after applying the filters 
		int c=1;
		Excel.setCellData(File, "Sheet3", 0, 0, "Doctor Details");		//excelsheet
		Excel.fillGreenColor(File, "Sheet3", 0, 0);			//excelsheet
		for(int i=0;i<5;i++) {			//enhanced for loop
			String Doctordetails = doctorprofile.get(i).getText();			//stores the doctor details in a variable
			System.out.println("Details are:" + Doctordetails);				//prints the top five doctors details on console
			Excel.setCellData(File,"Sheet3",c,0, Doctordetails);			//excelsheet
			c+=1;
			System.out.println("-------------------------------------------------------------");
		}
	}
}






