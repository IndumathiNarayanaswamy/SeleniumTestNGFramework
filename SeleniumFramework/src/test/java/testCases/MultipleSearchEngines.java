package testCases;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultipleSearchEngines extends commonFunctions.CommonFunctions
{

static Logger log = LogManager.getLogger(MultipleSearchEngines.class);
	
	String ExpectedSearchResult;
	
	String Ulpath = "//ul[@role='listbox']";

	@Test(priority=1)
	public void Googlesearch()

	{
		log.info("Google search page is loading");
		driver.get(GoogleUrl);
		PageFactory.initElements(driver, pageObjects.SearchPageObjects.class);
		log.info("Google searching for search item");
		pageObjects.SearchPageObjects.GoogleTextBox.sendKeys(SearchValue);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Ulpath)));
		//wait.until(ExpectedConditions.elementToBeClickable(pageObjects.SearchPageObjects.SuggestionList));
		pageObjects.SearchPageObjects.FirstListValue.click();
		ExpectedSearchResult = pageObjects.SearchPageObjects.GoogleFirstSearchResult.getText();
	    log.info(ExpectedSearchResult);
	    Assert.assertFalse(ExpectedSearchResult.isEmpty());
	}			
	
	@Test(priority=2)
	public void Yahoosearch()

	{
		log.info("Yahoo search page is loading");
    	driver.get(YahooUrl);
		PageFactory.initElements(driver, pageObjects.SearchPageObjects.class);
		log.info("Yahoo searching for search item");
		pageObjects.SearchPageObjects.YahooTextBox.sendKeys(SearchValue);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Ulpath)));
		//wait.until(ExpectedConditions.elementToBeClickable(pageObjects.SearchPageObjects.SuggestionList));
		pageObjects.SearchPageObjects.FirstListValue.click();;
		ExpectedSearchResult = pageObjects.SearchPageObjects.YahooFirstSearchResult.getText();
	    log.info(ExpectedSearchResult);
	    Assert.assertFalse(ExpectedSearchResult.isEmpty());
	
	}  
	
	@Test(priority=3)
	public void Bingsearch()  
	
	{
    	log.info("Bing search page is loading");
    	driver.get(BingUrl);
		PageFactory.initElements(driver, pageObjects.SearchPageObjects.class);
		log.info("Bing searching for search item");
		pageObjects.SearchPageObjects.BingTextBox.sendKeys(SearchValue);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Ulpath)));
		//wait.until(ExpectedConditions.elementToBeClickable(pageObjects.SearchPageObjects.SuggestionList));
		pageObjects.SearchPageObjects.FirstListValue.click();
		ExpectedSearchResult = pageObjects.SearchPageObjects.BingFirstSearchResult.getText();
	    log.info(ExpectedSearchResult);
	    Assert.assertFalse(ExpectedSearchResult.isEmpty());
	    
	}
}


