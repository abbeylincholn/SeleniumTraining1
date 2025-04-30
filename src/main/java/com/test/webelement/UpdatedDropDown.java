package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropDown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        int i=1;
        /*while (i<5){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }*/

        /*do{
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }while(i<5);*/

        for(int j=1;j<5;j++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }


        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        driver.quit();

    }
}
