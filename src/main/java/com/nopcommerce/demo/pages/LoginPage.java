package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Reporter;

public class LoginPage extends Utility {

    By emailField = By.id("Email");
    By passwordField = By.name("Password");
    By loginBtn = By.xpath("//input[@value='Log in']");
    By welcomeText = By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]");
    By errorMessage = By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]");

    // This method will enter email Id
    public void enterEmailId(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
    }

    //
    public void enterPassword(String password) {
        Reporter.log("Enter Password " + password + " to password field" + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Clicking On Login Button");
        clickOnElement(loginBtn);

    }

    public String getWelcomeText() {
        Reporter.log("Get Text of welcome message " + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public String getErrorMessage() {
        Reporter.log("Error Message");
        return getTextFromElement(errorMessage);
    }

    public void loginToApplication(String email, String password) throws InterruptedException {
        implicitWait(10);
        enterEmailId(email);
        implicitWait(5);
        enterPassword(password);
        implicitWait(5);
        implicitWait(10);
        clickOnLoginButton();
    }


}