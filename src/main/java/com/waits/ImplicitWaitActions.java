package com.waits;

import com.constants.Constants;
import com.driver.DriverFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;


public class ImplicitWaitActions {

    private Logger logger = LogManager.getLogger(ImplicitWaitActions.class);
    public void setimplicitWait(){

        try {
            DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
            logger.info("Implict wait time is set to" + Constants.IMPLICIT_WAIT_TIME);
        } catch (Exception e) {
            logger.error("Error occured while setting the implicit wait"+e.getMessage());
        }
    }
}
