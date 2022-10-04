package com.syntax.Class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class CalendarHandling {
    public static String url = "http://delta.com";

    /*
    * navigation to delta
    * choosing departure and return dates
    *
    * */
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement calendar = driver.findElement(By.id("input_departureDate_1"));
        calendar.click();

        WebElement nextButton = driver.findElement(By.xpath("//span[text() = 'Next']"));
        WebElement dMonth = driver.findElement(By.xpath("//span[@class= 'dl-datepicker-month-0']"));
        String dMonthText = dMonth.getText();

        while (!dMonthText.equals("November")){
            nextButton.click();
            dMonthText = dMonth.getText();
        }
        List<WebElement> departDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-0']/tr/td"));
        for(WebElement departDate: departDates){
            if(departDate.getText().equals("13")){
                departDate.click();
                break;
            }
        }
        WebElement rMonth = driver.findElement(By.className("dl-datepicker-month-1"));
        String rMonthText = rMonth.getText();

        while (!rMonthText.equals("January")){
            nextButton.click();
            rMonthText = rMonth.getText();
        }
        List<WebElement> returnDates = driver.findElements(By.xpath("//tbody[@class = 'dl-datepicker-tbody-1']/tr/td"));
        for (WebElement returnDate: returnDates){
            if(returnDate.getText().equals("30")){
                returnDate.click();
                break;
            }
        }

        WebElement doneButton = driver.findElement(By.xpath("//button[@class = 'donebutton']"));
        doneButton.click();


    }

    }
