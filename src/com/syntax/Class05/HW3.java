package com.syntax.Class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW3 {

    public static String url = "https://aliexpress.ru/";

    public static void main(String[] args) throws InterruptedException {

        //go to https://www.ozon.ru/
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        WebElement vezButtn = driver.findElement(By.xpath("//div[@class = 'SearchHeader_CategoriesWithToggleButton__toggleButton__glwxj']"));
        vezButtn.click();




//get all the categories and print them in console
//select Computers/Tables & Networking
// click on search



    }
}
