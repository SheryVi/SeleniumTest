package com.syntax.Class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class practiceDD {

    public static String url = "https://www.ebay.com/";
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement catigoriesDD = driver.findElement(By.xpath("//select[@class = 'gh-sb ']"));
        Select select = new Select(catigoriesDD);

        List<WebElement> options = select.getOptions();
        for(WebElement option: options){
            String optionText = option.getText();
            System.out.println(optionText);
        }
       WebElement value = driver.findElement(By.xpath("//option[@value = '11232']"));
       String text =  value.getText();
        System.out.println("text = "+text);

    }
}
