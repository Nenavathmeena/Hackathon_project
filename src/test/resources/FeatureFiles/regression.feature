Feature: Regression suite for finding hospitals

  @regression
  Scenario Outline: Applying patient stories filter for the doctors
    Given user navigates to practo home page
    When user clicks on find doctors in practo home page
    And user clear the location field
    And user enters "<location>" in location field
    And user enters "<specalist>" in search bar
    And user select "<patient stories>" in the patient stories field for ophthalmologist
    Then user should see a list of ophthalmologist in Bangalore location of relevant filter

    Examples: 
      | location  | specalist       | patient stories     |
      | Bangalore | ophthalmologist | 10+ Patient Stories |

  @regression
  Scenario Outline: Applying experience filter for the doctors
    Given user navigates to practo home page
    When user select "<Experience>" in the experience field for ophthalmologist
    Then user should see a list of ophthalmologist in Bangalore location of relevant filter

    Examples: 
      | Experience             |
      | 5+ Years of experience |

  @regression
  Scenario Outline: Applying availability filter for the doctors
    Given user navigates to practo home page
    When user select "<fees>" in the fees field for ophthalmologist
    Then user should see a list of ophthalmologist in Bangalore location of relevant filter

    Examples: 
      | fees       |
      | Above ₹500 |

  @regression
  Scenario Outline: Applying availability filter for the doctors
    Given user navigates to practo home page
    And user select "<availability>" in the availability field for ophthalmologist
    Then user should see a list of ophthalmologist in Bangalore location of relevant filter

    Examples: 
      | location  | doctor          | Availability       |
      | Bangalore | ophthalmologist | Available Tomorrow |

  @regression
  Scenario Outline: Applying sort by filter for the doctors
    Given user navigates to practo home page
    When user select "<sortby>" in the sortby field for ophthalmologist
    Then user should see a list of ophthalmologist in Bangalore location of relevant filter

    Examples: 
      | sortby                   |
      | Experience - High to Low |

  @regression
  Scenario: Succesful navigation to surgeries page in practo website
    Given user navigates to practo home page
    When user clicks on surgeries page
    Then user verifies the surgeries page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing name
    Given user navigates to the practo home page
    When user clicks on for corporates dropdown in practo home page navigation bar
    And user selects health and wellness plans in for corporates dropdown
    When user leaves name field empty and fill all other fields and clicks on schedule a demo button
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing organization name
    Given user navigates to the practo home page
    When user leaves organization name field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing contact number
    Given user navigates to the practo home page
    When user leaves contact number field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with less digits in contact number
    Given user navigates to the practo home page
    When user enters incorrect number of digits in contact field and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with invalid contact number
    Given user navigates to the practo home page
    When user enters number that starts with less than five in contact field and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without providing email
    Given user navigates to the practo home page
    When user leaves official email field empty and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with invalid email
    Given user navigates to the practo home page
    When user provide invalid email id and valid details for other fields in the form
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation with valid email
    Given user navigates to the practo home page
    When user enters valid email id and clicks on schedule a demo button
    Then user validates the thank you message and print in console

  @regression
  Scenario: Corporate Health and Wellness Form Validation without selecting organization size dropdown
    Given user navigates to the practo home page
    When user does not select any option from oraganization size dropdown and fill all other fields
    Then user validates schedule a demo button is enabled in the health and wellness plans page

  @regression
  Scenario: Corporate Health and Wellness Form Validation without selecting interested dropdown
    Given user navigates to the practo home page
    When user does not select any option from interested in dropdown and fill all other fields
    Then user verifies schedule a demo button
