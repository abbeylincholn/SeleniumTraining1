package com.test.upload_autoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.csm-testcenter.org/test?do=show&subdo=common&test=file_upload");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@name='file_upload'])[1]")).click();
        Thread.sleep(3000);

        //wait for the AutoIT video to understand how to use it, cos the website is not allowing me to upload files directly

    }
}
