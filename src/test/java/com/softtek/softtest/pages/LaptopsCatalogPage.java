package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopsCatalogPage extends AbstractCatalogPage  {

    @FindBy(xpath = "//a[text() = 'Sony vaio i5']")
    private WebElement sonyVaioLink;

    public LaptopsCatalogPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductPage selectProduct(String product) {
        return null;
    }
}
