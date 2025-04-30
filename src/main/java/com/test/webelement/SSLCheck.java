package com.test.webelement;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SSLCheck {
    public static void main(String[] args) {

        //HTTPS Certifications
        FirefoxOptions options1 = new FirefoxOptions();
        EdgeOptions options2 = new EdgeOptions();
        SafariOptions options3 = new SafariOptions();

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddres: 127.0.0.1:8888");
        options.setCapability("proxy", proxy);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
