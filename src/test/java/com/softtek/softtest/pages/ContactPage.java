package com.softtek.softtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        contactNameInput.sendKeys(name);
        return this;
    }
    public ContactPage withSubject(String subject) {
        subjectTextArea.sendKeys(subject);
        return this;
    }

    public HomePage submit() {
        submitBtn.click();
        return new HomePage(driver);
    }


}
