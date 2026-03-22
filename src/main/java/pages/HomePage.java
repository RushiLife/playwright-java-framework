package pages;

import com.microsoft.playwright.*;

public class HomePage {

    private Page page;

    private String searchBox = "#twotabsearchtextbox";
    private String searchButton = "#nav-search-submit-button";

    public HomePage(Page page) {
        this.page = page;
    }

    public void searchProduct(String productName) {
        page.fill(searchBox, productName);
        page.click(searchButton);
    }
}
