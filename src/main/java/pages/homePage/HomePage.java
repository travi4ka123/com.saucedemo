package pages.homePage;

import io.qameta.allure.Step;
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

    @Step(value = "Clicking Log In button")
    public HomePage clickLoginButton(){
        clickOneElement(loginButton);
        return this;
    }

    @Step(value = "checking 'Epic sadface: Username is required' error")
    public HomePage checkValidationForEmptyFields(){
        findOneElement(validationErrorEmptyFields);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }

    @Step(value = "checking 'Epic sadface: Username and password do not match any user in this service' error")
    public HomePage checkValidationForNotMatchedCredentials(){
        findOneElement(validationErrorNotMatchedCredentials);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }

    @Step(value = "Entering incorrect credentials")
    public HomePage enterIncorrectCredentials(){
        findOneElement(userNameInputField).sendKeys(standard_user_name);
        findOneElement(passwordInputField).sendKeys("1234");
        return this;
    }

    @Step(value = "Entering correct credentials")
    public HomePage enterCorrectCredentials(){
        findOneElement(userNameInputField).sendKeys(standard_user_name);
        findOneElement(passwordInputField).sendKeys(password);
        return this;
    }
}
