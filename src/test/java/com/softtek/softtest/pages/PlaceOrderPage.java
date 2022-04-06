package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrderPage extends AbstractPage {

    @FindBy(id = "name")
    private WebElement nameInput;

    @FindBy(id = "country")
    private WebElement countryInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "card")
    private WebElement creditCardInput;

    @FindBy(id = "month")
    private WebElement monthInput;

    @FindBy(id = "year")
    private WebElement yearInput;

    @FindBy(xpath = "//button[text() = 'Purchase']")
    private WebElement purchaseBtn;

    @FindBy(xpath = "//h2[text() = 'Thank you for your purchase!']")
    private WebElement successfulPurchaseH2;

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    public PlaceOrderPage withName(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    public PlaceOrderPage withCity(String city) {
        cityInput.sendKeys(city);
        return this;
    }

    public PlaceOrderPage withCountry(String country) {
        countryInput.sendKeys(country);
        return this;
    }

    public PlaceOrderPage withYear(String year) {
        yearInput.sendKeys(year);
        return this;
    }

    public PlaceOrderPage withMonth(String month) {
        monthInput.sendKeys(month);
        return this;
    }

    public PlaceOrderPage withCreditCard(String creditCard) {
        creditCardInput.sendKeys(creditCard);
        return this;
    }

    public PlaceOrderPage submit() {
        purchaseBtn.click();
        return this;
    }

    public String getSuccessfulPurchaseMessage() {
        return successfulPurchaseH2.getText();
    }


}
