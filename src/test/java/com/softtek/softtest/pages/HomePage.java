package com.softtek.softtest.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage extends AbstractPage {

    @FindBy(id = "nameofuser")
    private WebElement usernameSpan;

    @FindBy(id = "login2")
    private WebElement loginBtn;

    @FindBy(id = "signin2")
    private WebElement signinBtn;

    @FindBy(xpath = "//a[text() = 'Contact']")
    private WebElement contactBtn;

    private Alert alert;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage login() {
        loginBtn.click();
        return new LoginPage(driver);
    }

    public SignupPage signup() {
        signinBtn.click();
        return new SignupPage(driver);
    }

    public ContactPage contact() {
        contactBtn.click();
        return new ContactPage(driver);
    }

    public String getSuccessMessage() {
        alert = wait.until(alertIsPresent());
        return alert.getText();
    }

    public String getWelcomeMessage() {
        return wait.until(visibilityOf(usernameSpan)).getText();
    }
}
