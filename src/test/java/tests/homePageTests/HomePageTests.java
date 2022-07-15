package tests.homePageTests;

import org.testng.annotations.Test;
import tests.basePage.BasePageTest;

import static constants.Constants.pagesUrls.HOME_PAGE_URL;

public class HomePageTests extends BasePageTest {

    @Test(description = "Trying to login without entered data")
    public void hitLoginWithoutEnteredData() {
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .clickLoginButton()
                .checkValidationForEmptyFields();
    }

    @Test(description = "Log in with incorrect credentials")
    public void loginWithIncorrectCredential() {
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .enterIncorrectCredentials()
                .clickLoginButton()
                .checkValidationForNotMatchedCredentials();
    }

    @Test(description = "Log in with correct credentials")
    public void loginWithCorrectCredential() {
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .enterCorrectCredentials()
                .clickLoginButton();
        storePage
                .checkPageOpen();
    }

    @Test(description = "It is possible to add item to cart")
    public void addItemToCart() {
        loginWithCorrectCredential();
        storePage
                .checkCartIsEmpty()
                .addFirstItemToCart()
                .checkCartIsNotEmpty();
    }

    @Test(description = "It is possible to add some items to cart")
    public void addSomeItemsToCart() {
        loginWithCorrectCredential();
        storePage
                .checkCartIsEmpty()
                .addFirstItemToCart()
                .addSecondItemToCart()
                .checkCartHasTwoItems();
    }

    @Test(description = "It is possible to add item to cart and remove it after")
    public void addSomeItemsToCartAndRemove() {
        loginWithCorrectCredential();
        storePage
                .checkCartIsEmpty()
                .addFirstItemToCart()
                .removingFirstItemFromCart()
                .checkCartIsEmpty();
    }
}
