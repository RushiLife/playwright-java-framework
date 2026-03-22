package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class CartPage {
    
    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean isCartDisplayed() {

        Locator title = page.locator("h2:has-text('Shopping Cart')");

        title.waitFor(new Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(10000));
        
        return title.first().isVisible();
    }

    public boolean getCartSubTotalSection() {
        Locator cartSection = page.locator("#sw-subtotal-item-count");

        cartSection.waitFor(new Locator.WaitForOptions()
            .setState(WaitForSelectorState.VISIBLE)
            .setTimeout(10000));

        return cartSection.first().isVisible();
    }
/*
    public String getSubtotalPrice() {
        String subTotal = page.locator("span.a-price-whole").first().innerText();
        String subTotalPrice = subTotal.replaceAll("[^0-9]", "");
        return subTotalPrice;
    }
*/
    public int getSubtotalPrice() {
    String text = page.locator("span.a-price-whole").first().innerText();
    return Integer.parseInt(text.replaceAll("[^0-9]", ""));
    }

    public String getProductName() {
        return page.locator(".sc-product-title").first().innerText();
    }

    public String getQuantity() {
        String text = page.locator("#sc-subtotal-label-activecart").innerText();
        String number = text.replaceAll("[^0-9]", "");
        return number;
    }
    //span.a-dropdown-prompt
}
