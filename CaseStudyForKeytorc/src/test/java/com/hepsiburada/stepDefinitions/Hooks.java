package com.hepsiburada.stepDefinitions;


import com.hepsiburada.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Hooks {
    Logger logger = LoggerFactory.getLogger(Hooks.class);
    @Before
    public void setUp(){
        logger.info("##### HEPSIBURADA STARTED (HOOK) ######");
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            logger.error("!!!!Test Failed! check the screenshot!!!!");
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }else {
            logger.info("Test Completed");
        }
        logger.info("###### END OF THE HEPSIBURADA TESTS #####");

        Driver.close();

    }




}
