Feature: Smoke suite for finding hospitals

  @smoke
  Scenario: search for ophthalmologist in bangalore location in practo website
    Given user navigates to the practo home page
    When user clicks on find doctors in navigation bar of practo home page
    When user clear the location field in practo home page
    And user enters "<location>" in location field of practo home page
    And user enters "<specalist>" in search bar of practo home page
    Then user should see a list of ophthalmologist in bangalore location of relevant filter              
    Examples: 
      | location  | specalist       |
      | Bangalore | ophthalmologist |`

  @smoke
  Scenario: Surgeries Page Navigation in practo website
    Given user navigates to the practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user validates the surgeries page

  @smoke
  Scenario: store and print popular surgeries listed in surgeries Page
    Given user navigates to the practo home page
    When user clicks on surgeries in the practo home page navigation bar
    Then user stores the list of popular surgeries and print them

  @smoke
  Scenario: Corporate Health and Wellness Form Validation with invalid email
    Given user navigates to the practo home page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    Then user navigates health and wellness plans page and validate the page
    When user provide invalid email id and valid details for other fields in the form
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @smoke
  Scenario: Corporate Health and Wellness Form Validation with valid email
    Given user navigates to the practo home page
    When user enters valid email id and clicks on schedule a demo button
    Then user validates the thank you message and print in console
