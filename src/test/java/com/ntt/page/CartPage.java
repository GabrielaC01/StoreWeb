package com.ntt.page;

import org.openqa.selenium.By;

public class CartPage {
    public static By titleCart = By.cssSelector("h1.h1");
    public static By precioCart = By.cssSelector("span.price");
    public static By cantidadCart = By.cssSelector("input.js-cart-line-product-quantity");
    public static By totalCart = By.cssSelector("span.product-price strong");
}
