package com.softtek.softtest.tests;

import com.softtek.softtest.core.Catalog;
import com.softtek.softtest.hooks.Hook;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

public class BuyProductsTest extends Hook {

    /**
     * When a logged-in user clicks on phones catalog, a list of phones is displayed, then
     * the user selects the Samsung Galaxy and clicks on "Add to cart".
     * Proceeding to checkout comes next, when the user clicks on "Place Order". A place order
     * form is displayed. Finally, as the user fulfills this form and clicks on "Purchase"
     * a message indicating a successful purchase is displayed.
     * */
    @Test
    public void buyProductsTest() {
        var checkoutDateInfo = LocalDate.now();
        var expectedSuccessfulPurchase = "Thank you for your purchase!";
        var user = userRepository.getRandomUser();
        var successMessage = homePage
                .login()
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .submit()
                .selectCatalog(Catalog.PHONES)
                .selectProduct("samsungGalaxy")
                .addToCart()
                .checkout()
                .placeOrder()
                .withName(faker.name().name())
                .withCity(faker.address().city())
                .withCountry(faker.country().name())
                .withCreditCard(faker.finance().creditCard())
                .withYear(String.valueOf(checkoutDateInfo.getYear()))
                .withMonth(checkoutDateInfo.getMonth().name())
                .submit()
                .getSuccessfulPurchaseMessage();
        assertEquals(successMessage, expectedSuccessfulPurchase);
    }
}
