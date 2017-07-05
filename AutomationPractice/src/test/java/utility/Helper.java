package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	
	public static String getCurrentTime()
	{
		SimpleDateFormat sd = new SimpleDateFormat("DD-MM-YYYY-hh-mm-ss");
		
		Date dt = new Date();
		
		String currentDate = sd.format(dt);
		
		return currentDate;
		
	}
	
	public static String takeScreenshot(WebDriver ldriver)
	{
		
		TakesScreenshot ts = (TakesScreenshot)ldriver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+"/Screenshots/screenshot"+ Helper.getCurrentTime()+".png";
		
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			
			System.out.println("Exception while taking the screenshot"+e.getMessage());
		}
		return path;
	}
	
	public static void highLightWebElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.getMessage();
		}
		js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid white;');", element);
		
		
	}
	
	public static void syncElement(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public static WebElement waitForElement(WebDriver driver, WebElement element, int time)
	{
		syncElement(driver, element, time);
		highLightWebElement(driver, element);
		
		return element;
	}
}
