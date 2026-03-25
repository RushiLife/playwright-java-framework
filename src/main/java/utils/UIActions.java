package utils;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class UIActions {

    private Page page;


    public UIActions(Page page) {
        this.page = page;
    }

    // Resolve String or Locator
    private Locator resolve(Object target) {
        if (target instanceof String) {
            return page.locator((String) target);
        } else if (target instanceof Locator) {
            return (Locator) target;
        } else {
            throw new RuntimeException("Invalid locator type");
        }
    }

    // Navigate
    public void navigateTo(String url) {

        AllureUtil.step("Navigate to: " + url);
        LoggerUtil.info("Navigating to: " + url);

        page.navigate(url);
    }

    // Click
    public void click(Object target, String description) {

        AllureUtil.step("Click: " + description);
        LoggerUtil.info("Clicking: " + description);

        Locator locator = resolve(target);

        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(10000));

            locator.scrollIntoViewIfNeeded();
            locator.click();
            ScreenshotUtil.attach(page, description);

        } catch (Exception e) {
            throw new AssertionError("Failed to click: " + description, e); // 🔥 KEY FIX
        }
    }

    // Fill
    public void fill(Object target, String value, String description) {

        AllureUtil.step("Fill: " + description);
        LoggerUtil.info("Filling: " + description);

        Locator locator = resolve(target);

        try {
            locator.waitFor(new Locator.WaitForOptions()
                    .setState(WaitForSelectorState.VISIBLE)
                    .setTimeout(10000));

            locator.fill(value);
            ScreenshotUtil.attach(page, description);

        } catch (Exception e) {
            throw new AssertionError("Failed to fill: " + description, e);
        }
    }

    // Get Text
    public String getText(Object target, String description) {

        AllureUtil.step("Get Text: " + description);
        LoggerUtil.info("Getting text: " + description);

        Locator locator = resolve(target);

        locator.waitFor(new Locator.WaitForOptions()
                .setState(WaitForSelectorState.VISIBLE)
                .setTimeout(20000));

        return locator.innerText().trim();
    }

    // Is Visible
    public boolean isVisible(Object target) {
        return resolve(target).isVisible();
    }

}
