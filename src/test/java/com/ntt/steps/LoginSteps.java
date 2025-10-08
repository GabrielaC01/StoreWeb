package com.ntt.steps;

import com.ntt.page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private WebDriver driver;

    //constructor
    public LoginSteps(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Hacer click en el icono
     */
    public void clickIcon(){
        this.driver.findElement(LoginPage.iconInicio).click();
    }

    /**
     * Escribir el usuario
     * @param user el usuario
     */
    public void typeUser(String user){
        WebElement userInputElement = driver.findElement(LoginPage.userInput);
        userInputElement.sendKeys(user);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }

    /**
     * Escribir el password
     * @param password el password del usuario
     */
    public void typePassword(String password){
        this.driver.findElement(LoginPage.passInput).sendKeys(password);
    }

    /**
     * Hacer click en el botón login
     */
    public void login() {
        driver.findElement(LoginPage.loginButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(LoginPage.loginExito));
            wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginExito));
            System.out.println("Login exitoso");
        } catch (Exception e) {
            System.out.println("Login fallido");
        }
    }

    /**
     * Retorna el mensaje de error si el login falla
     */
    public String getErrorMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginError));
            return errorElement.getText().trim();
        } catch (Exception e) {
            return "";
        }
    }

}
