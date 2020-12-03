package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

public class TopMenuPage extends Utility {
    String menuList;
    By topMenuList = By.xpath("//ul[@class='top-menu notmobile']/li");
    // dynamicMenuList doesn't work
    By dynamicMenuList = By.xpath("//div/ul[@class='top-menu notmobile']//a[contains(text(),'" + menuList + "')]");
    By computer = By.xpath("//h1[contains(text(),'Computers')]");
    By electronics = By.xpath("//h1[contains(text(),'Electronics')]");
    By apparel = By.xpath("//h1[contains(text(),'Apparel')]");
    By digitalDownloads = By.xpath("//body/div[6]/div[2]/ul[1]/li[4]");
    By books = By.xpath("//h1[contains(text(),'Books')]");
    By jewelry = By.xpath("//h1[contains(text(),'Jewelry')]");
    By giftCards = By.xpath("//h1[contains(text(),'Gift Cards')]");

    public void selectMenu(String menuList) {
        Reporter.log("Get menu List by using for loop: "+ dynamicMenuList+ "<br>");

        List<WebElement> topMenu = driver.findElements(topMenuList);
// for loop to get list of menuList
        for (WebElement element : topMenu) {

            if (element.getText().contains(menuList)) {

                // variable dynamicMenuList can't find locator so I couldn't convert this one line below in to page object
                clickOnElement(By.xpath("//div/ul[@class='top-menu notmobile']//a[contains(text(),'" + menuList + "')]"));
                break;
            }
        }
    }

    // Method to verify to visit each and every menu section one by one
    public void verifyPageNavigation() throws InterruptedException {
        Reporter.log("verify every product category page can be navigated : "+"<br>" );
        String expectedMessage, actualMessage;

        selectMenu("Computers");
        Thread.sleep(1000);
        expectedMessage = "Computers";
        actualMessage = getTextFromElement(computer);
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);

        selectMenu("Electronics");
        expectedMessage = "Electronics";
        actualMessage = getTextFromElement(electronics);
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);

        selectMenu("Apparel");
        expectedMessage = "Apparel";
        actualMessage = getTextFromElement(apparel);
        Assert.assertEquals(expectedMessage, actualMessage);
        Thread.sleep(1000);

        selectMenu("Digital Downloads");
        expectedMessage = "Digital downloads";
        actualMessage = getTextFromElement(digitalDownloads);
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Books");
        expectedMessage = "Books";
        actualMessage = getTextFromElement(books);
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Jewelry");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[6]/a[1]"));
        expectedMessage = "Jewelry";
        actualMessage = getTextFromElement(jewelry);
        Assert.assertEquals(expectedMessage, actualMessage);

        selectMenu("Gift Cards");
        //clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        expectedMessage = "Gift Cards";
        actualMessage = getTextFromElement(giftCards);
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}



