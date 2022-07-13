package tests.basePage;

import io.qameta.allure.Attachment;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.basePage.BasePage;
import pages.homePage.HomePage;
import pages.storePage.StorePage;
import settings.CommonSettings;

public class BasePageTest {
    protected WebDriver driver = CommonSettings.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected StorePage storePage = new StorePage(driver);

    @BeforeMethod
    public void before() {
        driver = CommonSettings.createDriver();
    }

    @AfterMethod
    public void after() {
        takePhoto(driver);
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Attachment(type = "image/png")
    public byte[] takePhoto(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
