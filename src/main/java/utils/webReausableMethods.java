package utils;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class webReausableMethods {

    public static int extractPrice(String text) {
    return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public static byte[] capture(Page page) {
        try {
            page.waitForLoadState(LoadState.DOMCONTENTLOADED);

            return page.screenshot(new Page.ScreenshotOptions()
                    .setTimeout(5000)
                    .setFullPage(true));

        } catch (Exception e) {
            System.out.println("Screenshot failed: " + e.getMessage());
            return new byte[0];
        }
    }
    
}
