package com.poojah.yahoofinance.SampleTests.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.google.inject.Binder;
import com.google.inject.Module;

import io.github.bonigarcia.wdm.ChromeDriverManager;

/**
 * @author Poojah Reddy
 * @License OpenSource Framework For Selenium Tests
 * @Version: v1.0
 * 
 */

public class DriverBinder implements Module {
	private static final Logger logger = LogManager.getLogger(DriverBinder.class);
	public void configure(Binder binder) {
        BrowserLauncher bl = new BrowserLauncher();
        ChromeDriverManager.getInstance().setup();
        logger.info("Selecting the option of Browser to be :Chrome");
        WebDriver driver = bl.launchBrowser("chrome");
        binder.bind(WebDriver.class).toInstance(driver);
    }
}