/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.Pages;

import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.BasePage;
import com.driver.DriverFactory;
import com.utility.screenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class sales extends BasePage {


    @FindBy(xpath = "//p[text()='Sale']")
    WebElement Sale;

    @FindBy(xpath = "//a[text()=\"d'336'f\"]")
    WebElement salesOrder;

    @FindBy(id = "iframeReport")
    WebElement Iframe;

    @FindBy(xpath = "//a[text()='Create Packing']")
    WebElement createLabel;
    @FindBy(xpath = "(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[1]")
    WebElement packingType;

    @FindBy(xpath = "(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
    WebElement shippingAgent;

    @FindBy(xpath = "(//select[@class='form-control ng-untouched ng-pristine ng-valid'])[2]")
    WebElement shippingMethod;

    @FindBy(xpath = "(//select[@class=' form-control ng-valid ng-dirty ng-touched'])[2]")
    WebElement shippingMethod1;


    @FindBy(xpath = "(//input[@type='date'])[1]")
    WebElement packingDate;

    @FindBy(xpath = "(//input[@type='date'])[2]")
    WebElement shippingDate;

    @FindBy(xpath = "(//textarea[@placeholder='Enter packing notes'])")
    WebElement Notes;

    @FindBy(xpath = "//option[text()='FedEx First Overnight']")
    WebElement shipingMethodName;

    @FindBy(xpath = "//button[text()='Add Package']")
    WebElement addPackage;

    @FindBy(xpath = "//b[text()='Manage Packages']")
    WebElement managePackage;

    @FindBy(xpath = "//input[@type='number']")
    WebElement packageWeight;

    @FindBy(xpath = "//button[text()='Create Label']")
    WebElement createLabelNow;

    @FindBy(xpath = "//button[text()='Ok']")
    WebElement OkLabel;

    @FindBy(id = "toast-container")
    WebElement error;

    @FindBy(xpath = "(//button[@class='accordion-button accordian-heading'])[2]")
    WebElement addToPackage;

    @FindBy(xpath = "//button[text()='Ok']")
    WebElement OkCTA;

    @FindBy(xpath = "(//a[@class='create-packing'])[1]")
    WebElement selectPacking;

    @FindBy(xpath = "//button[text()='Void Label']")
    WebElement voidCTA;

    Select select2 = null;


    public sales() {
        PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
    }


    public void SalesClick(String shipping) throws InterruptedException, IOException {
        super.click(Sale, "sales link");
        this.click(salesOrder, "sales order");
        List<String> listofPages = new ArrayList<String>(DriverFactory.getInstance().getDriver().getWindowHandles());
        DriverFactory.getInstance().getDriver().switchTo().window(listofPages.get(1));
        DriverFactory.getInstance().getDriver().switchTo().frame(Iframe);
        this.click(createLabel, "create label");
        this.click(OkCTA, "ok button");


        this.isElementVisible(shippingAgent, "shipping agent avaliable");
        //packingType.click();
        /* Select select = new Select(packingType);

        select.selectByVisibleText("API");*/

        Select select1 = new Select(shippingAgent);
        Thread.sleep(3000);
        select1.selectByVisibleText("UPS (MetaOption LLC)");


        Thread.sleep(3000);

        try {
            select2 = new Select(shippingMethod1); // Try the first dropdown
            select2.selectByVisibleText(shipping); // Select the shipping method
        } catch (NoSuchElementException e) {
            System.out.println("Shipping method 1 not found, trying shipping method 2.");
            select2 = new Select(shippingMethod); // Fall back to the second dropdown
            select2.selectByVisibleText(shipping); // Select the shipping method
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = today.format(formatter);
        this.isClickable(createLabelNow, "create label");

        this.sendKeys(Notes, "Notes", "testing");

        // Set the value of the date input field
        packingDate.sendKeys(formattedDate);
        Thread.sleep(4000);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", managePackage);
        Thread.sleep(4000);
        js.executeScript("window.scrollBy(0, 65000);");


        this.click(managePackage, "Manage package");
        Thread.sleep(2000);
        this.click(addPackage, "Add Package");
        Thread.sleep(2000);
        this.sendKeys(packageWeight, "Package weight", "2");
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);", createLabelNow);
        Thread.sleep(2000);
        this.isClickable(createLabelNow, "Create Label");
        this.click(createLabelNow, "Create Label");
        this.click(OkLabel, "OK button");
        this.isElementVisible(error, "toast error");

        System.out.println("Message --> "+ error.getText());
        String message = error.getText();
        Assert.assertEquals(message, "×\n" +
                "Packing processed successfully");


        try {
            this.click(selectPacking, "Select packing button ");
            Thread.sleep(3000);
            screenshot.screenshotMethod();
            Thread.sleep(4000);
            this.click(voidCTA, "voided shippment button ");
            this.click(OkCTA, "Ok button");
            this.isElementVisible(error, "toast error");

            System.out.println("message" + error.getText());
        } catch (NoSuchElementException e) {
            screenshot.screenshotMethod();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

    }
}
