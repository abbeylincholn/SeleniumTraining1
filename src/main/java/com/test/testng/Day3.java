package com.test.testng;

import org.testng.annotations.*;

public class Day3 {
    @BeforeClass
    public void beforeClass(){
        System.out.println("before executing any methods in the class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after executing all methods in the class");
    }

    @BeforeSuite
    public void BFSuite(){
        System.out.println("I am No 1");
    }

    @BeforeMethod
    public void beforeEvery(){
        System.out.println("I will execute before every test method in day 3 class");
    }

    @AfterMethod
    public void AfterEvery(){
        System.out.println("I will execute after every test method in day 3 class");
    }

    @Test(timeOut = 4000)    // helper attribute
    public void webLoginCarLoan() {
        //Selenium
        System.out.println("WebLoginCarLoan");
    }

    @Parameters({"url"})
    @Test
    public void mobileLoginCarLoan(String urlname) {
        //Appium
        System.out.println("MobileLoginCar");
        System.out.println(urlname);
    }

    @Test (groups = {"Smoke"})
    public void mobileSigninCarLoan() {
        //Appium
        System.out.println("Mobile SignIn");
    }

    @Test(enabled = false)    // helper attribute
    public void mobileSignOutCarLoan() {
        //Appium
        System.out.println("Mobile SignOut");
    }

    @Test(dependsOnMethods = {"webLoginCarLoan", "mobileLoginCarLoan"})    // helper attribute, interdependency
    public void APICarLoan() {
        //Rest API Automation
        System.out.println("LoginAPICar");
    }




}
