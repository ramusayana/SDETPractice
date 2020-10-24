@Demo
Feature: User wants to accept alert and then validate title of the web page

@Alert 
Scenario: Test scenario
	Given User launches the URL "url"
	When User clicks on Alert button
	And User clicks on Confirm button
	And User accepts the Alert
	Then User verifies the title of the web page
	
@Alert 
Scenario: Test scenario
	Given User launches the URL "url"
	When User clicks on Alert button
	And User clicks on Confirm button
	And User accepts the Alert
	Then User verifies the title of the web page