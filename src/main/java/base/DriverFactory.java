package base;

import com.microsoft.playwright.*;

public class DriverFactory {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> context = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static Page initBrowser(String browserName) {

        playwright.set(Playwright.create());

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(false);

        switch (browserName.trim().toLowerCase()) {

            case "chromium":
                browser.set(playwright.get().chromium().launch(options));
                break;

            case "firefox":
                browser.set(playwright.get().firefox().launch(options));
                break;

            case "webkit":
                browser.set(playwright.get().webkit().launch(options));
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browserName);
        }

        context.set(browser.get().newContext());
        page.set(context.get().newPage());

        return page.get();
    }

    public static Page getPage() {
        return page.get();
    }

    public static void closeBrowser() {

        if (page.get() != null) page.get().close();
        if (context.get() != null) context.get().close();
        if (browser.get() != null) browser.get().close();
        if (playwright.get() != null) playwright.get().close();

        page.remove();
        context.remove();
        browser.remove();
        playwright.remove();
    }
}