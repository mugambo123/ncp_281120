package com.nopcommerce.demo.sortbytest;

import com.nopcommerce.demo.pages.SortByTestPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.annotations.Test;

public class SortByTest extends TestBase {

    SortByTestPage sortByTestPage = new SortByTestPage();

    @Test
    public void verifyProductArrangedInZToAPosition() throws InterruptedException {
        sortByTestPage.verifyProductArrangeInAlphabaticalOrder();
    }
}
