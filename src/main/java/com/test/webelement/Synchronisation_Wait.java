package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Synchronisation_Wait {
    public static void main(String[] args) throws InterruptedException {
        // before u use text locator, u need to make sure the element is static or dynamic, if it is dynamic, u cant use it, only static text locator is used.
        //both implicit and explicit wait are both used to achieved synchronization problem in selenium
        //implicit wait is global, explicit wait is local           //implicit wait is applied to whole page, explicit wait is applied to specific element
        // Implicit wait Pros: readable code. Cons: performance issues are not caught. if page suppose to load for 2sec, and load for 4sec n 5sec is set. u wont notice because it will still pass.
        //Explicit wait Pros: applied only at targeted element. so no performance issues. Cons: More code to write.

        WebDriver driver = new ChromeDriver();

    //implicit wait
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    //explicit wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        Thread.sleep(3000);

        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i < products.size(); i++) {

//Brocolli - 1 Kg
//Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();

//format it to get actual vegetable name
//convert array into array list for easy search
//  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);
            if (itemsNeededList.contains(formattedName)) {

                j++;
//click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                if (j == itemsNeeded.length) {
                    break;
                }
            }
        }
    }

}




