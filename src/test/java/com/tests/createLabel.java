/*
 * Copyright (c) 2025. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.tests;

import com.Pages.LoginPage;
import com.Pages.sales;
import com.base.BaseTest;
import com.driver.DriverFactory;
import com.properties.TestDataLoader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class createLabel extends BaseTest {


   /* @DataProvider(name = "shippingData")
    public Object[][] getUsernameData() {
        // Returns a 2D array with a single string element
        return new Object[][] {
                {"FEDEX_GROUND"},  // First set of data
                {"FedEx First Overnight"},  // Second set of data
                {"FedEx First Overnight Freight"}   // Third set of data
        };
    }*/

    @DataProvider(name = "shippingData")
    public Object[][] getUsernameData() {
        // Returns a 2D array with a single string element
        return new Object[][] {
               // {"FEDEX_GROUND"},
              /* {"FedEx International Priority Express"},
                {"FedEx First Overnight"},
                {"FedEx First Overnight Freigh"},*/
              {"FedEx 1Day Freight"},
                /*{"FedEx 2Day Freight"},
                {"FedEx 3Day® Freight"},
                {"FedEx Home Delivery"},
                {"FedEx Express Saver"},
                {"FedEx SameDay"},
                {"FedEx SameDay City"}*/


        /*return new Object[][]{

                {"Next Day Air Saver"}*/
              /*  {"Next Day Air"},
                {"2nd Day Air"},
                {"FedEx First Overnight"},
                {"Ground"},
                {"Express"},
                {"Expedited"},
                {"UPS Standard"},
                {"3 Day Select"},
                {"Next Day Air Saver"},
                {"UPS Next Day Air Early"},
                {"UPS Worldwide Economy DDU"},
                {"Express Plus"},
                {"2nd Day Air A.M"},
                {"UPS Standard"},
                {"UPS Saver"},
                {"First Class Mail"},
                {"Priority Mail"},
                {"Economy Mail Innovations"},
                {"UPS Next Day Air Early"},
                {"UPS Worldwide Economy DDU"},
                {"Express Plus"},
                {"2nd Day Air A.M"},
                {"UPS Standard"},
                {"UPS Saver"},
                {"First Class Mail"},
                {"Priority Mail"},
                {"Economy Mail Innovations"},
                {"UPS Next Day Air Early"},
                {"Mail Innovations (MI) Returns"},
                {"UPS Access Point Economy"},
                {"UPS Worldwide Express Freight Midday"},
                {"UPS Worldwide Economy DDP"},
                {"UPS Express 12:00"},
                {"UPS Heavy Goods"},
                {"UPS Today Standard"},
                {"UPS Today Dedicated Courier"},
                {"UPS Today Intercity"},
                {"UPS Today Express"},
                {"UPS Today Express Saver"},
                {"UPS Worldwide Express Freight"}*/


        //UPS(MetaOption LLC)

        /*   return new Object[][]{

         *//* {"Next Day Air"},
                {"2nd Day Air"},
                {"Ground"},
                {"Express"},
                {"Expedited"},
                {"UPS Standard"},*//*
                {"3 Day Select"},*/
               /* {"Next Day Air Saver"},
                {"UPS Next Day Air Early"},
                {"UPS Worldwide Economy DDU"},
                {"Express Plus"},
                {"2nd Day Air A.M"},
                {"UPS Saver"},
                {"First Class Mail"},
                {"Priority Mail"},
                {"Expedited Mail Innovations"},*/
             /*   {"Priority Mail Innovations"},
                {"Economy Mail Innovations"},*/
               /* {"Mail Innovations (MI) Returns"},
                {"UPS Worldwide Economy DDU"},
                {"UPS Express 12:00"},
                {"UPS Heavy Goods"},
                {"UPS Today Standard"},
                {"UPS Today Dedicated Courier"},
                {"UPS Today Intercity"},
                {"UPS Today Express"},
                {"UPS Today Express Saver"},
*/

        //Purolator (Test User)


//        return new Object[][]{

              /*  {"PurolatorExpress"},
                {"PurolatorExpressEnvelope"},
                {"PurolatorExpress9AM"},
                {"PurolatorExpress10:30AM"},
                {"PurolatorExpress12PM"},
                {"PurolatorExpress10:30AM"},
                {"PurolatorExpressEvening"},
                {"PurolatorExpressEnvelope9AM"},
                {"PurolatorExpressEnvelope10:30AM"},
                {"PurolatorExpressEnvelope12PM"},
                {"PurolatorExpressEnvelopeEvening"},
                {"PurolatorExpressPack9AM"},
                {"PurolatorExpressPack12PM"},
                {"PurolatorExpressPack"},
                {"PurolatorExpressPackEvening"},*/
            //    {"Expedited Mail Innovations"},
              /*  {"PurolatorExpressBox9AM"},
                {"PurolatorExpressBox10:30AM"},
                {"PurolatorExpressBox12PM"},*/
                //{"PurolatorExpressBox"},
               // {"PurolatorExpressBoxEvening"},
             //   {"PurolatorGround"},
         //       {"UPurolatorGround9AM"},
               // {"PurolatorGround10:30AM"},
              //  {"PurolatorGroundEvening"},
               /* {"PurolatorQuickShip"},
                {"PurolatorQuickShipEnvelope"},

                {"PurolatorExpressPackU.S."},
                {"PurolatorExpressU.S.Pack9AM"},
                {"PurolatorExpressU.S.Pack12:00"},
                {"PurolatorExpressU.S.Box9AM"},
                {"PurolatorExpressU.S.Box10:30AM"},*/
                //{"PurolatorGroundU.S.0"},
              /*  {"PurolatorExpressU.S.Box12:00"},
                {"PurolatorExpressU.S.Box10:30AM"},*/


        };
    }



    @Test(dataProvider = "shippingData")
    public void createLabel(String shippingData) throws InterruptedException, IOException {


        //DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage();
        loginPage.loginApplication(TestDataLoader.getInstance().getUsername(), TestDataLoader.getInstance().getPassword());
        DriverFactory.getInstance().getDriver().manage().window().maximize();
        sales sale = new sales();
        sale.SalesClick(shippingData);


    }
}



