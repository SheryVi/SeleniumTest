package com.syntax.Class05;
//go to https://www.ozon.ru/
//get all the categories and print them in console
//select Computers/Tables & Networking
// click on search


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW2 {
    //public static String url = "https://www.ozon.ru/";
    public static void main(String[] args) {

        //go to https://www.ozon.ru/
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links "+allLinks.size());

       for (WebElement link : allLinks){
            String linkText = link.getText();
            String fullText = link.getAttribute("href");
            if(!linkText.isEmpty()){
                System.out.println(linkText+ "    "+fullText);
            }
        }

    }
}
