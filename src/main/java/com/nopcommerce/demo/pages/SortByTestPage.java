package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByTestPage extends Utility {
    By mouseHoverOnComputer = By.xpath("//div[@class='header-menu']//ul[1]//a[contains(text(),\"Computers\")]");
    By clickDesktop = By.xpath("//div[@class='header-menu']//ul[1]//a[contains(text(),'Computers')]//parent::li//ul//a[contains(text(), 'Desktops')]");
    By selectDropdown = By.id("products-orderby");
    By getElementList = By.xpath("//h2[@class='product-title']");

    public void verifyProductArrangeInAlphabaticalOrder() throws InterruptedException {
        Reporter.log("Verify Product arranged in Name: Z to A Position ");
        //Mouse hove on Computer Menu and click on desktop
        mouseHoverToElement(mouseHoverOnComputer);
        clickOnElement(clickDesktop);
        //sort by position "Name: Z to A"
        selectByVisibleTextFromDropDown(selectDropdown, "Name: Z to A");

        //Getting list of web elements of product name
        List<WebElement> deskTopPCs = getListOfElements(getElementList);

        //Declaring the String List to store product name
        List<String> deskTopNames = new ArrayList<>();

        for (WebElement deskTop : deskTopPCs) {
            deskTopNames.add(deskTop.getText());
        }

        // Create the temp list of product name and sort it using Collections.sort method
        List<String> tempList = new ArrayList<>();
        tempList.addAll(deskTopNames);

        Collections.sort(tempList, Collections.reverseOrder());
        //System.out.println(deskTopNames);
        //System.out.println(tempList);
        Assert.assertEquals(deskTopNames, tempList);
    }

}



