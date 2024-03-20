package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import DriverSetup.BaseClass;
import Utility.Excel;

public class RegressionPage extends BasePage{

	public RegressionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
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
		
		@FindBy(xpath = "//div[@class='product-tab__title'][normalize-space()='Surgeries']")
		WebElement surgeries;
		
		@FindBy(xpath = "//span[@class=\"nav-interact\"]")
		WebElement forcorporates;
		
		@FindBy(xpath= "//a[normalize-space()='Health & Wellness Plans']")
		WebElement health;
		
		@FindBy(xpath ="//header[@id='header']//input[@id='name']" )
		WebElement schedulescroll;
		
		@FindBy(id = "name")
		WebElement name;
		
		@FindBy(id = "organizationName" )
		WebElement orgname;
		
		@FindBy(id = "contactNumber")
		WebElement mobileno;
		
		@FindBy(id = "officialEmailId")
		WebElement email;
		
		@FindBy(id = "organizationSize")
		WebElement orgdropdown;
		
		@FindBy(id = "interestedIn")
		WebElement interestdropdown;
	
//		@FindBy(xpath = "//header[@id='header']//button[normalize-space()='Schedule a demo']")
//		WebElement schedule;
//		
		@FindBy(id = "officialEmailId")
		WebElement validemail;
		
		@FindBy(xpath = "//header[@id='header']//button[normalize-space()='Schedule a demo']")
		WebElement scheduledemo;
		
		@FindBy(xpath = "(//div[@class='text-center']/div[normalize-space()='THANK YOU'])[1]")
		WebElement thankyou;
		
		
		//Action Methods
		
		public void clickDoctor() {
			finddoctors.click();
		}
		
		public void clearLoc() {
			searchlocation.clear();
		}
		
		public void Location() {
			searchlocation.sendKeys("Bangalore");
		}
		
		public void specalist() {
			searchspecalist.sendKeys("Ophthalmologist");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			clickspecalist.click();
		}
		
		public void patientsField() throws InterruptedException {
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
		
		public void experienceField() throws InterruptedException {
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
		
		public void feeField() throws InterruptedException {
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("arguments[0].click();", allfilters);
//				Thread.sleep(5000);
				allfilters.click();
				Thread.sleep(2000);
				for(WebElement fee:allfilterslist) {
					if(fee.getText().equalsIgnoreCase("Above ₹500")) {
//						js.executeScript("arguments[0].click();", exp);
						fee.click();
						Thread.sleep(5000);
						break;
					}
				}
		}
		
		public void availabilityField() throws InterruptedException {
					allfilters.click();
					Thread.sleep(2000);
					for(WebElement avail:allfilterslist) {
					if(avail.getText().equalsIgnoreCase("Available Tomorrow")) {
						avail.click();
						Thread.sleep(2000);
						break;
					}
				}
		}
		
		
		public void sortbyField() throws InterruptedException {
		    sortby.click();
			for(WebElement sort:clicksortby) {
				if(sort.getText().equalsIgnoreCase("Experience - High to Low")) {
					sort.click();
					Thread.sleep(2000);
					break;
				}
			}
		}
		
		public void doctors() throws IOException {
		System.out.println("Total number of doctors : " + doctorprofile.size());
		for(int i=0;i<5;i++) {
			String Doctordetails = doctorprofile.get(i).getText();
			System.out.println("Details are:" + Doctordetails);
			System.out.println("-------------------------------------------------------------");
		}
		}
		
		public void listSurgeries() {
			surgeries.click();
		}
		
		public void surgeriesValidate() {
			String surgeriesPage = driver.getTitle();
			System.out.println("Title of the diagnostic page is: " + surgeriesPage);
			String title1 = "Practo Care Surgeries | End to end care from top surgeons in your city";
			Assert.assertEquals(surgeriesPage, title1, "User navigated to correct page");
			System.out.println("User navigated to correct page");
		}
		
		public void emptyName() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("emptyname"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
			
		}
	
		public void emptyOrg() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("orgname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
		
		public void emptyContact() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("contactno"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
	
		public void invalidContact() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("incorrectcontact"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
	
		public void lessthanFive() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("lessthanfive"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("emptyemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
	
		public void emptyEmail() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
			email.sendKeys(BaseClass.getProperties().getProperty("invalidemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
		
		public void orgSize() throws IOException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("emptyemail"));
			Select sc1 = new Select(interestdropdown);
			sc1.selectByVisibleText("A career opportunity");
			driver.navigate().refresh();
		}
		
		public void intrested() throws IOException, InterruptedException {
			name.sendKeys(BaseClass.getProperties().getProperty("name"));
			orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
			mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
			validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
			Select sc = new Select(orgdropdown);
			sc.selectByVisibleText("5001-10000");
		}
		
		public void Validatedemo() {
			Boolean schedule = scheduledemo.isEnabled();
			System.out.println(schedule);
			if(schedule.equals(true)) {
				System.out.println("User entered valid details");
			}
			else
			{
				System.out.println("User entered invalid details");
			}
			//Assert.assertTrue(true, "User entered valid details");
//			driver.navigate().back();
//			driver.navigate().back();
		}
	

}

