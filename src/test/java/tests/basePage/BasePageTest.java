package tests.basePage;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.basePage.BasePage;
import pages.homePage.HomePage;
import settings.CommonSettings;

public class BasePageTest {
    protected WebDriver driver = CommonSettings.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected HomePage homePage = new HomePage(driver);

    @AfterTest
    public void clean(){
        takePhoto(driver);
        driver.manage().deleteAllCookies();
    }

    @AfterSuite
    public void quite(){
        driver.quit();
    }

    @Attachment(type = "image/png")
    public byte[] takePhoto(WebDriver driver){
        byte[] screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}
