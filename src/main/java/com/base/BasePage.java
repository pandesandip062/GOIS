package com.base;

import com.iframe.IframeActions;
import com.report.ExtentFactory;
import com.waits.ExplicitWaitActions;
import org.openqa.selenium.WebElement;

public class BasePage {


    protected IframeActions iframeActions;

    protected ExplicitWaitActions explicitWaitActions;

    protected BasePage(){
        iframeActions = new IframeActions();
        explicitWaitActions = new ExplicitWaitActions();
    }

    public void click(WebElement element,String elementname){
        explicitWaitActions.waitForElementToClickable(element,elementname);
        element.click();
        ExtentFactory.passTest(elementname+"is clicked");
    }

    public void sendKeys(WebElement element,String elementName,String value){
        explicitWaitActions.waitForElementToBePresent(element,elementName);
        element.clear();
        element.sendKeys(value);
        ExtentFactory.passTest(value+"is entered in"+elementName);
    }

    public boolean isElementSelected(WebElement element,String elementName){
        explicitWaitActions.waitForElementToBePresent(element,elementName);
        return element.isSelected();
    }

    public boolean isElementVisible(WebElement element,String elementName){
        explicitWaitActions.waitForElementToBePresent(element,elementName);
        return element.isDisplayed();
    }

    public boolean isClickable(WebElement element,String elementName){
        explicitWaitActions.waitForElementToClickable(element,elementName);
        return element.isEnabled();
    }
}
