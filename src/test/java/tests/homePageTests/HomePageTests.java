package tests.homePageTests;

import org.testng.annotations.Test;
import tests.basePage.BasePageTest;

import static constants.Constants.pagesUrls.HOME_PAGE_URL;

public class HomePageTests extends BasePageTest {
    @Test(testName = "KoKo")
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

}
