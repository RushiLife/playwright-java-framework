package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class ProductPage {

    private Page page;

    private String quantityDropdown = "#quantity";
    private String addToCartBtn = "#add-to-cart-button";

    public ProductPage(Page page) {
        this.page = page;
    }

    public boolean isProductPageDisplayed() {
        Locator title = page.locator("span#productTitle");

        title.waitFor(new Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(10000));
            
        return title.first().isVisible();
    }

    public void selectQuantity(String qty) {
        Locator loc = page.locator(quantityDropdown);
        loc.scrollIntoViewIfNeeded();
        page.selectOption(quantityDropdown, qty);
    }

    public void clickAddToCart() {
        page.click(addToCartBtn);
    }
}
