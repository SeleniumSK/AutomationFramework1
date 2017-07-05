package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driverl)
	{
		this.driver=driverl;
	}
	
	@FindBy(xpath ="//a[@class='login']")WebElement signIn;
	
	@FindBy(xpath ="//a[@class='logout']")WebElement signOut;
	
	
	public void signIn()
	{
		signIn.click();
	}

	
	public void verifySignIn()
	{
		String title = driver.getTitle();
		
		Assert.assertTrue(title.contains("Store"));
	}
	
	public void SignOut()
	{
		signOut.click();
	}
}
