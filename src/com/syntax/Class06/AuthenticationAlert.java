package com.syntax.Class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {

    public static String url = "http://admin:admin@the-internet.herokuapp.com/basic_auth";
                                //username:password@
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
}