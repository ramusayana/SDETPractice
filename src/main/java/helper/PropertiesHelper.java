package helper;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class PropertiesHelper {	

	private static  Map<String, Object> scenarioContext;
	
	public static WebDriver driver;
	//public static HelperModules helperModules;
	//public static SoftAssert softAssert;
	public PropertiesHelper(){
		scenarioContext = new HashMap<>();
		//helperModules = new HelperModules(driver);
		//softAssert = new SoftAssert();
	}
	
    public static void setContext(String key, Object value) {
        scenarioContext.put(key, value);
    }
    public static Object getContext(String key){
        return scenarioContext.get(key);
    }
    public static Boolean isContains(String key){
        return scenarioContext.containsKey(key);
    }
}
