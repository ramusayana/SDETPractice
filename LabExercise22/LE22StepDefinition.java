package stepDefinition.LabExercise22;

import DevLabsPages.DbankdemoPages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.AssertionsAndVerifications;
import helper.Operations;

public class LE22StepDefinition extends Operations{
	
	DbankdemoPages dbankdemoPages = new DbankdemoPages();
	
	@When("^Enter the user name \"([^\"]*)\"$")
	public void enter_the_user_name(String user) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    EnterText(dbankdemoPages.username, readConfigFile(user));
	}

	@When("^Enter the password \"([^\"]*)\"$")
	public void enter_the_password(String password) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		EnterText(dbankdemoPages.password, readConfigFile(password));
	}

	@When("^Click on Remeber-me$")
	public void click_on_Remeber_me() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    Clicks(dbankdemoPages.rememberMe);
	}

	@When("^Click on sign-in button$")
	public void click_on_sign_in_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Clicks(dbankdemoPages.signInButton);
	}

	@Then("^Then user asserts the title of the web page$")
	public void then_user_asserts_the_title_of_the_web_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		AssertionsAndVerifications.assertEqual(title(), "Digital Bank", "Verifying title page", null);
	}

}
