package com.waits;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.iframe.IframeActions;
import com.report.ExtentFactory;
/*import com.report.ExtentReportManager;*/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitActions {

    private Logger logger = LogManager.getLogger(ExplicitWaitActions.class);

    public void waitForElementToBePresent(WebElement element,String elmentName){

        try {

            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOf(element));

            logger.info(elmentName + " is available on screen");
        }catch (Exception e){
            logger.error("Exception occured while waiting to visible "+e.getMessage());
        }

    }

    public void waitForElementToClickable(WebElement element,String elmentName){

        try {

            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));
            wait.until(ExpectedConditions.elementToBeClickable(element));

            logger.info(elmentName + " is clickable on screen");
        }catch (Exception e){
            logger.error("Exception occured while waiting to click the element "+e.getMessage());

        }



    }
}
