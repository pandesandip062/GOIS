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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {


    @FindBy(xpath = "//span[text()='Products']")
    WebElement product;
    @FindBy(id = "AddProduct")
    WebElement addProduct;

    @FindBy(id = "ddlOrg")
    WebElement orgnizationSelect;

    @FindBy(id = "btnSelect")
    WebElement selectButton;

    @FindBy(xpath = "//option[text()='Sandip_org']")
    WebElement sandipOrg;
    public ProductPage(){
        PageFactory.initElements(DriverFactory.getInstance().getDriver(),this);
    }

    public void addProduct(){

        Actions select = new Actions(DriverFactory.getInstance().getDriver());
        select.click(product).perform();
        select.click(addProduct).perform();
        orgnizationSelect.click();
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", sandipOrg);

        // Click the element after scrolling it into view
        sandipOrg.click();

       // select1.selectByValue("Sandip_org");
        this.click(selectButton,"clicked on selectButton");

    }
}
