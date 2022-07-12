package pages.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.basePage.BasePage;

import static constants.Constants.credentials.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    By loginButton = By.id("login-button");
    By userNameInputField = By.id("user-name");
    By passwordInputField = By.id("password");
    By validationErrorEmptyFields = By.xpath("//*[text()='Epic sadface: Username is required']");
    By validationErrorNotMatchedCredentials = By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");


    public HomePage clickLoginButton(){
        clickOneElement(loginButton);
        return this;
    }
    public HomePage checkValidationForEmptyFields(){
        findOneElement(validationErrorEmptyFields);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }
    public HomePage checkValidationForNotMatchedCredentials(){
        findOneElement(validationErrorNotMatchedCredentials);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }
    public HomePage enterIncorrectCredentials(){
        findOneElement(userNameInputField).sendKeys(standard_user_name);
        findOneElement(passwordInputField).sendKeys("1234");
        return this;
    }

}
