package com.softtek.softtest.hooks;

import com.github.javafaker.Faker;
import com.softtek.softtest.CSVUserRepository;
import com.softtek.softtest.UserRepository;
import com.softtek.softtest.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class Hook {
    private WebDriver driver;
    private static final String HOME_URL = "https://demoblaze.com/";
    protected HomePage homePage;
    protected Faker faker;
    protected UserRepository userRepository;

    @BeforeMethod
    public void setUp() {
        userRepository = new CSVUserRepository();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(HOME_URL);
        homePage = new HomePage(driver);
        faker = new Faker();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
