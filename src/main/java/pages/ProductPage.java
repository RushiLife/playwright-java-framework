package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

import utils.webReausableMethods;

public class ProductPage {

    private Page page;

    private String quantityDropdown = "#quantity";
    private String addToCartBtn = "#add-to-cart-button";

    public ProductPage(Page page) {
        this.page = page;
    }

    public void goToCart() {
        page.click("text=Go to Cart");
    }

    public boolean isProductPageDisplayed() {
        Locator title = page.locator("span#productTitle");

        title.waitFor(new Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(10000));

        return title.first().isVisible();
    }

    public void selectQuantity(String qty) throws InterruptedException {
        Locator quantityLocator = page.locator(quantityDropdown);
        quantityLocator.scrollIntoViewIfNeeded();
        Thread.sleep(3000);
        page.selectOption(quantityDropdown, qty);
        page.waitForFunction(
        "document.querySelector('#quantity').value === '2'"
        );
    }

    public void clickAddToCart() {
        Locator btn = page.locator(addToCartBtn);
        btn.scrollIntoViewIfNeeded();
        page.click(addToCartBtn);
    }
}
