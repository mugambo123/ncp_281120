package com.nopcommerce.demo.testng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListeners.class)

public class TstNgListenersDemo {
    @Test
    public void test1(){
        System.out.println("I am inside Test1");
    }
    @Test
    public void test2(){
        System.out.println("I am inside Test1");
        Assert.fail();
    }

    @Test
    public void test3(){
        System.out.println("I am inside Test1");
        throw new SkipException("This test is skipped");
    }

}
