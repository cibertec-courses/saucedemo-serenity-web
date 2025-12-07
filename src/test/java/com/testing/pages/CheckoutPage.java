package com.testing.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageObject {

    private By checkoutButton = By.id("checkout");
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public void clickCheckout(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(checkoutButton)
        );
        find(checkoutButton).click();
    }

    public void fillForm(String firstName, String lastName, String postalCode){
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(firstNameField)
        );
        find(firstNameField).sendKeys(firstName);
        find(lastNameField).sendKeys(lastName);
        find(postalCodeField).sendKeys(postalCode);
        find(continueButton).click();
    }

    public void finishCheckout(){
        waitForCondition().until(
                ExpectedConditions.elementToBeClickable(finishButton)
        );
        find(finishButton).click();
    }

    public  String getConfirmationMessage(){
        waitForCondition().until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMessage)
        );
        return  find(confirmationMessage).getText();
    }


}
