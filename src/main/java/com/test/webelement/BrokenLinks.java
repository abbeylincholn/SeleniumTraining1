package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.net.*;


public class BrokenLinks {
    public static void main(String[] args) throws MalformedURLException, IOException {

        //Broken url
        //Step 1: get all urls tied up to the links using selenium
        // Java methods will call URL's and gets you the status code
        // if status code is greater than 400, then url is not working, then it is a broken link
        //'a[href*="soapui"]'
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String url = driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");

        URL link = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) link.openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();

        int responseCode = conn.getResponseCode();
        System.out.println(responseCode);





    }

}
