Feature: Surgeries and Details 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        Feature: Finding Hospital
  Scenario: sucessfully extracting and printing the list of surgeries
    Given user navigate back to the previous page
    When user clicks on surgeries and validates the page
    Then user extracts and stores the list of surgery names and prints them in a list

  Scenario: Schedule a meeting in health and wellness plans for corporates
    Given user is on practo home page
    When user clicks on for corporates and clicks on health and wellness plans in practo home page
    Then user navigates to health and wellness plans page and validate the page
    And user provide invalid email and validate schedule a demo button and print the invalid email in console and enter valid email
    And user validates the thankyou message
