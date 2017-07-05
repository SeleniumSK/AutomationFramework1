package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {
	
	
	
	
	public static WebDriver startBrowser(String BrowserName)
	{
		WebDriver driver = null;
		if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new FirefoxDriver(cap);
			
			driver.manage().window().maximize();
			
		}
		else
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			driver = new ChromeDriver(cap);
			
			driver.manage().window().maximize();
		}
		return driver;
	}

	public  void closeBrowser()
	{
		
		
	}
}
