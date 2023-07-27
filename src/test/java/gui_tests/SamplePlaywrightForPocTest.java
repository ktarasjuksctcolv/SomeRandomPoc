package gui_tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;
import pages.LoginPagePomPlaywright;
import pages.ProductPagePlaywright;

import static com.codeborne.selenide.Selenide.open;

public class SamplePlaywrightForPocTest {
    @Test
    public void addSomeRandomItemToCart() {
        Playwright playwright = Playwright.create();
        BrowserType chromium = playwright.chromium();
        Browser browser = chromium.launch();
        Page page = browser.newPage();

        LoginPagePomPlaywright loginPagePomPlaywright = new LoginPagePomPlaywright(page);
        ProductPagePlaywright productPagePlaywright = new ProductPagePlaywright(page);


        page.navigate("https://www.saucedemo.com/");
        loginPagePomPlaywright.login();
        productPagePlaywright.selectProduct("red t-shirt");
        productPagePlaywright.selectItemFromBurgerMenu("all items");
        productPagePlaywright.goToCart();
        productPagePlaywright.validatePrice("$15.99");

        browser.close();
    }
}
