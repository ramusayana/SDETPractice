package stepDefinition.Alert;

import static org.testng.Assert.assertEquals;

import DevLabsPages.DevLabsPageObjects;
import cucumber.api.java.en.Given;
import helper.AssertionsAndVerifications;
import helper.Operations;

public class AlertStepDefinition extends Operations{
	
	@Given("^User launches the URL \"([^\"]*)\"$")
	public void user_launches_the_URL(String url) throws Throwable {
		openURL(url);
	}
	
	@Given("^User clicks on Alert button$")
	public void user_Clicks_on_alert_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DevLabsPageObjects devLabsPageObjects = new DevLabsPageObjects();
		Clicks(devLabsPageObjects.alertButton);

	}

	@Given("^User clicks on Confirm button$")
	public void user_clicks_on_Confirm_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		DevLabsPageObjects devLabsPageObjects = new DevLabsPageObjects();
		Clicks(devLabsPageObjects.confirmButton);
	}
	
	@Given("^User accepts the Alert$")
	public void user_accepts_Alert() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ClickAlertOkButton();
	}
	
	@Given("^User verifies the title of the web page$")
	public void user_clicks_on_Review_and_confirm_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(title(), "Alert - LetCode");
		AssertionsAndVerifications.assertEqual(title(), "Alert - LetCode", "Verifying title page", null);
	}

}
