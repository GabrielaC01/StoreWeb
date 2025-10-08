package com.ntt.page;

import org.openqa.selenium.By;

public class PopupPage {
    public static By messagePopup= By.id("myModalLabel");
    public static By cantPopup= By.cssSelector("span.product-quantity");
    public static By precioPopup= By.cssSelector("p.product-price");
    public static By totalPopup= By.cssSelector("p.product-total span.value");
    public static By finishCompra = By.xpath("//a[contains(text(),'Finalizar compra')]");
}
