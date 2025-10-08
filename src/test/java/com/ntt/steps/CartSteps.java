package com.ntt.steps;

import com.ntt.page.CartPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public CartSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Validar que el título de la página del carrito sea Carrito
     */
    public void validarTituloCarrito() {
        WebElement titulo = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.titleCart));
        String textoTitulo = titulo.getText().trim();
        Assertions.assertEquals("CARRITO", textoTitulo, "El título de la página no es el esperado. Se obtuvo: " + textoTitulo);
    }

    /**
     * Validar que el cálculo del carrito sea correcto:
     * (precio unitario × cantidad = total mostrado)
     */
    public void validarCalculoPreciosCarrito() {
        // Esperar que los elementos del carrito estén visibles
        WebElement precioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.precioCart));
        WebElement cantidadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.cantidadCart));
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(CartPage.totalCart));

        // Obtener los textos
        String precioTexto = precioElement.getText();
        String cantidadTexto = cantidadElement.getAttribute("value");
        String totalTexto = totalElement.getText();

        // Limpiar y convertir
        double precio = Double.parseDouble(
                precioTexto.replace("S/", "")
                        .replace("PEN", "")
                        .replace(",", ".")
                        .replaceAll("[^0-9.]", "")
                        .trim()
        );

        int cantidad = Integer.parseInt(cantidadTexto.replaceAll("\\D+", ""));

        double total = Double.parseDouble(
                totalTexto.replace("S/", "")
                        .replace("PEN", "")
                        .replace(",", ".")
                        .replaceAll("[^0-9.]", "")
                        .trim()
        );

        // Calcular total esperado
        double totalEsperado = precio * cantidad;
        org.junit.jupiter.api.Assertions.assertEquals(totalEsperado, total, 0.01, "El total del carrito no coincide con el cálculo (precio × cantidad)");
    }

}