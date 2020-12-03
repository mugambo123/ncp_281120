package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class HomePage extends Utility {
    By loginLink = By.linkText("Log in");
    By registerLink = By.linkText("Register");

    public void clickOnLoginLink(){
        Reporter.log("Clicking on Login Link " + loginLink.toString() + "<br>");
        clickOnElement(loginLink);

    }
    public void clickONRegisterLink(){
        Reporter.log("Clicking on Register Link "+ registerLink.toString());
        clickOnElement(registerLink);
    }
}
