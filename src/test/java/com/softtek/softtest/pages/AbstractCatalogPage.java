package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractCatalogPage extends AbstractPage {

    public abstract ProductPage selectProduct(String product);

    public AbstractCatalogPage(WebDriver driver) {
        super(driver);
    }
}
