package com.syntax.Class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Recap {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://vk.com/");
        driver.manage().window().maximize();
        driver.getTitle();
        String title = driver.getTitle();
        String expectedTitle = "Welcome! | VK";
        if(title.equals(expectedTitle)){
            System.out.println("Title is correct");
        }else {
            System.out.println("Title Incorrect");
        }
        driver.quit();
    }
}
