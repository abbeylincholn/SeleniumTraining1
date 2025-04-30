package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Valid_UIElementDisableorEnable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("(//div[@class='picker-first2']//button[@class='ui-datepicker-trigger'])[1]")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
        System.out.println(driver.findElement(By.id("Div1")).getDomAttribute("style"));
        if (driver.findElement(By.id("Div1")).getDomAttribute("style").contains("0.5")) {
            System.out.println("It is Enabled");
            Assert.assertTrue(true);
        } else {
            System.out.println("It is Disabled");
            Assert.assertTrue(false);
        }
    }

}
