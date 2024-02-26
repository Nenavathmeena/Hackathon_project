package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
	@FindBy(xpath = "//div[@class='product-tab__title'][normalize-space()='Find Doctors']")
	WebElement finddoctors;
	
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement searchlocation;
	
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchspecalist;
	                        
	@FindBy(xpath = "//div[normalize-space()='Ophthalmologist']")
	WebElement clickspecalist;
	
	@FindBy(xpath = "//div[@data-qa-id='doctor_review_count_section']//li")
	List<WebElement> clickpatientstories;
	
	@FindBy(xpath = "//div[@data-qa-id='doctor_review_count_section']")
	WebElement patientstories;
	
	@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']//li")
	List<WebElement> clickexperience;
	
	@FindBy(xpath = "//div[@data-qa-id='years_of_experience_section']")
	WebElement experience;
	
	@FindBy(xpath = "//label[@class=\"u-c-pointer u-d-block c-filter__label\"]//span/span")
	List<WebElement> allfilterslist;
	
	@FindBy(xpath = "//span[@class='u-spacer--right-thin']")
	WebElement allfilters;
                          	
	@FindBy(xpath = "//div[@data-qa-id='sort_by_section']//li")
	List<WebElement> clicksortby;
	
	@FindBy(xpath = "//div[@data-qa-id='sort_by_section']")
	WebElement sortby;
	
	@FindBy(xpath = "//div[@class='info-section']")
	List<WebElement> doctorprofile;
	
	//Actions
	public void homepageValidate() {
		String homepagetitle = driver.getTitle();
		System.out.println("Title of the homepage is : " + homepagetitle);
		String homepage="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
		Assert.assertEquals(homepagetitle,homepage);
	}
	
	public void searchCity() {
		finddoctors.click();
		searchlocation.clear();
	}
	
	public void locationSpecalist() throws InterruptedException {
		searchlocation.sendKeys("Bangalore");
		//clicklocation.click();
		searchspecalist.sendKeys("ophthalmologist");
		Thread.sleep(3000);
		clickspecalist.click();
	}
	
	public void patientStories() throws InterruptedException {
		patientstories.click();
		Thread.sleep(3000);
		for(WebElement ps:clickpatientstories) {
			if(ps.getText().equalsIgnoreCase("10+ Patient Stories")) {
				ps.click();
				Thread.sleep(3000);
				break;
			}
		}
	}
	
	public void experience() throws InterruptedException {
	    experience.click();
		Thread.sleep(2000);
		for(WebElement exp:clickexperience) {
			if(exp.getText().equalsIgnoreCase("5+ Years of experience")) {
				exp.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void fee() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", allfilters);
			Thread.sleep(3000);
			for(WebElement exp:allfilterslist) {
				if(exp.getText().equalsIgnoreCase("Above ₹500")) {
					js.executeScript("arguments[0].click();", exp);
					Thread.sleep(5000);
					break;
				}
			}
	}
	
	public void availability() throws InterruptedException {

			Thread.sleep(2000);
				allfilters.click();
				for(WebElement exp:allfilterslist) {
				if(exp.getText().equalsIgnoreCase("Available Tomorrow")) {
					exp.click();
					Thread.sleep(2000);
					break;
				}
			}
	}
	
	
	public void sortby() throws InterruptedException {
		//List<WebElement> sorts = driver.findElements(By.xpath("//div[@data-qa-id='sort_by_section']//li"));
	    sortby.click();
		for(WebElement sort:clicksortby) {
			if(sort.getText().equalsIgnoreCase("Experience - High to Low")) {
				sort.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	
	public void details() throws IOException {
		System.out.println("Total number of doctors : " + doctorprofile.size());
		
		int c=1;
		Excel.setCellData(File, "Sheet3", 0, 0, "Doctor Details");
		Excel.fillGreenColor(File, "Sheet3", 0, 0);
		for(int i=0;i<5;i++) {
			int count = 1;
			String Doctordetails = doctorprofile.get(i).getText();
			System.out.println("Details are:" + Doctordetails);
			Excel.setCellData(File,"Sheet3",c,0, Doctordetails);
			c+=1;
			System.out.println("-------------------------------------------------------------");
			count++;
			
		}
	}
}


//h2[@class='doctor-name'] ----------doctor name
//div[@class="u-d-flex"]/span -----------profession
//div[@class="uv2-spacer--xs-top"]/div -------experience
//div[@class="u-bold u-d-inlineblock u-valign--middle"]-----------place
//div[@class="uv2-spacer--xs-top"]/span[1] --------fees
//span[@data-qa-id="doctor_clinic_name"] ---------hospital


