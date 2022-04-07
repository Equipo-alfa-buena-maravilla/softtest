package com.softtek.softtest.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class HomePage extends AbstractPage {

    @FindBy(id = "nameofuser")
    private WebElement usernameSpan;

    @FindBy(id = "login2")
    private WebElement loginBtn;

    @FindBy(id = "signin2")
    private WebElement signinBtn;

    @FindBy(xpath = "//a[text() = 'Contact']")
    private WebElement contactBtn;

    @FindBy(xpath = "//a[text() = 'Phones']")
    private WebElement phonesCatalogLink;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    public ContactPage clickContact() {
        contactBtn.click();
        return new ContactPage(driver);
    }

    public SignupPage signup() {
        signinBtn.click();
        return new SignupPage(driver);
    }

    public String getSuccessMessage() {
        Alert alert = wait.until(alertIsPresent());
        return alert.getText();
    }

    public String getWelcomeMessage() {
        return wait.until(visibilityOf(usernameSpan)).getText();
    }

    public AbstractCatalogPage selectCatalog(String catalog) {

        switch (catalog) {
            case "phones":
                retryingFindClick();
                return new PhonesCatalogPage(driver);
            case "laptops":

                return new LaptopsCatalogPage(driver);
            default:
                throw new UnsupportedOperationException("fuck off");
        }
    }
    private void retryingFindClick() {
        boolean result = false;
        int attempts = 0;
        while(attempts < 2) {
            try {
                phonesCatalogLink.click();
                result = true;
                break;
            } catch(StaleElementReferenceException e) {
            }
            attempts++;
        }
    }
}
