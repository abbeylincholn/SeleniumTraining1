package com.test.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope_E2E {

    public static void main(String[] args) throws InterruptedException {
        // Give me the count of links on the page. Every link will have a tag name <a>

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");;
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Count of links in footer
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));  //limiting wevebdriver scope
        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // Count of links in column
        WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(columnDriver.findElements(By.tagName("a")).size());

        // Click on each link in the column and check if the pages are opening or not
        for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++){
            // Approach 1
            /*columnDriver.findElements(By.tagName("a")).get(i).click();
            driver.navigate().back(); */ // to go back to previous page but it is not a good practice

            //Approach 2  , better than approach 1
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(2000);

        }

        //Switching to new window and print the title
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();

        while (it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }

        /* In one of my previous automation projects, we had a requirement to validate around 30 links on a page. Initially, our approach was quite straightforward but inefficient—we had a script that
        would click each link one by one, navigate to the new page, perform the validation, then return to the main page and repeat the process for every single link.
        This method was time-consuming and took about 5 to 15 minutes to complete, depending on system speed and network conditions.I realized there was room for optimization,
        so I introduced a new approach to handle this more efficiently. Instead of sequentially clicking and navigating back and forth, I updated the script to open all the 30 links in separate tabs simultaneously.
        Each tab would load the link independently, perform its validation, and then close. This parallel processing drastically reduced the execution time—from 15 minutes down to just about a minute.
        This change significantly improved our regression testing speed, and it was well appreciated by my team. It’s a great example of how I brought in a unique,
        performance-optimized solution that made a tangible impact on the project. */

    }
}
