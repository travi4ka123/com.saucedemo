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
        System.out.println("Clicking Log In button");
        clickOneElement(loginButton);
        return this;
    }
    public HomePage checkValidationForEmptyFields(){
        System.out.println("checking 'Epic sadface: Username is required' error");
        findOneElement(validationErrorEmptyFields);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }
    public HomePage checkValidationForNotMatchedCredentials(){
        System.out.println("checking 'Epic sadface: Username and password do not match any user in this service' error");
        findOneElement(validationErrorNotMatchedCredentials);
        Assert.assertEquals(findOneElement(userNameInputField).getCssValue("border-bottom-color"),"rgba(226, 35, 26, 1)");
        Assert.assertEquals(findOneElement(passwordInputField).getCssValue("border-bottom-color"), "rgba(226, 35, 26, 1)");
        return this;
    }
    public HomePage enterIncorrectCredentials(){
        System.out.println("Entering incorrect credentials");
        findOneElement(userNameInputField).sendKeys(standard_user_name);
        findOneElement(passwordInputField).sendKeys("1234");
        return this;
    }
    public HomePage enterCorrectCredentials(){
        System.out.println("Entering correct credentials");
        findOneElement(userNameInputField).sendKeys(standard_user_name);
        findOneElement(passwordInputField).sendKeys(password);
        return this;
    }
}
