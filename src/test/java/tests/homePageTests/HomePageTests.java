package tests.homePageTests;

import org.testng.annotations.Test;
import tests.basePage.BasePageTest;

import static constants.Constants.pagesUrls.HOME_PAGE_URL;

public class HomePageTests extends BasePageTest {
    @Test(description = "KoKo")
    public void hitLoginWithoutEnteredData(){
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .clickLoginButton()
                .checkValidationForEmptyFields();
    }
    @Test
    public void loginWithIncorrectCredential(){
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .clickLoginButton()
                .enterIncorrectCredentials()
                .clickLoginButton()
                .checkValidationForNotMatchedCredentials();
    }
    @Test(description = "Log in with correct credentials")
    public void loginWithCorrectCredential(){
        basePage.pageOpen(HOME_PAGE_URL);
        homePage
                .enterCorrectCredentials()
                .clickLoginButton();
        storePage
                .checkPageOpen();
    }
    @Test(description = "It is possible to add item to cart")
    public void addItemToCart(){
        loginWithCorrectCredential();
        storePage
                .checkCartIsEmpty()
                .addFirstItemToCart()
                .checkCartIsNotEmpty();
    }
}
