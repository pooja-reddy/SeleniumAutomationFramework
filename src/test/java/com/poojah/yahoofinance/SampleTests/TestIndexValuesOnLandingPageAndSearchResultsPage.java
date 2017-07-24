package com.poojah.yahoofinance.SampleTests;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.google.inject.Inject;
import com.poojah.yahoofinance.SampleTests.PageObject.yahooFinanceLandingPage;
import com.poojah.yahoofinance.SampleTests.PageObject.yahooFinanceSearchTicker;

/**
 * @author Poojah Reddy
 * @License OpenSource Framework For Selenium Tests
 * @Version: v1.0
 * 
 */

@Guice(modules = {com.poojah.yahoofinance.SampleTests.Utilities.DriverBinder.class})
public class TestIndexValuesOnLandingPageAndSearchResultsPage {
	@Inject
	private WebDriver driver;
	private static final Logger logger = LogManager.getLogger(TestIndexValuesOnLandingPageAndSearchResultsPage.class);
	
	
	  @DataProvider(name = "SampleTestCases")
	  public static Object[][] tickerSymbols() {
		  logger.info("\nOrganising the Data using the DataProvider Object in TestNG");
	        return new Object[][]{ {"SP500","^GSPC"},{"Dow30","^DJI"},{"Nasdaq","^IXIC"}};
	 
	  }
	
	/*
	 * Functionality to be called before executing the actual Tests.
	 * In most cases you have the following implemented before running the tests
	 * 
	 * 1. Pre-requisites for the Tests Cases.
	 * 2. Load Files required for the test scripts.
	 * 3. Implement or Fetch Test Data
	 * 4. Establish Database connections for fetching data 
	 */
	  
	@Parameters({"yahooFinanceURL"})
	@BeforeClass
    public void invokeURL(String salesforceURL) {
		logger.info("\n Navigate to Yahooo Finance URL");
		driver.get(salesforceURL);
		logger.info("\n Maximize Yahooo Finance chrome Browser Window");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }
	
	/*
	 * 
	 * Test Method to check if the values for the three Stock Indexes (SP500,Nasdaq,Dow Jones ) 
	 * are displayed by using the search ToolBar on the Landing Page.We test the Previous Close values for 
	 * the Indexes(SP500,Nasdaq,Dow Jones) by verifying that the values are present for every Index.
	 * 
	 */
	
	@Test(dataProvider = "SampleTestCases")
	public void testIndexValuesFromSearch(String tickerName,String ticker)
	{
		logger.info("\n\n Test# to verify that the previous close values for the Indexes (SP500,DOW30,Nasdaq) are populated using Search Bar on the Landing Page");	
		yahooFinanceSearchTicker yahooFST=PageFactory.initElements(driver, yahooFinanceSearchTicker.class);
		try
		{
		Assert.assertNotNull(yahooFST.getTickerValue(driver, ticker));		
		}
		catch(WebDriverException ex)
		{
			logger.error("Exception:" + ex);
		}
	}
	
	/*
	 * 
	 * Test Method to check if the values for the three Stock Indexes (SP500,Nasdaq,Dow Jones ) 
	 * are displayed on the Yahoo Finance Home Page
	 * 
	 */
	
	@Test
	public void testIndexValuesOnLandingPage()
	{	logger.info("\n\n Test# to verify that the Index values(SP500,DOW30,Nasdaq) are populated on the landing page of yahoo finance");
		yahooFinanceLandingPage yahooFLP= PageFactory.initElements(driver, yahooFinanceLandingPage.class);
		try
		{
			logger.info("\n Value of "+yahooFLP.getSDow30IndexValue(driver)+" Is dispalyed for Dow Jones Index on the yahoofinance homepage");
			Assert.assertNotNull(yahooFLP.getSDow30IndexValue(driver));
			
			logger.info("\n Value of "+yahooFLP.getNasdaqIndexValue(driver)+" Is dispalyed for Nasdaq Index on the yahoofinance homepage");
			Assert.assertNotNull(yahooFLP.getNasdaqIndexValue(driver));
			
			logger.info("\n Value of "+yahooFLP.getSP500IndexValue(driver)+" Is dispalyed for SP500 Index on the yahoofinance homepage");
			Assert.assertNotNull(yahooFLP.getSP500IndexValue(driver));
		}
		catch( WebDriverException ex)
		{
			logger.error("Exception:" + ex);
		}
		
	}
	
	/*
	 * Functionality to be called after executing the actual Tests.
	 * In most cases you have the following implemented after running the test scripts
	 * 
	 * 1. Close File Handlers
	 * 2. Close connection to the various browsers.
	 * 3. Close Database connections
	 * 4. Clean Up Test Data and restore the application under test(AUT) to the pre-test run stage. 
	 */
	
	@AfterClass
    public void closeBrowser() {
		logger.info("\n----------------End of Tests -------------");
		driver.quit();
    }

	
}