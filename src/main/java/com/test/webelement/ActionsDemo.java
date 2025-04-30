package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class ActionsDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        Actions action = new Actions(driver);
        WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));


        action.moveToElement(driver.findElement(By.cssSelector("#twotabsearchtextbox"))).click().keyDown( Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        //Move to specific element
        action.moveToElement(move).contextClick().build().perform();

    }
}
