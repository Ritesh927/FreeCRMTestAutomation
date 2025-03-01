Feature: Free CRM Login Feature

  Scenario: Free CRM Login Test Scenario
    Given user is already on login page
    When title of login page is FREE CRM
    Then user enters username and password
    And clicks on login button
    And user is on login page
