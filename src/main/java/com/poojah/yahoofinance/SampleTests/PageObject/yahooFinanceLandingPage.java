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
public class yahooFinanceLandingPage {
	
	@FindBy(css="li.Bxz\\(bb\\):nth-child(1) > h3:nth-child(1) > span:nth-child(4)")
	private WebElement SP500;
	
	@FindBy(css="li.Bxz\\(bb\\):nth-child(3) > h3:nth-child(1) > span:nth-child(4)")
	private WebElement Nasdaq;
	
	@FindBy(css="li.Bxz\\(bb\\):nth-child(2) > h3:nth-child(1) > span:nth-child(4)")
	private WebElement Dow30;
	
	@FindBy(css="input.Pos\\(r\\)")
	private WebElement SearchBar;
	
	public String getSP500IndexValue(WebDriver driver) throws WebDriverException
	{	
		return SP500.getText() ;
	}

	public String getSDow30IndexValue(WebDriver driver)throws WebDriverException
	{	
		return Dow30.getText() ;
	}
	
	public String getNasdaqIndexValue(WebDriver driver)throws WebDriverException
	{		
		return Nasdaq.getText() ;
	}
	

}
