package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();

        @Test(priority = 3)
        public void verifyUserShouldNavigateToLoginPage() {
            homePage.clickOnLoginLink();
            String expectedMessage = "Welcome, Please Sign In!";
            String actualMessage = loginPage.getWelcomeText();
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    @Test(priority = 2)
    public void verifyErrorMessageWhenWrongUserNameIsEntered() throws InterruptedException {
        homePage.clickOnLoginLink();

        loginPage.loginToApplication("xyz@yahoo.coom", "xyz123");

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualMessage);


    }

    @Test(priority = 1 )
    public void verifyErrorMessageWhenWrongPasswordIsEntered() throws InterruptedException {
        homePage.clickOnLoginLink();
        loginPage.loginToApplication("xyz@yahoo.coom", "abc123");

        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualMessage);


    }
    @Test(priority = 0)
    public void  doLogin() throws InterruptedException {
        homePage.clickOnLoginLink();
        implicitWait(10);
        loginPage.loginToApplication("abc@yahoo.coom", "xyz123");
    }

}
