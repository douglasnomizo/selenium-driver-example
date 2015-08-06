Feature: Gradle Cucumber integration

  Scenario: Yet another Scenario
    Given I am on Google home page
    When I search for "Mafagafo"
    Then the page title should contain "Mafagafo"