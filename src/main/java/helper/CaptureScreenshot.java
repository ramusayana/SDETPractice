package helper;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.apache.commons.io.FileUtils;

public class CaptureScreenshot {
	
	public String takeSnapShot() {
		
		Utilities utilities = new Utilities();
	    String screenshotFolderName = utilities.timestamp();
		
		TakesScreenshot scrShot = ((TakesScreenshot)PropertiesHelper.driver);
		String screenshotPath = System.getProperty("user.dir") + "/screenshots/screenshot" + screenshotFolderName + ".png";
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenshotPath;
	}
}
