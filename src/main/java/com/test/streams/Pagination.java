package com.test.streams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) {
        // Streams, Lambda Expressions, Method references, Pagination
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // click on column
        driver.findElement(By.cssSelector("th:nth-child(1)")).click();

    /*
        // capture all web elements into list
       List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        // capture text of all web elements into new (original) list
        List<String> originalList = elementList.stream().map(x -> x.getText()).collect(Collectors.toList());
        // sort in the list of step 3 -> sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        // compare original list with sorted list
        Assert.assertTrue(originalList.equals(sortedList));*/


        // scan the name column with getText() method ->  Beans -> print the price of the Beans
        List<String> price;
        do{
            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
        price = rows.stream().filter(x -> x.getText().contains("Rice"))
                .map(x -> getPriceVeggie(x)).collect(Collectors.toList());
        price.forEach(System.out::println);

        if(price.size() < 1) {
            driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
        }
        } while (price.size() < 1);

    }

    private static String getPriceVeggie(WebElement x) {
        String priceValue = x.findElement(By.xpath("following-sibling::td[1]")).getText();
        return priceValue;
    }


}
