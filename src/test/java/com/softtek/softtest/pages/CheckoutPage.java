package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = "//button[text() = 'Place Order']")
    private WebElement placeOrderBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public PlaceOrderPage placeOrder() {
        placeOrderBtn.click();
        return new PlaceOrderPage(driver);
    }
}
