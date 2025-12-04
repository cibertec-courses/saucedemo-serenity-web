package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {

    private By productsTitle = By.className("title");

    public boolean isDisplayed() {
        return $(productsTitle).isDisplayed();
    }

    public String getTitle() {
        return $(productsTitle).getText();
    }
}