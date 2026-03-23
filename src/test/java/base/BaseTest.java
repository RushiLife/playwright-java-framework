package base;

//@Listeners(TestListener.class)

import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.microsoft.playwright.Page;

import utils.ConfigReader;

@Listeners(listeners.TestListener.class)
public class BaseTest {

    protected Page page;
    protected Properties prop;

    @BeforeMethod
    public void setup() 
    {
        prop = ConfigReader.initProp();
        page = DriverFactory.initBrowser(prop.getProperty("browser"));
        page.navigate(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
    if (result.getStatus() != ITestResult.FAILURE) {
        DriverFactory.closeBrowser();
    }
    }
}