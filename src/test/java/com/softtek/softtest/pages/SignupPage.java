package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class SignupPage extends AbstractPage {

//miguelon123
    @FindBy(id = "sign-username")
    private WebElement usernameInput;

//miguelon123
    @FindBy(id = "sign-password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text() = 'Sign up']")
    private WebElement submitBtn;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupPage withUsername(String username) {
        wait.until(visibilityOf(usernameInput)).sendKeys(username);
        return this;
    }

    public SignupPage withPassword(String password) {
        wait.until(visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }

    public HomePage submit() {
        submitBtn.click();
        return new HomePage(driver);
    }
}
