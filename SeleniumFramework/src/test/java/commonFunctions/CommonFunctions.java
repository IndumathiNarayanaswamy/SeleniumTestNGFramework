package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	
	public static WebDriver driver;
	public static Properties properties = null;
	public static String GoogleUrl;
	public static String BingUrl;
	public static String YahooUrl;
	public static String SearchValue;

	public Properties loadPropertyFile() throws IOException
	
	{
		FileInputStream fileinputstream = new FileInputStream("config.properties");
		properties= new Properties();
		properties.load	(fileinputstream);
		return properties;	
	}
	
	
	@BeforeSuite
	public void launchbrowser() throws InterruptedException, IOException
	
	{
	
	loadPropertyFile();
	GoogleUrl = properties.getProperty("url1");
	BingUrl =  properties.getProperty("url2");
	YahooUrl =  properties.getProperty("url3");
	SearchValue = properties.getProperty("searchtext");
	
	String browser =properties.getProperty("browser");
	
	if(browser.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	else if(browser.equalsIgnoreCase("firefox"))
	{
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	else if(browser.equalsIgnoreCase("edge"))
	{
	WebDriverManager.edgedriver().setup();
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	}
	
	@AfterSuite
	public void Exitbrowser()
	
	{
		driver.quit();
	}
	}


