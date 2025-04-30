package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class BrokenLinks2 {
    public static void main(String[] args) throws MalformedURLException, IOException {

        //Broken url
        //Step 1: get all urls tied up to the links using selenium
        // Java methods will call URL's and gets you the status code
        // if status code is greater than 400, then url is not working, then it is a broken link
        //'a[href*="soapui"]'
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        SoftAssert sa = new SoftAssert();
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            URL linkUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println(link.getText() + " - " + responseCode);
            sa.assertTrue(responseCode < 400, "The link with text " + link.getText() + " is broken with code " + responseCode);

            /*if(responseCode >= 400) {
                System.out.println("The link with text " + link.getText() + " is broken with code " + responseCode);
                Assert.assertTrue(true);
            }*/
        }
        sa.assertAll();
        driver.quit();






    }

}
