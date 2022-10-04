package com.syntax.Class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HW {
    public static String url = "http://aa.com/homepage.do";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement calendar = driver.findElement(By.className("ui-datepicker-trigger"));
        calendar.click();

        WebElement dMonth = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/div/div"));
        String dMonthText = dMonth.getText();

        WebElement nextButton = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a"));
        while (!dMonthText.equals("November")){
            nextButton.click();
            dMonthText = dMonth.getText();
        }
        List<WebElement> departDates = driver.findElements(By.xpath("//div[@class = 'ui-datepicker-group ui-datepicker-group-last']/table/thead/following-sibling::tbody/tr/td"));
        for(WebElement departDate: departDates){
            if(departDate.getText().equals("13")){
                departDate.click();
                break;
            }
        }


        /*
        * HW
Go to aa.com/homepage.do
select depart date
select return date
select destination
click on search
quit the browser

        * */

    }

}
