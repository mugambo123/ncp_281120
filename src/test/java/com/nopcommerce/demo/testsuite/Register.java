package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

import javax.jws.Oneway;

public class Register extends TestBase {

    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void registerAndLogin() throws InterruptedException {
        registerPage.navigateToRegister("Register");
        registerPage.registerAndLoginSuccessfully(
                "Joe",
                "Biden",
                "5",
                "september",
                "1949",
                randomStringUpperCaseLowerCase(6) + randomIntZeroToNineThousand(9000) + "@gmail.com",
                "White House",
                randomStringUpperCaseLowerCase(6) + randomIntZeroToNineThousand(9000),
                "Your registration completed");
    }
}

