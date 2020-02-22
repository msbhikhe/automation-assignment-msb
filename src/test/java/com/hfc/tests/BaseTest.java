package com.hfc.tests;

import com.hfc.core.DriverManager;
import com.hfc.pageObjects.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup(){
        HomePage hp = new HomePage();
        hp.open();
        hp.acceptCookies();
    }

    @AfterMethod
    public void teardown(){
        DriverManager.quit();
    }
}
