Feature: Login

  @validData
  Scenario: User can log in with valid data
    Given User launches browser
    When User opens ilCarro Home Page
    And User clicks on Log in link
    And User enters valid data
    And User clicks on Yalla button
    Then User verifies Success message
    And User quites browser

  @wrongPassword
  Scenario Outline: User can log in with valid email and wrong password
    Given User launches browser
    When User opens ilCarro Home Page
    And User clicks on Log in link
    And User enters valid email and wrong password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Yalla button
    Then User verifies Error message
    And User quites browser
    Examples:
      | email          | password     |
      | neuer+1@gm.com | Manuel12344  |
      | neuer+1@gm.com | manuel1234!  |
      | neuer+1@gm.com | MANUELl1234! |
      | neuer+1@gm.com | Manuelllll!  |


