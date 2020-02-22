package com.hfc.pageObjects;

import com.hfc.core.Config;
import com.hfc.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    private By agreeCookies = By.className("agree-cookie");

    public void open(){
        DriverManager.getDriver().get(Config.getProperty("homepage"));
    }

    public void acceptCookies(){
        DriverManager.getDriver().findElement(agreeCookies).click();
    }

    public void goToBrand(String brandName){
        String brandLink = Config.getProperty("link_" + brandName.toLowerCase());
        By brandLinkLocator = By.xpath("//a[contains(@href, '"+ brandLink +"') and contains(@class, 'button-home')]");

        wait.until(ExpectedConditions.visibilityOfElementLocated(brandLinkLocator));

        DriverManager.getDriver().findElement(brandLinkLocator).click();
    }
}