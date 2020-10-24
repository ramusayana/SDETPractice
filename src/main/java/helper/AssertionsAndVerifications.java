package helper;

import java.io.IOException;

import org.testng.Assert;

import com.cucumber.listener.Reporter;

public class AssertionsAndVerifications {

	public static void assertNotEqual(Object actual, Object expected, String message, String cleanUpIfRequired) {
		try
		{
			Assert.assertNotEquals(actual, expected, message);
			Reporter.addStepLog("Pass: " + message);
		}
		catch(AssertionError e) 
		{
			CaptureScreenshot captureScreenshot = new CaptureScreenshot();
			
			String screenshot = captureScreenshot.takeSnapShot();	
			try {
				Reporter.addScreenCaptureFromPath(screenshot);
			} catch (IOException e1) {
				Reporter.addStepLog("Screenshot not found");
			}		
			Assert.fail("Fail: " + message);			
		}
	}	
	
	public static void assertEqual(Object actual, Object expected, String message, String cleanUpIfRequired) {
		try
		{
			Assert.assertEquals(actual, expected, "Assertion");
			Reporter.addStepLog("Pass: " + message);
		}
		catch(AssertionError e) 
		{
			CaptureScreenshot captureScreenshot = new CaptureScreenshot();
			
			String screenshot = captureScreenshot.takeSnapShot();	
			try {
				Reporter.addScreenCaptureFromPath(screenshot);
			} catch (IOException e1) {
				Reporter.addStepLog("Screenshot not found");
			}
			Assert.fail("Fail: " + message);			
		}
	}
	
	public static void assertContains(Object actual, Object expected, String message, String cleanUpIfRequired) {
		try
		{
			if(actual.toString().contains(expected.toString()) || expected.toString().contains(actual.toString()))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			Reporter.addStepLog("Pass: " + message);
		}
		catch(AssertionError e) 
		{
			CaptureScreenshot captureScreenshot = new CaptureScreenshot();
			
			String screenshot = captureScreenshot.takeSnapShot();	
			try {
				Reporter.addScreenCaptureFromPath(screenshot);
			} catch (IOException e1) {
				Reporter.addStepLog("Screenshot not found");
			}
			Assert.fail("Fail: " + message);			
		}
	}
	
}
