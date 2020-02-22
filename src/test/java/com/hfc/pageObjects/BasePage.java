package com.hfc.pageObjects;

import com.hfc.core.Config;
import com.hfc.core.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {
    protected WebDriverWait wait;

    BasePage() {
        wait = new WebDriverWait(DriverManager.getDriver(), Integer.parseInt(Config.getProperty("explicit_wait_timeout")));
    }
}
