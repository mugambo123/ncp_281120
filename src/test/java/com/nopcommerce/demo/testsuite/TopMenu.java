package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.TopMenuPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

public class TopMenu extends TestBase {

    TopMenuPage topMenuPage = new TopMenuPage();

   @Test
   public void menu() throws InterruptedException {
       // Below method is for getting menu list
        topMenuPage.selectMenu("menuList");

        //This method will visit each and every product category
        topMenuPage.verifyPageNavigation();
    }


    }

