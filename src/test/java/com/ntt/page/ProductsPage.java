package com.ntt.page;

import org.openqa.selenium.By;

public class ProductsPage {
    public static By itemProduct = By.xpath("(//a[contains(@class,'product-thumbnail')])[1]");
    public static By cantProduct = By.id("quantity_wanted");
    public static By addProduct = By.cssSelector("button.btn.btn-primary.add-to-cart");
}
