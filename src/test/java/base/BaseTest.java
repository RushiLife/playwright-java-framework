package base;

//@Listeners(TestListener.class)

import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class BaseTest {

    protected Page page;
    protected Properties prop;

    @BeforeMethod
    public void setup() 
    {
        page = DriverFactory.initBrowser("chromium");
        page.navigate("https://www.amazon.in/");
    }

    @Test
    public void loginTest()
    {
        System.out.println("Launch amozon");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.closeBrowser();
    }
}