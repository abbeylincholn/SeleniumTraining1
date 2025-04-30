package com.test.webelement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //driver.manage().deleteCookieNamed("name");
        //driver.manage().addCookie(new org.openqa.selenium.Cookie("name", "value"));

        // click on any link
            // login page - verify login url

        driver.get("https://google.com");
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    // screenshot as a file
        FileUtils.copyFile(src, new File("C:\\Users\\Engr. Abbey\\Downloads\\screenshot.png"));
    }
}
