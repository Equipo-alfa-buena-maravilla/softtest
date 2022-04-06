package com.softtek.softtest.tests;

import com.softtek.softtest.hooks.Hook;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContactPageTest extends Hook {

    @Test
    public void contactPageTest() {
        var name = faker.name().name();
        var email = faker.internet().emailAddress();
        var expectedMessage = "Thanks for the message!!";
        var actualMessage = homePage
                .clickContact()
                .withName(name)
                .withEmail(email)
                .withSubject("Hello im a subject body")
                .submit()
                .getSuccessMessage();
        assertEquals(actualMessage, expectedMessage);
    }
}
