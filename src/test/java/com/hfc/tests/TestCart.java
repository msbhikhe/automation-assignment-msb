package com.hfc.tests;

import com.hfc.pageObjects.HomePage;
import com.hfc.pageObjects.RestaurantPage;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {

    @Test
    public void testCartProducts(){
        String brand = "Mamacita";

        String address = "Semperstraße 44, 1180 Wien, Austria";
        String[] products = {
                "Cheesy Pork Burrito",
                "Chipotle Chicken Quesadilla"
        };

        HomePage hp = new HomePage();
        hp.goToBrand(brand);

        RestaurantPage rp = new RestaurantPage();
        rp.enterAddress(address);

        rp.addProductsToCart(products);

    }

}