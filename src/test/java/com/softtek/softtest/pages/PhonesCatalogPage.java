package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class PhonesCatalogPage extends AbstractCatalogPage {

    @FindBy(xpath = "//h4/a[text() = 'Samsung galaxy s6']")
    private WebElement samsungGalaxyLink;

    @FindBy(xpath = "//h4/a[text() = 'Nokia lumia 1520']")
    private WebElement nokiaLumiaLink;

    @Override
    public ProductPage selectProduct(String product) {
        switch (product) {
            case "samsungGalaxy":
                wait.until(elementToBeClickable(samsungGalaxyLink)).click();
                return new ProductPage(driver);
            case "nokiaLumia":
                nokiaLumiaLink.click();
                return new ProductPage(driver);
            default:
                throw new UnsupportedOperationException("Operation not allowed yet, please be patient");
        }
    }

    public PhonesCatalogPage(WebDriver driver) {
        super(driver);
    }

}
