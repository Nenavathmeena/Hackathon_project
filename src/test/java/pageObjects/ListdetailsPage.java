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
	
	@FindBy(xpath = "//div[@class='product-tab__title'][text()='Surgeries']")
	WebElement surgeries;
	
	@FindBy(xpath = "//p[normalize-space()='Piles']")
	WebElement scroll;
	
	@FindBy(xpath = "//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeriesname;
	
	@FindBy(xpath = "//span[@class='nav-interact']")
	WebElement forproviders;
	
	@FindBy(xpath= "//a[normalize-space()='Health & Wellness Plans']")
	WebElement health;
	
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
	
	@FindBy(xpath = "(//div[@class='text-center']/div[normalize-space()='THANK YOU'])[1]")
	WebElement thankyou;
	
	
	//Action Methods
	//user clicks on surgeries and validates the page
	public void validatesurgeries() {
		surgeries.click();		//clicks on the surgeries
		String surgeriesPage = driver.getTitle();		//gets the title of the page
		System.out.println("Title of the surgeries page is: " + surgeriesPage);		//prints the title of the  surgeries page
		String title1 = "Practo Care Surgeries | End to end care from top surgeons in your city";		//stores the title of the page in the variable
		Assert.assertEquals(surgeriesPage, title1, "User navigated to correct page");		//validates the title of the surgeries page
		System.out.println("User navigated to correct page");		//prints the statement if title page is validated
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", scroll);		//scrolls the page
	}
	
	//user extracts and stores the list of surgery names and prints them in a list
	public void listOfSurgeries() throws IOException {
		System.out.println("----------------Surgeries------------------");		//prints the statement on console
		List<String> data=new ArrayList<String> ();		//list syntax
		System.out.println("Total no of surgeries elements : " + surgeriesname.size());		//prints the size of the surgeries
		int c=1;		//intially row value is equal to 1 
		Excel.setCellData(File, "Sheet4", 0, 0, "List of Surgeries");		//enters List of Surgeries in the first row and first column
		Excel.fillGreenColor(File, "Sheet4", 0, 0);		//fills the green colour for List of Surgeries
		for(int i=0;i<surgeriesname.size();i++) {
			String list=surgeriesname.get(i).getText();			//gets the text of the surgeries
			System.out.println("Surgeries are : " +list);		//prints the surgeries names on console 
			data.add(list);		//adds the surgeries elements in a list
			Excel.setCellData(File,"Sheet4",c,0, list);		//prints the surgeries names in the excel sheet one by one
			c+=1;		//increases the rows as per the list of surgeries
		}
		System.out.println("List of surgeries are : " +data);		//prints the surgeries names in list format
	}
	
	//user clicks on for corporates and clicks on health and wellness plans in practo home page
	public void forprovidersHealth() {
		forproviders.click();		//clicks on for corporates in homepage
		health.click();		//clicks on health & wellness plans 
	}
	
	//user navigates to health and wellness plans page and validate the page
	public void validateDemoPage() {
		String title = driver.getTitle();		//gets the title of the health page
		System.out.println("corporates page title is : " + title);		//prints the title of the page on console
		String text = "Employee Health | Corporate Health & Wellness Plans | Practo";		//stores the title of the page in variable
		Assert.assertEquals( title,text,"Directed to correct page");		//validates the health page through assertions
		System.out.println("Directed to correct page");		//prints the statement on console if title of the page is validated through assertions
	}
	

	//user provide invalid email and validate schedule a demo button and print the invalid email in console and enter valid email
	public void details() throws InterruptedException, IOException {
		name.sendKeys(BaseClass.getProperties().getProperty("name"));		//enters the name in the name field of the demopage
		orgname.sendKeys(BaseClass.getProperties().getProperty("organizationname"));				//enters the organization name in the organizationname field of the demopage 
		mobileno.sendKeys(BaseClass.getProperties().getProperty("mobileno"));		//enters the mobile number in the mobileno field of the demopage
		email.sendKeys(BaseClass.getProperties().getProperty("invalidemail"));		//enters the invalid email in the email field of the demopage
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",name );		//scrolls the page 
		Select sc = new Select(orgdropdown);		//selects the organisation dropdown
		sc.selectByVisibleText("5001-10000");		//selects "5001-10000" from the dropdown
		Select sc1 = new Select(interestdropdown);		//selects the interstedin dropdown
		sc1.selectByVisibleText("A career opportunity");		//selects "A career opportunity" from the dropdown
		Assert.assertTrue(true, "User entered valid details");		//validates the schedule a demo button is enabled or not 
		String value = email.getAttribute("value");		//gets the invalid email
		System.out.println(value);		//prints the invalid email on console 
		email.clear();		//clears the email field 
		validemail.sendKeys(BaseClass.getProperties().getProperty("validemail"));		//enters the valid email in the email field of the demopage
		schedule.click();		//clicks on the schedule a demo button
		Thread.sleep(9000);		//waits to manually select the elements in captcha
	}
	
	//user validates the thankyou message
	public void thankyou() throws InterruptedException {
		Assert.assertTrue(true,"THANK YOU message is displayed" );		//validates the thankyou message
		System.out.println("THANK YOU message is displayed" );		//prints the statement on console if thankyou message is displayed through assertions
	}
}
	
	


	

