package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageObjects {

	@FindBy(xpath = "//textarea[@type='search']")
	public static WebElement GoogleTextBox;
	
	@FindBy(tagName = "cite")
	public static WebElement GoogleFirstSearchResult;
	
	@FindBy(xpath="//ul[@role='listbox']")
	public static WebElement SuggestionList;
	
	@FindBy(xpath="//ul[@role='listbox']/li[1]")
	public static WebElement FirstListValue;
	
	
	@FindBy(xpath = "//textarea[@type='search']")
	public static WebElement BingTextBox;
	
	@FindBy(tagName = "cite")
	public static WebElement BingFirstSearchResult;
	
	@FindBy(xpath="//ul[@role='listbox']")
	public static WebElement BingSuggestionList;
	
	@FindBy(xpath="//ul[@role='listbox']/li[1]")
	public static WebElement BingFirstListValue;

	
	
	@FindBy(xpath ="//input[@type='text']")
	public static WebElement YahooTextBox;
	
	@FindBy(xpath = "//*[@id=\'web\']/ol/li[1]/div/div[1]/h3/a/span")
	public static WebElement YahooFirstSearchResult;

}
