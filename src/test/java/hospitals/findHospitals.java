//package hospitals;
//
//import java.io.File;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//public class findHospitals {
//	
//	static WebDriver driver;
//	public static void main(String[] args) throws InterruptedException, IOException {
//		// TODO Auto-generated method stub
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("https://www.practo.com/");
//		//user validates the practo home page title
//		String homepagetitle = driver.getTitle();
//		System.out.println("Title of the homepage is : " + homepagetitle);
//		String homepage="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
//		if(homepage.equals(homepage)) {
//			System.out.println("Homepage validated successfully");
//		}
//		else {
//			System.out.println("Homepage not validated successfully");
//		}
//		//user search for hospitals in bangalore city and clicks it in practo home page
//		WebElement city = driver.findElement(By.xpath("//input[@placeholder='Search location']"));
//		city.clear();
//		city.sendKeys("Bangalore");
//		driver.findElement(By.xpath("//div[contains(text(),'Bangalore')]")).click();
//		//user searches doctor in search textbox and clicks on eye doctor
//		WebElement search = driver.findElement(By.xpath("//input[@data-qa-id='omni-searchbox-keyword']"));
//		search.sendKeys("ophthalmologist");
//		WebElement specalist = driver.findElement(By.xpath("//input[@value='ophthalmologist']"));
//		specalist.click();
//		String doctors=driver.getTitle();
//		System.out.println("Title of the doctors page is: " + doctors);
//		
//		List<WebElement> patientStories = driver.findElements(By.xpath("//div[@data-qa-id=\"doctor_review_count_section\"]//li"));
//		driver.findElement(By.xpath("//div[@data-qa-id=\"doctor_review_count_section\"]")).click();
//		Thread.sleep(3000);
//		for(WebElement ps:patientStories) {
//			if(ps.getText().equalsIgnoreCase("10+ Patient Stories")) {
//				ps.click();
//				Thread.sleep(3000);
//				break;
//			}
//		}
//		
//		List<WebElement> experience = driver.findElements(By.xpath("//div[@data-qa-id='years_of_experience_section']//li"));
//		driver.findElement(By.xpath("//div[@data-qa-id='years_of_experience_section']//li")).click();
//		Thread.sleep(2000);
//		for(WebElement exp:experience) {
//			if(exp.getText().equalsIgnoreCase("5+ Years of experience")) {
//				exp.click();
//				Thread.sleep(2000);
//				break;
//			}
//		}
//		
//		List<WebElement> allfilters = driver.findElements(By.xpath("//span[@class='u-spacer--right-thin']"));
//		for(WebElement filters : allfilters) {
//		    
//			}
//			
//		}
//		//div[@class="o-page-container u-cushion--vertical pure-g"]//span//span
//		//span[@class="u-spacer--right-thin"]
//		List<WebElement> sortby = driver.findElements(By.xpath("//div[@data-qa-id='sort_by_section']//li"));
//		driver.findElement(By.xpath("//div[@data-qa-id='sort_by_section']//li"));
//		for(WebElement sort:sortby) {
//			if(sort.getText().equalsIgnoreCase("Experience - High to Low")) {
//				sort.click();
//				Thread.sleep(2000);
//				break;
//			}
//		}	
//		//user applies filters for Patient Stories, Experience, Fees, Availability and any one Sorting
//		WebElement patientstories = driver.findElement(By.xpath("//span[@data-qa-id='selected_dropdown_filter']//span[contains(text(),'Patient Stories')]"));
//		patientstories.click();
//		driver.findElement(By.xpath("//span[normalize-space()='10+ Patient Stories']")).click();
//		Thread.sleep(1000);
//		WebElement experience = driver.findElement(By.xpath("//div[@class='c-filter__top']//div[3]"));
//	    experience.click();
//	    driver.findElement(By.xpath("//span[normalize-space()='5+ Years of experience']")).click();
//	    Thread.sleep(1000);
//		WebElement allfilters = driver.findElement(By.xpath("//span[contains(text(),'All Filters')]"));
//		allfilters.click();	
//		Thread.sleep(1000);
//		WebElement fees = driver.findElement(By.xpath("//span[contains(text(),'Above ₹500')]"));
//		fees.click();
//		WebElement availability = driver.findElement(By.xpath("(//span[contains(text(),'Available Tomorrow')])[1]"));
//		availability.click();
//		WebElement sortby = driver.findElement(By.xpath("//span[contains(text(),'Relevance')]"));
//		sortby.click();
//		Thread.sleep(4000);
//		WebElement sortelement = driver.findElement(By.xpath("//span[contains(text(),'Consultation Fee - Low to High')]"));
//		sortelement.click();
//		//Total available doctors after applying filters
//		WebElement totaldoctors = driver.findElement(By.xpath("//h1[@class='u-xx-large-font u-bold']"));
//	    String a = totaldoctors.getText();
//		System.out.println("Total doctors after applying filters: " + a);
//		//print first five doctors details
//		List<WebElement> doctorprofile = driver.findElements(By.xpath("class=\"info-section\""));
//		System.out.println("Total number of doctors : " + doctorprofile.size());
//		String Doctordetails;
//		for(WebElement firstfive:doctorprofile) {
//			int count = 1;
//			Doctordetails = firstfive.getText();
//			System.out.println("Details are:" + Doctordetails);
//			System.out.println("-------------------------------------------------------------");
//			count++;
//			if(count>5)
//			{
//				break;
//			}
//		}
//		
//		//2.user clicks on surgeries and validates the page
//		driver.findElement(By.xpath("//div[@class='product-tab__title'][normalize-space()='Surgeries']")).click();
//		String surgeriesPage = driver.getTitle();
//		System.out.println("Title of the diagnostic page is: " + surgeriesPage);
//		String title2 = "Practo Care Surgeries | End to end care from top surgeons in your city";
//		if(title2.equals(title2))
//		{
//			System.out.println("User navigated to correct page");
//		}
//		else
//		{
//			System.out.println("User navigated to incorrect page");
//		}
//		//user extracts and stores the list of surgery names and prints them in a list
//		System.out.println("----------------Surgeries------------------");
//		List<String> data=new ArrayList<String> ();
//		List<WebElement> surgeries = driver.findElements(By.xpath("//p[@class='mt-12px AilmentItem-module_itemText__XvCHL']"));
//		System.out.println("Total no of elements : " + surgeries.size());
//		for(int i=0;i<surgeries.size();i++) {
//			String list=surgeries.get(i).getText();	
//			System.out.println(list);
//			data.add(list);
//		}
//		System.out.println("List of surgeries are : " +data);
//		driver.navigate().back();
//		
//		//3.Go to Corporate Wellness and validate the page
//		WebElement forproviders = driver.findElement(By.xpath("//span[@class='nav-interact']"));
//		forproviders.click();
//		WebElement health =  driver.findElement(By.xpath("//a[normalize-space()='Health & Wellness Plans']"));
//		health.click();
//		String title = driver.getTitle();
//		System.out.println("corporates page title is : " + title);
//		String text = "Employee Health | Corporate Health & Wellness Plans | Practo";
//		if(text.equals(text))
//		{
//			System.out.println("Directed to correct page");
//		}
//		else
//		{
//			System.out.println("Directed to incorrect page");
//		}
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		WebElement schedulescroll = driver.findElement(By.xpath("//header[@id='header']//button[normalize-space()='Schedule a demo']"));
//		js.executeScript("arguments[0].scrollIntoView();",schedulescroll );
//		//user provide invalid email and validate schedule a demo button is enabled in the health and wellness plans page
//		WebElement name = driver.findElement(By.id("name"));
//		name.sendKeys("Meena");
//		WebElement orgname =driver.findElement(By.id("organizationName"));
//		orgname.sendKeys("Cognizant");
//		WebElement mobileno = driver.findElement(By.id("contactNumber"));
//		mobileno.sendKeys("9876543210");
//		WebElement email =driver.findElement(By.id("officialEmailId"));
//		email.sendKeys("2303911cognizant.com");
//		WebElement orgdropdown = driver.findElement(By.id("organizationSize"));
//		Select sc = new Select(orgdropdown);
//		sc.selectByVisibleText("5001-10000");
//		WebElement interestdropdown = driver.findElement(By.id("interestedIn"));
//		Select sc1 = new Select(interestdropdown);
//		sc1.selectByVisibleText("A career opportunity");
//		//User validate the Schedule Demo is being displayed or not.
//		Boolean schedule = driver.findElement(By.xpath("//header[@id='header']//button[normalize-space()='Schedule a demo']")).isEnabled();
//		System.out.println(schedule);
//		if(schedule.equals(true)) {
//			System.out.println("User entered valid details");
//		}
//		else
//		{
//			System.out.println("User entered invalid details");
//		}
//		//print the invalid email in console output and enter valid email 
//		String value = email.getAttribute("value");
//		System.out.println(value);
//		email.clear();
//		WebElement validemail =driver.findElement(By.id("officialEmailId"));
//		validemail.sendKeys("2303911@cognizant.com");
//		driver.findElement(By.xpath("//header[@id='header']//button[normalize-space()='Schedule a demo']")).click();
//		//User validates the thankyou message
//		Boolean thankyou = driver.findElement(By.xpath("(//div[@class='text-center']/div[normalize-space()='THANK YOU'])[1]")).isDisplayed();
//		if(thankyou.equals(true)) {
//			System.out.println("THANK YOU message is displayed");
//		}
//		else {
//			System.out.println("THANK YOU message is not displayed");
//		}
//		driver.quit();
//	}
//
//}
//
