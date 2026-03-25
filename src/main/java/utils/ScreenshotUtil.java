package utils;

import java.io.ByteArrayInputStream;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.ScreenshotAnimations;

import io.qameta.allure.Allure;

public class ScreenshotUtil {

    public static void attach(Page page, String stepName) {
        try {

            page.waitForLoadState(LoadState.DOMCONTENTLOADED);

            byte[] screenshot = page.screenshot(
                    new Page.ScreenshotOptions()
                            .setTimeout(3000)
                            .setFullPage(false)
                            .setAnimations(ScreenshotAnimations.DISABLED)
            );

            Allure.addAttachment(
                    stepName,
                    "image/png",
                    new ByteArrayInputStream(screenshot),
                    ".png"
            );

        } catch (Exception e) {
            System.out.println("Step screenshot failed: " + e.getMessage());
        }
    }
}
