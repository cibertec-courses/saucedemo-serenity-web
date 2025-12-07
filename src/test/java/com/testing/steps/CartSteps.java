package com.testing.steps;

import com.testing.pages.LoginPage;
import com.testing.pages.ProductsPage;
import io.cucumber.java.en.*;

import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {

    @Managed
    WebDriver driver;

    LoginPage loginPage;
    ProductsPage productsPage;

    @Given("el usuario ha iniciado sesion con las credenciales validas")
    public void elUsuarioHaIniciadoSesionConLasCredencialesValidad(){
        loginPage.openPage();
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("agrega el primer producto en el carrito")
    public void agregaElPrimerProductoAlCarrito() {
        productsPage.addFirstProductoToCart();
    }

    @Then("el contador del carrito debe mostrar {int}")
    public void elContadorDelCarritoDebeMostrar(int cantidad){
        assertEquals(cantidad, productsPage.getCartCount());
    }
}
