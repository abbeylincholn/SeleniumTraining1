package com.test.testng;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
    // defining global environment variables in testng.xml
    // Parameterisation with multiple data sets by running tests with multiple combinations

    @Parameters({"url", "APIKey/username"})
    @Test
    public void webLoginHomeLoan(String urlname, String key) {
        //Selenium
        System.out.println("WebLoginHome");
        System.out.println(urlname);
        System.out.println(key);
    }

    @Test
    public void mobileLoginHomeLoan() {
        //Appium
        System.out.println("MobileLoginHome");
    }

    @Test (groups = {"Smoke"})
    public void loginAPICarLoan() {
        //Rest API Automation
        System.out.println("LoginAPIHome");
    }


}
