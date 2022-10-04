package com.syntax.Class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HWCalendar {
    public static String url = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement userName = driver.findElement(By.xpath("//input[@id = 'txtUsername']"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//input[@name = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.xpath(" //input[@type = 'submit']"));
        loginButton.click();
        WebElement leaveButton = driver.findElement(By.id("menu_leave_viewLeaveModule"));
        leaveButton.click();

        WebElement listButton = driver.findElement(By.id("menu_leave_viewLeaveList"));
        listButton.click();

        WebElement fromCalendar = driver.findElement(By.id("calFromDate"));
        fromCalendar.click();
        WebElement monthDD = driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));
        Select select = new Select(monthDD);
        select.selectByVisibleText("Jan");
        List<WebElement> fromDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement fromDate : fromDates) {
            String dateText = fromDate.getText();
            if(dateText.equals("7")){
                fromDate.click();
            }
        }
        WebElement toCalendar = driver.findElement(By.id("calToDate"));
        toCalendar.click();

        WebElement monthDDD =driver.findElement(By.xpath("//select[@class = 'ui-datepicker-month']"));
        Select select1 = new Select(monthDDD);
        select1.selectByVisibleText("Jul");
        List<WebElement> toDates = driver.findElements(By.xpath("//table[@class = 'ui-datepicker-calendar']/tbody/tr/td"));
        for (WebElement toDate: toDates){
            String dateTextt = toDate.getText();
            if(dateTextt.equals("7")){
                toDate.click();
            }
        }

        WebElement cancelledButton = driver.findElement(By.id("leaveList_chkSearchFilter_0"));
        cancelledButton.click();

        WebElement rejectedButton = driver.findElement(By.id("leaveList_chkSearchFilter_-1"));
        rejectedButton.click();

        WebElement pendingButton = driver.findElement(By.id("leaveList_chkSearchFilter_1"));
        pendingButton.click();

        WebElement fromDD = driver.findElement(By.xpath("//select[@name = 'leaveList[cmbSubunit]']"));
        Select select2 = new Select(fromDD);
        select2.selectByVisibleText("IT Support");

        WebElement searchButton = driver.findElement(By.id("btnSearch"));
        searchButton.click();

        driver.quit();






    }
}
/*
* HW Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
click on leave
click on leave list
choose from "From calendar"
choose from "To calendar"
click only on cancelled and rejected checkboxes
uncheck Pending Approval
select IT support from DD
click search
quit browser*/