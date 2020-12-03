package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.ShoppingCartPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTest extends TestBase {

    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();


    @Test
    public void VerifyProductAddedToShoppingCart() throws InterruptedException {
        //Successfully build computer by adding parts
        shoppingCartPage.verifyBuildComputerAddedToShoppingCartSuccessFully("2");

        //Compare total shopping cart price vs expected total price
        shoppingCartPage.compareTotalPrice("$2,950.00");
    }
}
