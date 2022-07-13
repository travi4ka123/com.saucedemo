package tests.basePage;

import io.qameta.allure.Attachment;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.basePage.BasePage;
import pages.homePage.HomePage;
import pages.storePage.StorePage;
import settings.CommonSettings;

public class BasePageTest {
    protected WebDriver driver = CommonSettings.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected StorePage storePage = new StorePage(driver);

    @AfterMethod
    public void afterMethod() {
        takePhoto(driver);
        driver.manage().deleteAllCookies();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.sessionStorage.clear()");
        javascriptExecutor.executeScript("window.localStorage.clear()");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    @Attachment(type = "image/png")
    public byte[] takePhoto(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
