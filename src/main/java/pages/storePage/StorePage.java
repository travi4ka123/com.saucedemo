package pages.storePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.basePage.BasePage;

import java.time.Duration;

import static constants.Constants.driverSettings.implicitWait;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    By inventoryContainer = By.id("inventory_container");
    By sauseLabsItem = By.id("add-to-cart-sauce-labs-backpack");
    By somethingInCartIndicator = By.className("shopping_cart_badge");

    public StorePage checkPageOpen(){
        System.out.println("We are on the StorePage page");
        findOneElement(inventoryContainer);
        return this;
    }
    public StorePage checkCartIsEmpty(){
        System.out.println("Checking cart is empty");
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(somethingInCartIndicator));
        return this;
    }
    public StorePage addFirstItemToCart(){
        System.out.println("Adding first element to cart");
        clickOneElement(sauseLabsItem);
        return this;
    }
    public StorePage checkCartIsNotEmpty(){
        System.out.println("Checking cart is not empty");
        findOneElement(somethingInCartIndicator);
        return this;
    }

}
