package generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConstant
{
	//To run script in multiple windows
	
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setup (String browser) throws IOException
	{
		
		//To run script in Chrome browser
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis = new FileInputStream(properties_path);
			Properties properties = new Properties();
			properties.load(fis);
			driver.get(properties.getProperty("url"));
		}
		
		//To run script in Edge browser
		
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis = new FileInputStream(properties_path);
			Properties properties = new Properties();
			properties.load(fis);
			driver.get(properties.getProperty("url"));
		}
		
		//To run script in Firefox browser
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
			FileInputStream fis = new FileInputStream(properties_path);
			Properties properties = new Properties();
			properties.load(fis);
			driver.get(properties.getProperty("url"));
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
