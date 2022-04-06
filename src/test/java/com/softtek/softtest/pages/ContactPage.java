package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ContactPage extends AbstractPage {

    @FindBy(id = "recipient-email")
    private WebElement emailInput;

    @FindBy(id = "recipient-name")
    private WebElement contactNameInput;

    @FindBy(id = "message-text")
    private WebElement subjectTextArea;

    @FindBy(xpath = "//button[text() = 'Send message']")
    private WebElement submitBtn;

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    public ContactPage withEmail(String email){
        emailInput.sendKeys(email);
        return this;
    }

    public ContactPage withName(String name) {
        wait.until(visibilityOf(contactNameInput)).sendKeys(name);
        return this;
    }
    public ContactPage withSubject(String subject) {
        subjectTextArea.sendKeys(subject);
        return this;
    }

    public ContactPage submit() {
        submitBtn.click();
        return this;
    }

    public String getSuccessMessage() {
        return wait
                .until(alertIsPresent())
                .getText();
    }


}
