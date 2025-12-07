package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends PageObject {

    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public void openMenu(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(menuButton)
        );
        find(menuButton).click();
    }

    public void clickLogout(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(logoutButton)
        );
        find(logoutButton).click();
    }
}
