package runner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import helper.Utilities;

@CucumberOptions(
        plugin = { "pretty","com.cucumber.listener.ExtentCucumberFormatter:","json:target/cucumber.json"}, 
        glue = "stepDefinition", 
        features = "src/test/resources/features/",
                tags={"@Alert"},
         monochrome = true)
public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;	
	ExtentReports extent;
	ExtentTest logger;
	public static String reportFolderName;
	
	@BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		Utilities utilities = new Utilities();
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    reportFolderName = utilities.timestamp();
	    File reportDirectory = new File(System.getProperty("user.dir") + "/target/cucumber-reports/" + "Extent Report_" +reportFolderName);
	    extentProperties.setReportPath(reportDirectory + "/report.html");
    }	
	
    @Test(description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }
 
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
 
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        Reporter.loadXMLConfig(new File("config/report.xml"));  
    }
	
}
