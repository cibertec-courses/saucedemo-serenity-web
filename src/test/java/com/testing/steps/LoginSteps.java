package com.testing.steps;


import com.testing.pages.LoginPage;
import com.testing.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    @Managed
    WebDriver driver;


    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("el usuario esta en la pagina de login")
    public void elUsuarioEstaEnLaPaginaDeLogin(){
        loginPage.openPage();
    }

    @When("ingresa el usuario {string}")
    public void ingresElUsuario(String username){
        loginPage.enterUserName(username);
    }

    @And("ingresar la contraseña {string}")
    public void ingresaLaContrasena(String password){
        loginPage.enterPassword(password);
    }

    @And("hace clic en el boton login")
    public void haceClicEnBotonLogin(){
        loginPage.clickLogin();
    }

    @Then("debe ver la pagina de productos")
    public  void debeVerLaPaginaDeProductos (){
        assertTrue(productsPage.isDisplayed());
    }

    @Then("debe ver el mensaje de error {string}")
    public void debeVerElMensajeDeError(String mensajeEsperado){
        String mensajeActual = loginPage.getErrorMessage();
        assertTrue(mensajeActual.contains(mensajeEsperado) || mensajeActual.equals(mensajeEsperado));
    }

}
