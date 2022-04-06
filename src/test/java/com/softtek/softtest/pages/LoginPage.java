package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends AbstractPage {

    @FindBy(id = "loginusername")
    private WebElement usernameInput;

    @FindBy(id = "loginpassword")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text() = 'Log in']")
    private WebElement submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage withUsername(String username) {
        wait.until(visibilityOf(usernameInput)).sendKeys(username);
        return this;
    }

    public LoginPage withPassword(String password) {
        this.passwordInput.sendKeys(password);
        return this;
    }

    public HomePage submit() {
        this.submitBtn.click();
        return new HomePage(driver);
    }
}
