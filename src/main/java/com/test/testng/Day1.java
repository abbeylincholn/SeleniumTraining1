package com.test.testng;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day1 {

    /** TestNG is a testing framework inspired by JUnit and NUnit but designed to be more powerful and flexible.
    * It's primarily used for automated testing in Java, especially in combination with Selenium for web application testing.
    * The "NG" stands for "Next Generation."
🔧 What does TestNG do? TestNG provides:
    A way to write and run automated unit, functional, and integration tests.
    Annotations to control test execution (@Test, @BeforeClass, @AfterMethod, etc.)
    Support for parallel testing, data-driven testing, and grouping of tests.
    Better reporting features compared to JUnit.
    Defining multiple test case methods in a single class.
    You can modularise the testcases based on functionalities and trigger them using testng.xml according to your requirement.
    You can also get a control on running specific methods from testng.xml.
    Easy integration with build tools like Maven, Gradle, and CI tools like Jenkins.
    * */

    @AfterTest
    public void lastExecution(){
        System.out.println("I will execute last");
    }

    @Parameters({"url"})
    @Test
    public void Demo(String urlname) {
        System.out.println("Hello World");
        System.out.println(urlname);
    }

    @Test
    public void Demo1() {
        System.out.println("Welcome to Selenium");
        Assert.assertTrue(false);
    }

    @AfterSuite
    public void ATSuite(){
        System.out.println("I am No 1 from the Last");
    }




}
