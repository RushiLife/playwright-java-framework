package base;

//@Listeners(TestListener.class)

import java.util.Properties;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;

import utils.ConfigReader;

public class BaseTest {

    protected Page page;
    protected Properties prop;
    
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chromium")String browser) 
    {
        prop = ConfigReader.initProp();
        page = DriverFactory.initBrowser(browser);
        page.navigate(prop.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
    if (result.getStatus() != ITestResult.FAILURE) {
        DriverFactory.closeBrowser();
    }
    }
}