package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import DriverSetup.BaseClass;

public class SmokePage extends BasePage {

	public SmokePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(50));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    
    @FindBy(xpath = "//div[@class='product-tab__title'][normalize-space()='Find Doctors']")
	WebElement finddoctors;
	
	@FindBy(xpath = "//input[@placeholder='Search location']")
	WebElement searchlocation;
	
	@FindBy(xpath = "//input[@data-qa-id='omni-searchbox-keyword']")
	WebElement searchspecalist;
	                         
	@FindBy(xpath = "//div[normalize-space()='Ophthalmologist']")
	WebElement clickspecalist;
	
	@FindBy(xpath = "//div[@class='info-section']")
	List<WebElement> doctorprofile;
	
	@FindBy(xpath = "//div[@class='product-tab__title'][normalize-space()='Surgeries']")
	WebElement surgeries;
	
	@FindBy(xpath = "//p[normalize-space()='Piles']")
	WebElement scroll;
	
	@FindBy(xpath = "//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeriesname;
	
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
	
	@FindBy(xpath = "//header[@id='header']//button[normalize-space()='Schedule a demo']")
	WebElement schedule;
	
	@FindBy(id = "officialEmailId")
	WebElement validemail;
	
	@FindBy(xpath = "//header[@id='header']//button[normalize-space()='Schedule a demo']")
	WebElement scheduledemo;
	
	@FindBy(xpath = "(//div[@class='text-center']/div[normalize-space()='THANK YOU'])[1]")
	WebElement thankyou;
	
	//Action methods
	public void finddoctorsClick() {
		finddoctors.click();
	}
	
	public void clearLocation() {
		searchlocation.clear();
	}
	
	public void enterLocation() {
		searchlocation.sendKeys("Bangalore");
	}
	
	public void enterspecalist(){
		searchspecalist.sendKeys("Ophthalmologist");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		clickspecalist.click();
	}
	
	public void details() throws IOException, InterruptedException {
		Thread.sleep(4000);
		System.out.println("Total number of doctors : " + doctorprofile.size());
		for(int i=0;i<5;i++) {
			String Doctordetails = doctorprofile.get(i).getText();
			System.out.println("Details are:" + Doctordetails);
			System.out.println("-------------------------------------------------------------");
		}
	}
	
	public void clickOnSurgeries() {
		surgeries.click();
	}
	
	public void validateSurgeriesPage() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		String surgeriesPage = driver.getTitle();
		System.out.println("Title of the diagnostic page is: " + surgeriesPage);
		String title1 = "Practo Care Surgeries | End to end care from top surgeons in your city";
		Assert.assertEquals(surgeriesPage, title1, "User navigated to correct page");
		System.out.println("User navigated to correct page");
	}
	
	public void surgeriesList() {
		System.out.println("----------------Surgeries------------------");
		List<String> data=new ArrayList<String> ();
		System.out.println("Total no of elements : " + surgeriesname.size());
		for(int i=0;i<surgeriesname.size();i++) {
			String list=surgeriesname.get(i).getText();	
			System.out.println(list);
			data.add(list);
		}
		System.out.println("List of surgeries are : " +data);
	}
	
	public void forCorporates() throws InterruptedException  {
		forcorporates.click();
		Thread.sleep(2000);
	}
	
	public void healthWellness() {
		health.click();
	}
	
	public void validate() {
		String title = driver.getTitle();
		System.out.println("corporates page title is : " + title);
		String text = "Employee Health | Corporate Health & Wellness Plans | Practo";
		Assert.assertEquals( title,text,"Directed to correct page");
		System.out.println("Directed to correct page");
	}
	
	public void invalidEmail() throws IOException {
		name.sendKeys(BaseClass.getProperties().getProperty("name"));
		orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));
		mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));
		email.sendKeys(BaseClass.getProperties().getProperty("invalidemail"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",schedulescroll );
		Select sc = new Select(orgdropdown);
		sc.selectByVisibleText("5001-10000");
		Select sc1 = new Select(interestdropdown);
		sc1.selectByVisibleText("A career opportunity");
	}
	
	public void validateSchedule() {
		System.out.println(schedule);
		Assert.assertTrue(true, "User entered valid details");
		String value = email.getAttribute("value");
		System.out.println(value);
	}
	
	public void validEmail() throws IOException, InterruptedException {
		email.clear();
		validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
		scheduledemo.click();
		Thread.sleep(9000);
	}
	
	public void validateThankyou() throws InterruptedException {
		boolean Boolean = thankyou.isDisplayed();
		Assert.assertTrue(true,"THANK YOU message is displayed" );
		System.out.println("THANK YOU message is displayed" );
		Thread.sleep(5000);
		//driver.navigate().refresh();
//		driver.navigate().back();
//		driver.navigate().back();
	}
}
	

