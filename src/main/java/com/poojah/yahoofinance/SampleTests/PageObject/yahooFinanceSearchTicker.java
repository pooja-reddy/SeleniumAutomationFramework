package com.poojah.yahoofinance.SampleTests.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.lang.String;

/**
 * @author Poojah Reddy
 * @License OpenSource Framework For Selenium Tests
 * @Version: v1.0
 * 
 */

public class yahooFinanceSearchTicker {

	@FindBy(css="input.Pos\\(r\\)")
	private WebElement SearchBar;
	
	@FindBy(css="#search-button")
	private WebElement searchButton;
	
	@FindBy(css="div.W\\(1\\/2\\):nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > span:nth-child(1)")
	private WebElement TickerIndexValue;
	
	public String getTickerValue(WebDriver driver,String ticker) throws WebDriverException
	{	
		enterSearchBarText(driver,ticker);
		clickSearchButton(driver);
		System.out.println(TickerIndexValue.getText());
		return TickerIndexValue.getText();
	}
	
	public void enterSearchBarText(WebDriver driver,String ticker) throws WebDriverException
	{
		SearchBar.sendKeys(ticker);
		
	}	
	
	public void clickSearchButton(WebDriver driver)throws WebDriverException
	{
		searchButton.click();
	}
	
	
}
