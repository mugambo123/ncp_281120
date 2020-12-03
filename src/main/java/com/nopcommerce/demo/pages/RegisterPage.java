package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

public class RegisterPage extends Utility {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    By registerLink = By.xpath("//a[contains(text(),'Register')]");
    By registerPageMessage = By.xpath("//h1[contains(text(),'Register')]");
    By genderMale = By.xpath("//input[@id='gender-male']");
    By genderFemale = By.xpath("//input[@id='gender-female']");
    By firstName = By.xpath("//input[@id='FirstName']");
    By lastName = By.xpath("//input[@id='LastName']");
    By dobDay = By.xpath("//select[@name = 'DateOfBirthDay']");
    By dobMonth = By.xpath("//select[@name = 'DateOfBirthMonth']");
    By dobYear = By.xpath("//select[@name = 'DateOfBirthYear']");
    By email = By.xpath("//input[@id='Email']");
    By company = By.xpath("//input[@id='Company']");
    By newsLatter = By.xpath("//input[@id='Newsletter']");
    By pass = By.xpath("//input[@id='Password']");
    By confirmPass = By.xpath("//input[@id='ConfirmPassword']");
    By registerButton = By.xpath("//input[@id='register-button']");
    By registrationCompleted = By.xpath("//div[contains(text(),'Your registration completed')]");
    By logOut = By.xpath("//a[contains(text(),'Log out')]");
    By logIn = By.xpath("//a[contains(text(),'Log in')]");

    public void navigateToRegister(String expectedRegisterPageMessage) throws InterruptedException {
        Reporter.log("Navigate To Register Page "+ registerPageMessage);
        Thread.sleep(1000);
        Reporter.log("Navigate to Register page");
        clickOnElement(registerLink);

        String actualMessage = getTextFromElement(registerPageMessage);
        Assert.assertEquals(expectedRegisterPageMessage, actualMessage);
    }

    public void registerAndLoginSuccessfully(String firstName1, String lastName1, String dateOfBirth, String monthOfBirth, String yearOfBirth,
                                             String emailAddress, String companyName, String password, String registrationCompSuccMsg) throws InterruptedException {
       Reporter.log("Register successfully: " + registrationCompleted + "Login Successfully: " + logIn);
        Thread.sleep(1000);
        clickOnElement(genderMale);

        Thread.sleep(1000);
        sendTextToElement(firstName, firstName1);

        Thread.sleep(1000);
        sendTextToElement(lastName, lastName1);
        Thread.sleep(1000);

        sendTextToElement(dobDay, dateOfBirth);
        sendTextToElement(dobMonth, monthOfBirth);
        sendTextToElement(dobYear, yearOfBirth);


        sendTextToElement(email, emailAddress);
        String loginEmail = emailAddress;

        sendTextToElement(company, companyName);


        driver.findElement(newsLatter).isSelected();


        sendTextToElement(pass, password);
        String confirmPassword = password;

        sendTextToElement(confirmPass, confirmPassword);

        clickOnElement(registerButton);

        String expectedSuccessfulRegisterMessage = registrationCompSuccMsg;
        String actualSuccessfulRegisterMessage = getTextFromElement(registrationCompleted);
        Assert.assertEquals(expectedSuccessfulRegisterMessage, actualSuccessfulRegisterMessage);

        Thread.sleep(1000);
        clickOnElement(logOut);
        Thread.sleep(1000);
        clickOnElement(logIn);
        loginPage.loginToApplication(loginEmail, confirmPassword);
    }
}
