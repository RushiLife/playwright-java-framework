package pages;

import com.microsoft.playwright.*;

import locators.HomePageLocators;
import utils.UIActions;

public class HomePage {

    private UIActions ui;

    public HomePage(Page page) {
        this.ui = new UIActions(page);
    }

    public void searchProduct(String productName) {

        ui.fill(HomePageLocators.SEARCH_INPUT, productName, "Enter Product Name " + productName);
        ui.click(HomePageLocators.SEARCH_BUTTON, "Click On Search Button");
        ui.isVisible(productName);
    }
}
