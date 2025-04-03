package com.iframe;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.report.ExtentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;


public class IframeActions {

    private Logger logger = LogManager.getLogger(IframeActions.class);

    public void waitForInframeAndSwitchFrame(String idorName) throws IOException {

        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idorName));

            logger.info("Switched to iframe");
            ExtentFactory.passTest("switched to iframe");
        } catch (Exception e) {
            logger.error("Error occurted while switching frame");
            ExtentFactory.failTest("Error occured while switching iFrame");
        }

    }

    public void waitForIframeAndSwitch(int index) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));

            logger.info("Switched to iframe");
            ExtentFactory.passTest("switched to iframe");
        } catch (Exception e) {
            logger.error("Error occurted while switching frame");
            ExtentFactory.failTest("Error occured while switching iFrame");
        }
    }

    public void switchToDefaultFrame() throws IOException {

        try{
        DriverFactory.getInstance().getDriver().switchTo().defaultContent();
        logger.info("Switched to defaultFrame");
        ExtentFactory.passTest("switched to defaultFrame");
    } catch (Exception e) {
        logger.error("Error occurted while switching defaultFrame");
        ExtentFactory.failTest("Error occured while switching defaultFrame");
    }
    }
}
