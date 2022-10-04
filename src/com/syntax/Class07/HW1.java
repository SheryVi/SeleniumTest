package com.syntax.Class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HW1 {
    /*
    Go to http://demoqa.com/browser-windows
    click on New Tab and print the text from new tab in the console
    click on New Window and print the text from new window in the console
    click on New Window Message and print the text from new window in the console
    Verify (compare)the titles for each page
    Print out the title of the all pages
    */
    public static String url = "http://demoqa.com/browser-windows";
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        String mainPageHandle = driver.getWindowHandle();
        WebElement elem1 = driver.findElement(By.id("tabButton"));
        WebElement elem2 = driver.findElement(By.id("windowButton"));
        WebElement elem3 = driver.findElement(By.id("messageWindowButton"));

        elem1.click();
        elem2.click();
        elem3.click();

       Set<String> allWindows = driver.getWindowHandles();
        System.out.println(allWindows.size());



        Iterator<String> it = allWindows.iterator();
        while (it.hasNext()){
            String handle = it.next();
            if(!mainPageHandle.equals(handle));
          //  driver.switchTo().window(handle);
            String text = driver.getTitle();
            System.out.println(text);
        }
        }
}

