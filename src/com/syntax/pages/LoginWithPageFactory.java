package com.syntax.pages;

import com.syntax.utils.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginWithPageFactory extends CommonMethods {


    @FindBy(id =  "txtUsername")
    public WebElement username;

    @FindBy(xpath = "//input[@id = 'txtPassword']")
    public WebElement password;

    @FindBy (css = "input#btnLogin")
    public WebElement loginButton;

    public LoginWithPageFactory(){
        PageFactory.initElements(driver, this);
    }




}