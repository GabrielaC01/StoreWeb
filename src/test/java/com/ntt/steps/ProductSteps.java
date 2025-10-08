package com.ntt.steps;

import com.ntt.page.ProductsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ProductSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Agregar producto al carrito con la cantidad indicada
     * @param cantidad número de unidades a agregar
     */
    public void agregarProducto(int cantidad) {
        // Hacer clic en el primer producto que aparece
        WebElement producto = wait.until(ExpectedConditions.elementToBeClickable(ProductsPage.itemProduct));
        producto.click();

        // Esperar el campo de cantidad y escribir el valor
        WebElement cantidadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductsPage.cantProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='';", cantidadInput);
        cantidadInput.sendKeys(String.valueOf(cantidad));

        // Hacer clic en el botón "Añadir al carrito"
        WebElement botonAgregar = wait.until(ExpectedConditions.elementToBeClickable(ProductsPage.addProduct));
        botonAgregar.click();
    }
}
