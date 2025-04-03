/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.Pages;

import com.base.BasePage;
import com.driver.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "cphPage_txtLoginID")
    private WebElement useNameTextBox;

    @FindBy(id = "cphPage_txtPassword")
    private WebElement passwordTextBox;

    @FindBy(id = "cphPage_btnLogin")
    private WebElement loginBtn;

    @FindBy(xpath = "//div[text()='X']")
    private WebElement CancelCTA;


    public LoginPage(){
        PageFactory.initElements(DriverFactory.getInstance().getDriver(),this);
    }

    public void loginApplication(String userNamevalue,String passwordValue){
        super.sendKeys(useNameTextBox,"user name text box",userNamevalue);
        super.sendKeys(passwordTextBox,"Password text box",passwordValue);
        super.click(loginBtn,"login button");
        //super.click(CancelCTA,"ready to use GOIS");
    }

}
