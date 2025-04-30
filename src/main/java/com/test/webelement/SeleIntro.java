package com.test.webelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleIntro {
    public static void main(String[] args) {

        // Invoking Browser
        // Chrome - ChromeDriver -> Methods
        // Firefox - FirefoxDriver

        // locally invocation of chrome driver
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Engr. Abbey\\Downloads\\chromedriver-win64\\chromedriver.exe");          // this will off the SelenimManager

        // chromedriver.eve -> chrome browser
        // Selenium manager invokes the chrome driver globally
        //ChromeDriver driver = new ChromeDriver();

        // Absolute path & relative path

        WebDriver driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
        driver1.get("https://www.google.com");
        driver1.navigate().to("https://www.facebook.com");
        driver1.navigate().back();
        driver1.navigate().forward();
        System.out.println("Page title: " + driver1.getTitle());
        driver1.close();






    }
}
