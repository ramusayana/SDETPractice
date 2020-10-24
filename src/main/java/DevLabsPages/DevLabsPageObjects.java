package DevLabsPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import helper.PropertiesHelper;

public class DevLabsPageObjects {
	public DevLabsPageObjects() {
		PageFactory.initElements(PropertiesHelper.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//SPAN[text()='Alert']")
	public WebElement alertButton;
	
	@FindBy(how = How.NAME, using = "zxcvbnm")
	public WebElement confirmButton;
	
	
}
