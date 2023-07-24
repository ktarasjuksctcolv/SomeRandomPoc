package gui_tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.LoginPagePom;
import pages.ProductPage;

import static com.codeborne.selenide.Selenide.open;

public class SampleWebForPocTest {

    private final LoginPagePom loginPagePom = new LoginPagePom();
    private final ProductPage productPage = new ProductPage();

    @Test
    public void addSomeRandomItemToCart() {
        open("https://www.saucedemo.com/");
        loginPagePom.login();
        productPage.selectProduct("red t-shirt");
        productPage.selectItemFromBurgerMenu("all items");
        productPage.goToCart();
        productPage.validatePrice("$15.99");
    }



}
