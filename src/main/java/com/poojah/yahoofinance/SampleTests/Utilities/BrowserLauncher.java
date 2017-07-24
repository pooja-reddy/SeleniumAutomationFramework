package com.poojah.yahoofinance.SampleTests.Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

/**
 * @author Poojah Reddy
 * @License OpenSource Framework For Selenium Tests
 * @Version: v1.0
 * 
 */

public class BrowserLauncher {
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BrowserLauncher.class);
	
	@Parameters({"browser"})
	public WebDriver launchBrowser(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			logger.info("Chrome driver initialized");
			driver = new ChromeDriver();
		}
		return driver;
	}
}