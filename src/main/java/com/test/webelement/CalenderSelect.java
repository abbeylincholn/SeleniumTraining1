package com.test.webelement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class CalenderSelect {
    public static void main(String[] args) throws InterruptedException {

        //TestNG and JUnit Framework are one of the assertion framework, but we are using TestNG

        //Selecting Curent Date
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.xpath("(//div[@class='picker-first2']//button[@class='ui-datepicker-trigger'])[1]")).click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();

        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        driver.findElement(By.name("ctl00$mainContent$view_date2")).click();
        System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
        //driver.quit();
    }
}
