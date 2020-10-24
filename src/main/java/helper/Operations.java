package helper;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

public class Operations {
	
	public static String winHandleBefore ;
	
	public void ExplicitWait(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(PropertiesHelper.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void highlightElement(WebElement element) {
        for (int i = 0; i <2; i++) 
        {

        }}
	
	//SET METHODS
	
    // Enter Text 
    public void EnterText(WebElement element, String value)
    {
        try {
        	highlightElement(element);
        	element.sendKeys(value);
        }catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    // Enter Keyboard's key 
    public void KeyboardKey(WebElement element, Keys key, int numberOfTimes)
    {
    	try {
    		for(int i = 0; i < numberOfTimes; i++)
    		{
    			highlightElement(element);
    			element.sendKeys(key);
    		}
    	}catch (Exception e) {
    		System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

 // Enter Keyboard's key 
    public void KeyboardKeySequence(WebElement element, String key, int numberOfTimes)
    {
    	try {
    		for(int i = 0; i < numberOfTimes; i++)
    		{
    			highlightElement(element);
    			element.sendKeys(key);
    		}
    	}catch (Exception e) {
    		System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    // Click a Checkbox, Button , Option etc
    public void Clicks(WebElement element)
    {
    	try {  
    		//MoveToElement(element);
    		//highlightElement(element);
    		element.click();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

    // Move To Element
    public  void MoveToElement(WebElement element)
    {
    	try {
			/*
			 * Actions actions = new Actions(PropertiesHelper.driver);
			 * actions.moveToElement(element); actions.perform();
			 */
    		JavascriptExecutor je = (JavascriptExecutor)PropertiesHelper.driver;
    		je.executeScript("arguments[0].scrollIntoView(true);",element);
    		highlightElement(element);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //Switch to frame 
    public void SwitchToFrame(String frameName)
    {
    	try {
    		PropertiesHelper.driver.switchTo().frame(frameName);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //switch back to default frame
    public void SwitchBackToDefaultFrame() 
    {
    	try {
    		PropertiesHelper.driver.switchTo().parentFrame();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }    
    
    // Selecting a drop down control by index
    public void SelectDropDownByText(WebElement element, String value)
    {
    	try {
    		highlightElement(element);
    		new Select(element).selectByVisibleText(value);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
		}
    }
    
    // Selecting a drop down control by index
    public void SelectDropDownByIndex(WebElement element, int index)
    {
    	try {
    		highlightElement(element);
    		new Select(element).selectByIndex(index);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
		}
    }

    // open URL
    public void openURL(String url)
    {		
    	try {
    		PropertiesHelper.driver.get(readConfigFile(url));
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    // Return Page title
    public String title()
    {		
    	try {
    		return PropertiesHelper.driver.getTitle();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }  
    
    // open Browser
    public void openBrowser()
    {		
    	try {    	    
    		
	    	if(readConfigFile("browser").equalsIgnoreCase("chrome"))
	    	{
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
				PropertiesHelper.driver = new ChromeDriver();
			    
	    	}
	    	else if (readConfigFile("browser").equalsIgnoreCase("firefox")) 
	    	{
	    		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");				
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);				 
	    		PropertiesHelper.driver = new FirefoxDriver(capabilities);
			}
	    	else if (readConfigFile("browser").equalsIgnoreCase("internetexplorer")) 
	    	{
	    		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    		capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
	    		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	    		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
	    		capabilities.setCapability("allow-blocked-content", true);
	    		capabilities.setCapability("allowBlockedContent", true);
	    		capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
	    		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer.exe");
	    		PropertiesHelper.driver = new InternetExplorerDriver(capabilities);	    		
			}
	    	PropertiesHelper helper = new PropertiesHelper();
	    	helper.driver.manage().window().maximize();
	    	helper.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    	initializePages();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
	public void initializePages() {
		final ClassPathScanningCandidateComponentProvider provider = new ClassPathScanningCandidateComponentProvider(
				false);
		provider.addIncludeFilter(new RegexPatternTypeFilter(Pattern.compile(".*")));

		final Set<BeanDefinition> classes = provider.findCandidateComponents("AbsenceAndTimePages");

		for (BeanDefinition bean : classes) {
			Class<?> clazz;
			try {
				clazz = Class.forName(bean.getBeanClassName());
				clazz.newInstance();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
    
    // closes driver
    public void driverQuit()
    {		
    	try {
    		PropertiesHelper.driver.quit();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    // closes current broswer
    public void CloseCurrentBrowser()
    {		
    	try {
    		PropertiesHelper.driver.close();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //switch to newly opened window
    public void switchToNewlyOpenedWindow()
    {
    	try {
	    	winHandleBefore = PropertiesHelper.driver.getWindowHandle();
	    	for(String winHandle : PropertiesHelper.driver.getWindowHandles())
	    	{
	    		PropertiesHelper.driver.switchTo().window(winHandle);
	    	}
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //switch back to the previously opened window
    public void switchToPreviouslyOpenedWindow()
    {
    	try {
    		PropertiesHelper.driver.switchTo().window(winHandleBefore);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //switch to parent window
    public void switchToParentWindow()
    {
    	try {
	    	for(String winHandle : PropertiesHelper.driver.getWindowHandles())
	    	{
	    		PropertiesHelper.driver.switchTo().window(winHandle);
	    	}
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //Clears
    public void Clears(WebElement element)
    {
    	try {
    		highlightElement(element);
    		element.clear();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

    //Explicit time wait
    public void waits(int time) 
    {
        try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new ExceptionHandler(e);
		}
    }

    // JavaScript scroll to bottom
    public void scrollToBottom()
    {
    	try {
	        JavascriptExecutor js = (JavascriptExecutor)PropertiesHelper.driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //Switch to Alert and write a text
    public void switchToAlertWriteText(String value)
    {
    	try {	    	
	    	PropertiesHelper.driver.switchTo().alert().sendKeys(value);	    	
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //Switch to Alert and Accept
    public void ClickAlertOkButton()
    {
    	try {
	    	
	    	PropertiesHelper.driver.switchTo().alert().accept();
	    	
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }


    // Read Config file    
    public static String readConfigFile(String columnName)
    {
    	Properties prop = new Properties();
    	try {
			InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config/config.properties");
			prop.load(input);
			return prop.getProperty(columnName);
		} catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}    	    
    }
    
    // JavaScript scroll to postion      
    public void scrollToPosition(int length, int width)
    {
    	try {
	    	JavascriptExecutor js = (JavascriptExecutor)PropertiesHelper.driver;
	        js.executeScript("window.scrollTo(length, width);");
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //GET METHODS
    
    //Getting innertext of a Web Element
    public String GetText(WebElement element)
    {
    	try {
    		highlightElement(element);
    		return element.getText();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

  //To check if a Web Element is displayed on  screen
    public boolean isDisplayed(WebElement element)
    {
    	try {
    		highlightElement(element);
    		return element.isDisplayed();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

    
    //Getting Value of a Web Element
    public String GetValue(WebElement element, String attribute)
    {
    	try {
    		highlightElement(element);
    		return element.getAttribute(attribute);
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }

    //Getting first option from the drop down list
    public String GetTextFromDDL(WebElement element)
    {
    	try {
    		highlightElement(element);
    		return new Select(element).getAllSelectedOptions().get(0).getText();
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }
    
    //returns list of webelements
    public ArrayList<String> ListOfWebElements(List<WebElement> listOfElements)
    {
    	try {
	    	ArrayList<String> list = new ArrayList<String>();
			for(WebElement webElement : listOfElements)
			{
				list.add(GetText(webElement));
			}
			return list;
    	}catch (Exception e) {
			System.out.println("Exception Caught");
			throw new ExceptionHandler(e);
		}
    }  
}