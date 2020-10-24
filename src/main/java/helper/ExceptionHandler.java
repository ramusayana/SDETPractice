package helper;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

public class ExceptionHandler extends RuntimeException{
	public ExceptionHandler(Exception ex)  {
		
		CaptureScreenshot captureScreenshot = new CaptureScreenshot();
		
		System.out.println("Exception raised");
		ex.printStackTrace();
		String screenshot = captureScreenshot.takeSnapShot();
		PropertiesHelper.driver.quit();
		Reporter.addStepLog("Exception : " + ex.toString());
		try {
			Reporter.addScreenCaptureFromPath(screenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Reporter.addStepLog("Screenshot not found");
		}
	}
}
