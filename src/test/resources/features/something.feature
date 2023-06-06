@form
Feature: Form

  @smoke
  Scenario: As a user I am able to fill and submit the form
    Given I open the contact page
    And I reject the cookies
    And I open the form tab
    When I fill in the form fields with random data
    And I submit the form
    Then the form is submitted