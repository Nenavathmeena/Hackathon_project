Feature: Hospitals Details

  @smoke
	Scenario: navigation to the find doctors page 
	Given user navigates to practo home page
	When user clicks on find doctors in the practo home page
	And user clears the location and enters banglore in the location search field
	Then 
	