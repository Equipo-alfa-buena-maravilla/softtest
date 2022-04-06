package com.softtek.softtest.tests;

import com.softtek.softtest.hooks.Hook;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.*;

public class SignupTest  extends Hook {

/*
* When a user clicks on
* */
//    Poner que hace en la prueba, comentario con id en la test matrix
    @Test
    public void signupTest() {
        var successfulSignup = "Sign up successful.";
        var username = faker.name().username();
        var password = faker.internet().password();
        var successMessage = homePage
                .signup()
                .withUsername(username)
                .withPassword(password)
                .submit()
                .getSuccessMessage();
        assertEquals(successfulSignup, successMessage);
    }

    @Test
    public void testRepo() {
        var users = userRepository.findAll();
        assertFalse(users.isEmpty());
    }

    @Test
    public void testLogin() {
        final var rand = new Random();
        var users = userRepository.findAll();
        var randomIndex = rand.nextInt(users.size());
        var randomUser = users.get(randomIndex);
        var expected = "Welcome " + randomUser.getUsername();
        var result = homePage
                .login()
                .withUsername(randomUser.getUsername())
                .withPassword(randomUser.getPassword())
                .submit()
                .getWelcomeMessage();
        assertEquals(expected, result);

    }
}
