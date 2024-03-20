************************************************PROJECT DESCRIPTION*****************************************************************
 
Problem Statement : Finding Hospitals

1. Search Doctors (any one speciality like Dentist, Cardiologist, etc) for any City (like Chennai, Bangalore, Pune, etc). Apply filters for Patient Stories, Experience, Fees, Availability and any one Sorting; Fetch & display the first 5 Doctor details
2. Go to "Surgeries". Extract & store all the surgeries in a List & display them in console output.
3. Under "For Corporate -> Health and Wellness Plan", fill the form with invalid email id & valid details for other fields, validate if "Taking a demo" button is disabled. Print the observation in console output. Then provide email in valid format & click the button and validate "Thank You" message is displayed

Detailed Description: Hackathon Project
 
1)Launch the browser.
2)Go to " https://www.practo.com/ ".
3)Validate the title and print it.
4)Go to "Find Doctors" and search "ophthalmologist" doctor for "Banglore" city.
5)In Patient Stories dropdown click on "10+ patient stories".
6)In Experience dropdown click on "5+ Years of experience".
7)In all filters dropdown click on fees section which is "Above ₹500".  
8)In all filters dropdown click on avaiability section which is "Available Tomorrow".                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   9)In sortby dropdown click on "Experience - High to Low".
10)Print the details of first five doctors in excel sheet.
11)Now click on "Surgeries"in practo home page and validate the pagey.
12)Print the list of surgeries in excel sheet.
13)Click on For Corporates and then  click on Health & Wellness plans and validate the page.
14)Fill the form with invalid email id and valid details for other field.
15)Validate if "Schedule a demo" button is disabled.
16)Print the invalid email observation in console output.
17)Then provide email in valid format & click the Schedule a demo button .
18)Validate "Thank You" message is displayed after clicking the Schedule a demo button.
19)Close the browser.
                                                                 
 
Key Automation Scope:
 
Capturing the screenshot
Navigation to new page
Printing all the values in console and excel sheet
 
 
**********************************************************STEPS TO EXECUTE*************************************************************
 
-unzip the folder
-On eclipse, goto file->import->select the maven->click on existing maven project->next->browse the location where u unzip the folder-> click on finish
-Now go to the TestNG.xml file and run as TestNGSuite.
-Now the file will Execute and we get the expected output as shown below.
 
*******************************************************FILES DESCRIPTION**************************************************************
 
1.src/test/java- There are five packages in this folder.

->DriverSetup :In this package there is one class BaseClass.

->pageObjects : In this file, the BasePage,DoctordetailsPage, ListdetailsPage, SmokePage and RegressionPage classes are defined.

->stepDefinitions : In this file,  Hooks, DoctorDetails, Storeprint,  classes are defined.

->testrunner  : In this file, testRunner class is defined.

->Utility   : In this file, Excel class is defined.
 
2.src/test/resources- There are two folders in this folder.

-> FeatureFiles  : In this folder, there are doctordetails and storeprint feature files are defined.

->Testdata  : In this folder, there are  config.properties, extent.properties, log4j2.xml and surgeries.xlsx are defined.


3.JRE System Library: In this File we have all dependencies of JAR.files.         
 
4.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed, Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.

5.logs:In this folder automation.log report is present. 
 
6.reports: In this folder the myreport.html is present which is the report of the project
 
7.src: In this, there are two folders
	-main:It is an empty folder
	-test:It has all the BaseClass, Basepage, pageobject files, Stepdefinition files, Excel, FeatureFiles and properties files.
 
8.target: It is an empty folder

9.test-output:In this spark report is present. 

10.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

11.testng.xml : In this file, xml code is there.
 

***************************************************************************************************************************************
 
                                                        OUTPUT ON CONSOLE
 
***************************************************************************************************************************************
 
Scenario: User finds Ophthalmologists in banglore with relevant filters    # src/test/resources/FeatureFiles/doctordetails.feature:3

  Given user is on the practo home page                                    # stepDefinitions.doctorDetails.user_is_on_the_practo_home_page()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 469743 bytes]

Title of the homepage is : Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests

  Then user validates the practo home page title                           # stepDefinitions.doctorDetails.user_validates_the_practo_home_page_title()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 469743 bytes]

  When user clicks on find doctors and clear the location field            # 

stepDefinitions.doctorDetails.user_clicks_on_find_doctors_and_clear_the_location_field()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 267342 bytes]

  And user enters bangalore and ophthalmologist in search textbox          # 

stepDefinitions.doctorDetails.user_enters_bangalore_and_ophthalmologist_in_search_textbox()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 235401 bytes]

  And user selects patient stories field for ophthalmologist               # 

stepDefinitions.doctorDetails.user_selects_patient_stories_field_for_ophthalmologist()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 232198 bytes]

  And user selects experience field for ophthalmologist                    # 

stepDefinitions.doctorDetails.user_selects_experience_field_for_ophthalmologist()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 235537 bytes]

  And user selects fees for ophthalmologist                                # stepDefinitions.doctorDetails.user_selects_fees_for_ophthalmologist()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 235392 bytes]

  And user selects availability field for ophthalmologist                  # 

stepDefinitions.doctorDetails.user_selects_availability_field_for_ophthalmologist()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 235313 bytes]

  And user selects sortby field for ophthalmologist                        # stepDefinitions.doctorDetails.user_selects_sortby_field_for_ophthalmologist()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 232462 bytes]

Total number of doctors : 10
Details are:Dr. Shalini Shetty
Ophthalmologist
31 years experience overall
Bannerghatta Road,Bangalore  Apollo Hospital + 1 more
₹950 Consultation fee at clinic
91% 11 Patient Stories
-------------------------------------------------------------
Details are:Dr. Sanghamitra Burman
Ophthalmologist
25 years experience overall
Indiranagar,Bangalore  SightYears Eye Clinic
₹750 Consultation fee at clinic
99% 478 Patient Stories
-------------------------------------------------------------
Details are:Dr. Rinku Das
Ophthalmologist
23 years experience overall
Sarjapur Road,Bangalore  My Vision Eye Clinic
₹700 Consultation fee at clinic
96% 150 Patient Stories
-------------------------------------------------------------
Details are:Dr. Vinay Patil
Ophthalmologist
22 years experience overall
HSR Layout,Bangalore  Sankalp Nethralaya and PolyClinic
₹600 Consultation fee at clinic
89% 252 Patient Stories
-------------------------------------------------------------
Details are:Dr. Rahul Jain
Ophthalmologist
18 years experience overall
BTM Layout,Bangalore  Dr. Jain's Eye Clinic
₹800 Consultation fee at clinic
99% 929 Patient Stories
-------------------------------------------------------------
  Then user stores the top five doctors in a list and prints their detials # 

stepDefinitions.doctorDetails.user_stores_the_top_five_doctors_in_a_list_and_prints_their_detials()

    Embedding User finds Ophthalmologists in banglore with relevant filters [image/png 232462 bytes]


Scenario: sucessfully extracting and printing the list of surgeries                 # src/test/resources/FeatureFiles/storedata.feature:3

  Given user navigate back to the previous page                                     # stepDefinitions.Storeprint.user_navigate_back_to_the_previous_page()

    Embedding sucessfully extracting and printing the list of surgeries [image/png 232462 bytes]

Title of the diagnostic page is: Practo Care Surgeries | End to end care from top surgeons in your city

User navigated to correct page

  When user clicks on surgeries and validates the page                              # 

stepDefinitions.Storeprint.user_clicks_on_surgeries_and_validates_the_page()

    Embedding sucessfully extracting and printing the list of surgeries [image/png 401928 bytes]

----------------Surgeries------------------
Total no of elements : 19
Piles
Hernia Treatment
Kidney Stone
Cataract
Circumcision
Lasik
Varicose Veins
Gallstone
Anal Fistula
Gynaecomastia
Anal Fissure
Lipoma Removal
Sebaceous cyst
Pilonidal Sinus
Lump in Breast
TURP
Hydrocele
Knee Replacement
Hair Transplant
List of surgeries are : [Piles, Hernia Treatment, Kidney Stone, Cataract, Circumcision, Lasik, Varicose Veins, Gallstone, Anal Fistula, Gynaecomastia, Anal Fissure, Lipoma Removal, Sebaceous cyst, Pilonidal Sinus, Lump in Breast, TURP, Hydrocele, Knee Replacement, Hair Transplant]

  Then user extracts and stores the list of surgery names and prints them in a list # 

stepDefinitions.Storeprint.user_extracts_and_stores_the_list_of_surgery_names_and_prints_them_in_a_list()

    Embedding sucessfully extracting and printing the list of surgeries [image/png 402227 bytes]


Scenario: Schedule a meeting in health and wellness plans for corporates                                                          # 

src/test/resources/FeatureFiles/storedata.feature:8

  Given user is on practo home page                                                                                               # 

stepDefinitions.Storeprint.user_is_on__practo_home_page()

    Embedding Schedule a meeting in health and wellness plans for corporates [image/png 402013 bytes]

  When user clicks on for corporates and clicks on health and wellness plans in practo home page                                  # 

stepDefinitions.Storeprint.user_clicks_on_for_corporates_and_clicks_on_health_and_wellness_plans_in_practo_home_page()

    Embedding Schedule a meeting in health and wellness plans for corporates [image/png 397170 bytes]

corporates page title is : Employee Health | Corporate Health & Wellness Plans | Practo
Directed to correct page
  Then user navigates to health and wellness plans page and validate the page                                                     # stepDefinitions.Storeprint.user_navigates_to_health_and_wellness_plans_page_and_validate_the_page()

    Embedding Schedule a meeting in health and wellness plans for corporates [image/png 397170 bytes]

[[ChromeDriver: chrome on windows (2093a9cded2082abcbc589d2e8381876)] -> xpath: //header[@id='header']//button[normalize-space()='Schedule a demo']]

2303911cognizant.com

  And user provide invalid email and validate schedule a demo button and print the invalid email in console and enter valid email # 

stepDefinitions.Storeprint.user_provide_invalid_email_and_validate_schedule_a_demo_button_and_print_the_invalid_email_in_console_and_enter_valid_email()

    Embedding Schedule a meeting in health and wellness plans for corporates [image/png 730555 bytes]

THANK YOU message is displayed

  And User validates the thankyou message
                                                                                         # stepDefinitions.Storeprint.user_validates_the_thankyou_message()

    Embedding Schedule a meeting in health and wellness plans for corporates [image/png 135508 bytes]

┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/6beaa329-73dc-4441-aa9b-9d6a294313e6 │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │
└──────────────────────────────────────────────────────────────────────────┘
===============================================
Suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================

