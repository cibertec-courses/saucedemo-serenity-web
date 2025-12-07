package com.testing.steps;

import com.testing.pages.*;
import io.cucumber.java.en.*;

import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class CartSteps {

    @Managed
    WebDriver driver;

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    MenuPage menuPage;

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

    @When("accede al carrito")
    public void  accedeAlCarrito(){
        cartPage.openCart();
    }

    @Then("debe ver el producto agregado en el carrito")
    public  void debeVerElProductoAgregadoEnelCarrito(){
        assertTrue(cartPage.hasProducts());
    }

    @When("procede al checkout")
    public void procedeAlCheckout(){
        checkoutPage.clickCheckout();
    }

    @When("completa el formulario con nombre {string} apellido {string} y codigo postal {string}")
    public void completaElFormulario(String nombre, String apellido, String codigoPostal){
        checkoutPage.fillForm(nombre, apellido, codigoPostal);
    }

    @When("finaliza la compra")
    public void finalizaLaCompra(){
        checkoutPage.finishCheckout();
    }

    @Then("debe ver el mensaje de confirmacion {string}")
    public void debeVerElMensajeDeConfirmacion(String mensaje){
        assertEquals(mensaje, checkoutPage.getConfirmationMessage());
    }

    @When("abre el menu lateral")
    public void abreElMenuLateral(){
        menuPage.openMenu();
    }

    @When("hace click en logout")
    public void haceClickEnLogout(){
        menuPage.clickLogout();
    }

    @Then("debe ver la pagina de login")
    public void debeVerLaPaginaDeLogin(){
        assertTrue(loginPage.isDisplayed());
    }

}
