package com.ntt.page;

import org.openqa.selenium.By;

public class HomePage {
    public static By category = By.cssSelector("li#category-3 > a.dropdown-item");
    public static By subcategory = By.cssSelector("ul.subcategories-list a.subcategory-name[href*='/4-men']");
}
