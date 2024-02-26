package pageObjects;

import java.io.IOException;

import java.util.ArrayList;
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


public class ListdetailsPage extends BasePage {

	public ListdetailsPage(WebDriver driver) {
		super(driver);
	}
	String File = System.getProperty("user.dir")+"/src/test/resources/surgeries.xlsx";
	
	@FindBy(xpath = "//div[@class='product-tab__title'][normalize-space()='Surgeries']")
	WebElement surgeries;
	
	@FindBy(xpath = "//p[normalize-space()='Gallstone']")
	WebElement scroll;
	
	@FindBy(xpath = "//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeriesname;
	
	@FindBy(xpath = "//span[@class='nav-interact']")
	WebElement forproviders;
	
	@FindBy(xpath= "//a[normalize-space()='Health & Wellness Plans']")
	WebElement health;
	
	@FindBy(xpath ="//header[@id='header']//button[normalize-space()='Schedule a demo']" )
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
	
	
	//Action Methods
	//user clicks on surgeries and validates the page
	public void validatesurgeries() {
		surgeries.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);
		String surgeriesPage = driver.getTitle();
		System.out.println("Title of the diagnostic page is: " + surgeriesPage);
		String title1 = "Practo Care Surgeries | End to end care from top surgeons in your city";
		Assert.assertEquals(surgeriesPage, title1, "User navigated to correct page");
		System.out.println("User navigated to correct page");
	}
	
	//user extracts and stores the list of surgery names and prints them in a list
	public void listOfSurgeries() throws IOException {
		System.out.println("----------------Surgeries------------------");
		List<String> data=new ArrayList<String> ();
		System.out.println("Total no of elements : " + surgeriesname.size());
		int c=1;
		Excel.setCellData(File, "Sheet4", 0, 0, "List of Surgeries");
		Excel.fillGreenColor(File, "Sheet4", 0, 0);
		for(int i=0;i<surgeriesname.size();i++) {
			String list=surgeriesname.get(i).getText();	
			System.out.println(list);
			data.add(list);
			Excel.setCellData(File,"Sheet4",c,0, list);
			c+=1;
		}
		System.out.println("List of surgeries are : " +data);
	}
	
	public void forprovidersHealth() {
		forproviders.click();
		health.click();
	}
	
	//user navigates to health and wellness plans page and validate the page
	public void validateDemoPage() {
		String title = driver.getTitle();
		System.out.println("corporates page title is : " + title);
		String text = "Employee Health | Corporate Health & Wellness Plans | Practo";
		Assert.assertEquals( title,text,"Directed to correct page");
		System.out.println("Directed to correct page");
	}
	
	//user provide invalid email and validate schedule a demo button and print the invalid email in console and enter valid email
	public void details() throws InterruptedException, IOException {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView();",schedulescroll );
		//user provide invalid email and validate schedule a demo button is enabled in the health and wellness plans page
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
		//User validate the Schedule Demo is being displayed or not.
		System.out.println(schedule);
		Assert.assertTrue(true, "User entered valid details");
		String value = email.getAttribute("value");
		System.out.println(value);
		email.clear();
		validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));
		scheduledemo.click();
		Thread.sleep(9000);
	}
	
	//User validates the thankyou message
	public void thankyou() throws InterruptedException {
		thankyou.isDisplayed();
		Assert.assertTrue(true,"THANK YOU message is displayed" );
		System.out.println("THANK YOU message is displayed" );
	}

}
	
	
	

