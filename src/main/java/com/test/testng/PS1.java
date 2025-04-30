package com.test.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PS1 {

    public void doThis(){
        System.out.println("I am PS1");
    }

    @BeforeMethod
    public void beforeRun(){
        System.out.println("Run me first");
    }

    @AfterMethod
    public void AfterRun(){
        System.out.println("Run me last");
    }
}
