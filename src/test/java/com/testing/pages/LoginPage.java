package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");


    public void openPage(){
        getDriver().get("https://www.saucedemo.com/");
    }

    public void enterUserName(String username){
        $(usernameField).type(username);
    }

    public void enterPassword(String password){
        $(passwordField).type(password);
    }

    public void clickLogin(){
        $(loginButton).click();
    }

    public String getErrorMessage(){
        return $(errorMessage).getText();
    }

    public boolean isDisplayed() {
        return find(loginButton).isDisplayed();
    }
}
