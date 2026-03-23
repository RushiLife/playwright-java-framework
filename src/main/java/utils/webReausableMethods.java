package utils;

import java.io.ByteArrayInputStream;

import com.microsoft.playwright.Page;

import base.DriverFactory;
import io.qameta.allure.Allure;

public class webReausableMethods {

    public static int extractPrice(String text) {
    return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public static void attachScreenshot(String name) {
        Page page = DriverFactory.getPage();
        if (page != null) {
            Allure.addAttachment(name,
                    new ByteArrayInputStream(page.screenshot()));
        }
    }
    
}
