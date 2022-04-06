package com.softtek.softtest.tests;

import com.softtek.softtest.hooks.Hook;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BuyProductsTest extends Hook {

    @Test
    public void buyProductsTest() {
        var expectedSuccessfulPurchase = "Thank you for your purchase!";
        var user = userRepository.getRandomUser();
        var successMessage = homePage
                .login()
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .submit()
                .selectCatalog("phones")
                .selectProduct("samsungGalaxy")
                .addToCart()
                .checkout()
                .placeOrder()
                .withName("asdasd")
                .withCity("asdasd")
                .withCountry("asdasdasd")
                .withCreditCard("qwdasd")
                .withYear("123")
                .withMonth("novembrer")
                .submit()
                .getSuccessfulPurchaseMessage();
        assertEquals(successMessage, expectedSuccessfulPurchase);
    }
}
