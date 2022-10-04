package com.syntax.Class05;
//go to ebay.com
//get all the categories and print them in console
//select Computers/Tables & Networking
// click on search
//verify the header


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW1 {
    //go to ebay.com
    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //get all the categories and print them in console
        WebElement AllCategories = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(AllCategories);

        List<WebElement> options = select.getOptions();
        for(WebElement option: options){
            String optionText = option.getText();
            System.out.println(optionText);
        }
        //select Computers
        select.selectByVisibleText("Computers");
        // click on search
        WebElement button = driver.findElement(By.id("nav-search-submit-button"));
        button.click();

        //verify the header
        String header = driver.getTitle();
        //System.out.println("Title is: "+header);
        if(header.equals("International Shopping: Shop Computers that Ship Internationally")){
            System.out.println("The header is correct");
        }
        else {
            System.out.println("The header is not correct!");
        }

        driver.quit();



    }
}
