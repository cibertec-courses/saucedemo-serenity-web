package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartPage extends  PageObject{
    private By cartIcon = By.cssSelector(".shopping_cart_link");
    private By cartItem = By.cssSelector(".cart_item");
    public void openCart(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        );
        find(cartIcon).click();
    }

    public boolean hasProducts(){
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(cartItem)
        );
        return  find(cartItem).isDisplayed();
    }
}
