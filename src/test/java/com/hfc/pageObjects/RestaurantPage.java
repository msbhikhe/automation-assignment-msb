package com.hfc.pageObjects;

import com.hfc.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RestaurantPage extends BasePage {

    private By linkContinueWithoutAddress = By.xpath("//a[@class='popup-no-address-link']");
    private By textBoxAddress = By.id("address-input");
    private By btnAddAddress = By.xpath("//input[@id='address-input']/following-sibling::input");
    private By btnChangeAddress = By.xpath("//p[@id='customer_address']//following-sibling::a[@class='btn change-address']");

    private By btnModalClose = By.id("topup-modal--close");
    private By lblCart = By.className("ajax--cart");

    public void continueWithoutAddress(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(linkContinueWithoutAddress));

        DriverManager.getDriver().findElement(linkContinueWithoutAddress).click();
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxAddress));

        DriverManager.getDriver().findElement(textBoxAddress).sendKeys(address);
        DriverManager.getDriver().findElement(btnAddAddress).click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(textBoxAddress));
        wait.until(ExpectedConditions.elementToBeClickable(btnChangeAddress));

        DriverManager.getDriver().navigate().refresh();
    }

    public void addProductsToCart(String[] products) {
        By productLocator;

        for(String product : products){
            productLocator = By.xpath("//div[contains(@class, 'product--box')]//a[contains(@title, '" + product + "')]" +
                    "/parent::form/following-sibling::div[@class='product--btn-container']" +
                    "//button[contains(@class,'buybox--button')]");

            wait.until(ExpectedConditions.presenceOfElementLocated(lblCart));

            wait.until(ExpectedConditions.elementToBeClickable(productLocator));
            DriverManager.getDriver().findElement(productLocator).click();

            wait.until(ExpectedConditions.elementToBeClickable(btnModalClose));
            DriverManager.getDriver().findElement(btnModalClose).click();
        }
    }
}
