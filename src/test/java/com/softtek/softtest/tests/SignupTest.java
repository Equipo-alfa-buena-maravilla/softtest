package com.softtek.softtest.tests;

import com.softtek.softtest.hooks.Hook;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class SignupTest extends Hook {

    /**
     * When a user clicks on "Sign up" in Home Page a signup form should be displayed allowing
     * username and password as inputs and a clickable "Sign Up" button. When the user enters
     * its username and password and clicks on "Sign Up", then the user gets a successful registration message.
     * */
//    Poner que hace en la prueba, comentario con id en la test matrix
    @Test
    public void signupTest() {
        var successfulSignupMessage = "Sign up successful.";
        var username = faker.name().username();
        var password = faker.internet().password();
        var successMessage = homePage
                .signup()
                .withUsername(username)
                .withPassword(password)
                .submit()
                .getSuccessMessage();
        assertEquals(successMessage, successfulSignupMessage);
    }

    @Test
    public void testRepo() {
        var users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }
/**
* Given valid username and password matching data, when the user clicks on "Log in" a login form should
* be displayed, then the user is required to insert its username and password, finally clicking
* on "Log in" displays the home page containing the logged-in username displayed.
* */
    @Test
    public void testLogin() {
        var user = userRepository.getRandomUser();
        var expected = "Welcome " + user.getUsername();
        var result = homePage
                .login()
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .submit()
                .getWelcomeMessage();
        assertEquals(result, expected);
    }

}
