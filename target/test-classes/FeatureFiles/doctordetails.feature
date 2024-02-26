Feature: Doctor Details

	Scenario: User finds Ophthalmologists in banglore with relevant filters
	Given user is on the practo home page
	Then user validates the practo home page title
	When user clicks on find doctors and clear the location field
	And user enters bangalore and ophthalmologist in search textbox
	And user selects patient stories field for ophthalmologist                      
	And user selects experience field for ophthalmologist
	And user selects fees for ophthalmologist
	And user selects availability field for ophthalmologist
	And user selects sortby field for ophthalmologist
	Then user stores the top five doctors in a list and prints their detials
 