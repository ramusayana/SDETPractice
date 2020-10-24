Feature: Testing GooglePage Title

@PositiveScenario
Scenario: We are verifying google page title
    Given User launches the URL "url"
    When User searches for Jave in the input box
    When User clicks on search button
    Then User verifies the title page
    