package com.ntt.page;

import org.openqa.selenium.By;

public class LoginPage {

    //Localizadores de elementos
    public static By iconInicio = By.xpath("//div[@class='user-info']//span[text()='Iniciar sesión']");
    public static By userInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By loginError = By.xpath("//li[@class='alert alert-danger']");
    public static By loginExito = By.cssSelector("a.logout.hidden-sm-down[href*='mylogout']");
}
