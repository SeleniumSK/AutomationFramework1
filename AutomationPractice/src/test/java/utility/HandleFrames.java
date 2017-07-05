package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleFrames {
	
	
	public static void waitForFrameAndSwitch(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	}
	
	public static void waitForFrameAndSwitch(WebDriver driver, String frameNameOrId, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}
	public static void waitForFrameAndSwitch(WebDriver driver, int frameIndex, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	public static void waitForFrameAndSwitch(WebDriver driver, By locator, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	

}
