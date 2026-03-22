package base;

//@Listeners(TestListener.class)

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

import utils.ConfigReader;

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

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}