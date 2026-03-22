package base;

import com.microsoft.playwright.*;


public class DriverFactory {    

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page initBrowser(String browserName) {

        playwright.set(Playwright.create());

        browser.set(
            playwright.get().chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
            )
        );

        page.set(browser.get().newContext().newPage());

        return page.get();
    }

    public static Page getPage() {
        return page.get();
    }
 
    public static void closeBrowser() {
        page.get().context().browser().close();
        playwright.get().close();
    }    
}