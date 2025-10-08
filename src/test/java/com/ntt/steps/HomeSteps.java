package com.ntt.steps;

import com.ntt.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomeSteps(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    /**
     * Navegar a una categoría
     * @param categoria nombre de la categoría
     */
    public void seleccionarCategoria(String categoria) {
        try {
            if (!categoria.equalsIgnoreCase("Clothes")) {
                org.junit.jupiter.api.Assertions.fail("La categoría '" + categoria + "' no existe en la tienda");
            }
            WebElement categoriaElement = wait.until(ExpectedConditions.elementToBeClickable(HomePage.category));
            categoriaElement.click();

        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail("Ocurrió un error al intentar seleccionar la categoría: " + categoria);
        }
    }

    /**
     * Navegar a una subcategoría
     * @param subcategoria nombre de la subcategoría
     */
    public void seleccionarSubcategoria(String subcategoria) {
        try {
            if (!subcategoria.equalsIgnoreCase("Men")) {
                org.junit.jupiter.api.Assertions.fail("La subcategoría '" + subcategoria + "' no existe en la tienda");
            }
            WebElement subcategoriaElement = wait.until(ExpectedConditions.elementToBeClickable(HomePage.subcategory));
            subcategoriaElement.click();
        } catch (Exception e) {
            org.junit.jupiter.api.Assertions.fail("Ocurrió un error al intentar seleccionar la subcategoría: " + subcategoria);
        }
    }

}
