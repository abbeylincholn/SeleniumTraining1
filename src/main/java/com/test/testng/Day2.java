package com.test.testng;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day2 {

    /*
    // include Appium mobile testing in our cv

    * When students ask, "Why did it not execute at the end?", the answer is: when you use the @BeforeTest annotation, the scope is limited only to your test folder.
    * Understanding @BeforeTest and @AfterTest is important: @BeforeTest runs before any tests within a specific test folder are executed,
    * and @AfterTest runs after all tests in that folder are completed. You can use @AfterTest for different purposes depending on the context.
    * In Selenium or Appium, it is commonly used to delete cookies, stop the browser or app processes, or read and generate reports.
    * In REST API testing, @AfterTest is typically used to close the connections made during service calls. This helps ensure that your tests are clean
    * and that resources are properly released.
    * *
    * When you use annotations like @BeforeSuite and @AfterSuite, they execute first and last respectively. No matter how many test folders or class files you have,
    * @BeforeSuite is taken as a priority and runs before everything else, while @AfterSuite runs at the very end after your entire automation suite has completed execution.
    * These annotations are generally used when you want to set global environment variables for your framework.   In REST APIs, we use this setup to configure keys or handle APIs
    * that require secure access. For example, to work with Google APIs, you need an API key; for Jira, you need a header key; and for Twitter, you need specific access keys.
    * This setup is important, and if you are watching my REST Assured Automation Tutorial, you will see how we implement these configurations.

     * Thereafter, @BeforeMethod will execute because this method is triggered before each and every test method in a class.
     * After the first test case is executed, @AfterMethod will run, which is responsible for any cleanup tasks after the execution of each individual test method.
     *  Again, before the second test case starts, @BeforeMethod will run, setting up fresh preconditions, then the test will execute, followed by @AfterMethod again.
     * This cycle continues for every test method. So if there are four test cases, @BeforeMethod will execute four times before each test, and
     * @AfterMethod will execute four times after each test, ensuring a clean and isolated environment for every test case.
     *
     *
     * This is also one of the famous interview questions. When an interviewer asks, "I know there are a few errors in my application, and I don't want my framework to trigger those tests, what will you do?",
     * one common wrong or silly answer that candidates give is, "I will just comment the code" or "I will delete the test." While commenting or deleting will stop the test from running,
     * a smarter and more technically confident answer is to say, "I will set the test's enabled attribute to false using TestNG." This shows not only your technical knowledge
     * but also your professional approach to handling test execution properly without modifying or losing the original test code.
     *
     * In TestNG, you can achieve parameterization in two ways: either by using the @Parameters annotation with a TestNG XML file or by using the @DataProvider annotation. With @Parameters,
     * you define the parameter values in your testng.xml file and access them in your test method by annotating it with @Parameters, specifying the parameter names. For example,
     * you can set <parameter name="username" value="testuser"/> and <parameter name="password" value="testpass"/> in your testng.xml, and then write a test method like public void loginTest(String username, String password)
     * that receives these values at runtime. On the other hand, with @DataProvider, you create a method that returns an array of data sets, and then link this provider to your test method using @Test(dataProvider = "name").
     * For instance, your data provider might return multiple sets of usernames and passwords, and the test will run once for each set automatically. Both approaches allow you to pass dynamic data into your tests,
     * but @DataProvider is especially useful for running the same test multiple times with different data, while @Parameters is simpler when you want to inject a few values from the configuration file.
     *
     * */




    @Test(dataProvider = "getData")
    public void pLoan(String username, String password){
        System.out.println("Goods");
        System.out.println(username);
        System.out.println(password);
    }

    @BeforeTest
    public void prerequisite(){
        System.out.println("I will execute first");
    }

    @DataProvider
    public Object[][] getData(){
        // populate your data here
        // 1st combination - username = "abc" and password = "152"  - good credit history
        // 2nd combination - username = "pqr" and password = "252"  - no credit history
        // 3rd combination - username = "xyz" and password = "743"  - bad credit history
        Object[][] data = new Object[3][2];
        // 1st set
        data[0][0] = "1st username";
        data[0][1] = "1st password";
        // columns in the row are nothing but values for that particular combination(row)
        // 2nd set
        data[1][0] = "2nd username";
        data[1][1] = "2nd password";
        // 3rd set
        data[2][0] = "3rd username";
        data[2][1] = "3rd password";
        return data;
    }








}
