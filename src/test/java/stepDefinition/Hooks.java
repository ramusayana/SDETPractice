package stepDefinition;

import java.io.File;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.Operations;
import runner.TestRunner;

public class Hooks extends Operations{
	ATUTestRecorder recorder;
	
	@Before
	public void BeforeSteps(Scenario scenario) throws ATUTestRecorderException {
		System.out.println("Scenario name : " + scenario.getName());
	    File reportDirectory = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + "Extent Report_" +TestRunner.reportFolderName); 
		recorder = new ATUTestRecorder(reportDirectory.toString(),scenario.getName(),false);
		recorder.start();
		openBrowser();
	 }
	 
	 @After
	public void AfterSteps() throws ATUTestRecorderException {
		 driverQuit();
	 }
}