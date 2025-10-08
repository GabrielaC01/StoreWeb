package com.ntt.steps;

import com.ntt.page.PopupPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopupSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    public PopupSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Validar que el mensaje del popup confirme la adición al carrito
     */
    public void validarMensajeConfirmacion() {
        // Espera a que el mensaje del popup sea visible
        WebElement mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.messagePopup));
        String textoMensaje = mensaje.getText();
        Assertions.assertTrue(
                textoMensaje.contains("Producto añadido correctamente"), "El mensaje del popup no es el esperado. Se obtuvo: " + textoMensaje
        );
    }

    /**
     * Validar que el monto total en el popup sea calculado correctamente
     * (precio unitario × cantidad = total)
     */
    public void validarCalculoTotalPopup() {
        // Esperar que los elementos estén visibles
        WebElement precioElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.precioPopup));
        WebElement cantidadElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.cantPopup));
        WebElement totalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(PopupPage.totalPopup));

        // Obtener los textos
        String precioTexto = precioElement.getText();
        String cantidadTexto = cantidadElement.getText();
        String totalTexto = totalElement.getText();

        // Limpiar y convertir los valores correctamente
        double precio = Double.parseDouble(
                precioTexto.replace("S/", "")
                        .replace("PEN", "")
                        .replace(",", ".")
                        .replaceAll("[^0-9.]", "")  // elimina cualquier carácter no numérico
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

        // Calcular el total esperado
        double totalEsperado = precio * cantidad;
        org.junit.jupiter.api.Assertions.assertEquals(totalEsperado, total, 0.01, "El total mostrado en el popup no coincide con el cálculo esperado");
    }

    /**
     * Hace clic en el botón Finalizar compra
     */
    public void finalizarCompra() {
        WebElement botonFinalizar = wait.until(ExpectedConditions.elementToBeClickable(PopupPage.finishCompra));
        botonFinalizar.click();
    }
}
