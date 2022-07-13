package pages.storePage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.basePage.BasePage;

import java.time.Duration;

public class StorePage extends BasePage {
    public StorePage(WebDriver driver) {
        super(driver);
    }

    By inventoryContainer = By.id("inventory_container");
    By sauseLabsItem = By.id("add-to-cart-sauce-labs-backpack");
    By somethingInCartIndicator = By.className("shopping_cart_badge");

    @Step(value = "We are on the StorePage page")
    public StorePage checkPageOpen(){
        findOneElement(inventoryContainer);
        return this;
    }

    @Step(value = "Checking cart is empty")
    public StorePage checkCartIsEmpty(){
        new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.invisibilityOfElementLocated(somethingInCartIndicator));
        return this;
    }

    @Step(value = "Adding first element to cart")
    public StorePage addFirstItemToCart(){
        clickOneElement(sauseLabsItem);
        return this;
    }

    @Step(value = "Checking cart is not empty")
    public StorePage checkCartIsNotEmpty(){
        findOneElement(somethingInCartIndicator);
        return this;
    }

}
