package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends PageObject {

    private By productsTitle = By.className("title");
    private By addToCartButton = By.cssSelector(".inventory_item:first-child .btn_inventory");
    private By cartBadge = By.cssSelector(".shopping_cart_badge");



    public boolean isDisplayed() {
        return $(productsTitle).isDisplayed();
    }

    public String getTitle() {
        return $(productsTitle).getText();
    }

    public void addFirstProductoToCart(){
       find(addToCartButton).click();
    }

    public int getCartCount(){
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge)
        );
        return  Integer.parseInt(find(cartBadge).getText());
    }


}