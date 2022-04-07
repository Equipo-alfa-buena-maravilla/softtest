package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//a[text() = 'Add to cart']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//a[text() = 'Cart']")
    private WebElement checkoutLink;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart() {
        wait.until(elementToBeClickable(addToCartBtn)).click();
        return this;
    }

    public CheckoutPage checkout() {
        checkoutLink.click();
        return new CheckoutPage(driver);
    }
}
