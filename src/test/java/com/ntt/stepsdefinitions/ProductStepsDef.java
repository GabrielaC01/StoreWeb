package com.ntt.stepsdefinitions;

import com.ntt.steps.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.ntt.core.DriverManager.getDriver;
import static com.ntt.core.DriverManager.screenShot;

public class ProductStepsDef {
    private WebDriver driver;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.clickIcon();
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
        // Verificamos si hay mensaje de error
        String mensajeError = loginSteps.getErrorMessage();
        if (!mensajeError.isEmpty()) {
            System.out.println("Error de autenticación detectado: " + mensajeError);
            org.junit.jupiter.api.Assertions.assertEquals("Error de autenticación.", mensajeError, "El mensaje de error no es el esperado");
            org.junit.jupiter.api.Assumptions.assumeTrue(false, "Login inválido, se detiene el flujo");
        }
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subcategoria) {
        HomeSteps homeSteps = new HomeSteps(driver);
        homeSteps.seleccionarCategoria(categoria);
        homeSteps.seleccionarSubcategoria(subcategoria);
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        ProductSteps productSteps = new ProductSteps(driver);
        productSteps.agregarProducto(cantidad);
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        PopupSteps popupSteps = new PopupSteps(driver);
        popupSteps.validarMensajeConfirmacion();
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        PopupSteps popupSteps = new PopupSteps(driver);
        popupSteps.validarCalculoTotalPopup();
        screenShot();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        PopupSteps popupSteps = new PopupSteps(driver);
        popupSteps.finalizarCompra();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validarTituloCarrito();
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
        CartSteps cartSteps = new CartSteps(driver);
        cartSteps.validarCalculoPreciosCarrito();
        screenShot();
    }
}
