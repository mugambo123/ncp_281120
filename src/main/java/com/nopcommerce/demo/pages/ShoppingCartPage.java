package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartPage extends Utility {
    By clickComputer = By.xpath("//ul[@class='top-menu notmobile']/li[1]");
    By clickDesktop = By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h2[1]/a[1]");
    By moushovclick = By.xpath("//select[@id='products-orderby']");
    By addToCart = By.xpath("//select[@id='products-orderby']/option[2]");
    By buildComputer = By.xpath("//body/div[6]/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]");
    By getTextComputer = By.xpath("//h1[contains(text(),'Build your own computer')]");
    By selectProcessor = By.xpath("//select[@id='product_attribute_1']");
    By selectRamGB = By.xpath("//select[@id='product_attribute_1']");
    By selectRamGB1 = By.xpath("//select[@id='product_attribute_2']");
    By selectHardDisk = By.xpath("//dd[@id='product_attribute_input_3']/ul/li[2]//label[contains(text(),'400 GB [+$100.00]')]");
    By selectOperatingSystem = By.xpath("//dd[@id='product_attribute_input_4']//li[2]//label[contains(text(),'Vista Premium [+$60.00]')]");
    By checkBoxTotalCommander = By.xpath("//dd[@id='product_attribute_input_5']//li[3]/input");
    By totalAmount = By.xpath("//span[contains(text(),'$1,475.00')]");
    By addToCart2 = By.xpath("//input[@id='add-to-cart-button-1']");
    By shoppingCartText = By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]");
    By addToCart3 = By.xpath("//a[contains(text(),'shopping cart')]");
    By clearQuantity = By.xpath("//input[@class='qty-input']");
    By updateQuantity = By.xpath("//input[@class='qty-input']");
    By compareTotal = By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/input[1]");
    By getTextFromFinal = By.xpath("//tbody/tr[1]/td[7]/span[1]");

    public void verifyBuildComputerAddedToShoppingCartSuccessFully(String quantity) throws InterruptedException {
        Reporter.log("BuildCoputerAddTOShoppingCart : "+ shoppingCartText + "<br>");
        //  Click on Computer Menu.
        clickOnElement(clickComputer);

        Thread.sleep(1000);

        //Click on Desktop
        clickOnElement(clickDesktop);
        //   Select Sortby position "Name: A to Z"
        mouseHoverToElementAndClick(moushovclick);
        //Click on "Add To Cart"
        clickOnElement(addToCart);
        //Verify the Text "Build your own computer"
        clickOnElement(buildComputer);
        String expectedMessage = "Build your own computer";
        String actualMessage = getTextFromElement(getTextComputer);
        Assert.assertEquals(expectedMessage, actualMessage);
        //Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        clickOnElement(selectProcessor);
        //Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(selectRamGB, 0);
        selectByIndexFromDropDown(selectRamGB1, 2);
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(selectHardDisk);
        //Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(selectOperatingSystem);
        //   Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        //Verify the price "$1,475.00"
        mouseHoverToElementAndClick(checkBoxTotalCommander);
        expectedMessage = "$1,475.00";
        actualMessage = getTextFromElement(totalAmount);
        Assert.assertEquals(expectedMessage, actualMessage);

        clickOnElement(addToCart2);
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = getTextFromElement(shoppingCartText);
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on "ADD TO Cart" Button.
        mouseHoverToElementAndClick(addToCart3);
        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(clearQuantity).clear();
        Thread.sleep(1000);
        driver.findElement(updateQuantity).sendKeys(quantity);

    }

    public void compareTotalPrice(String expectedTotal) {
        Reporter.log("compare total price: "+getTextFromFinal+ "<br>" );
        //Verify the Total"$2,950.00"
        clickOnElement(compareTotal);
        String expectedMessage = expectedTotal;
        String actualMessage = getTextFromElement(getTextFromFinal);
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
