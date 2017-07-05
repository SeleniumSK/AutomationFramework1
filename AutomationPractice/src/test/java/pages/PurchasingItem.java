package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class PurchasingItem {
	
	WebDriver driver;
	
	public PurchasingItem(WebDriver driverl)
	{
		this.driver=driverl;
		
	}
	
	
	@FindBy(how=How.XPATH, using="//a[@title='T-shirts']")WebElement ShirtsButton;
	
	@FindBy(how=How.XPATH, using="//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]/span")WebElement AddToCartButton;
	
	@FindBy(how=How.XPATH, using=".//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")WebElement ProceedToCheckOutButton;
	
	@FindBy(how=How.XPATH, using =".//*[@id='center_column']/p[2]/a[1]/span")WebElement ProceedToCheckOutButton2;
	
	@FindBy(how=How.XPATH, using =".//*[@id='center_column']/form/p/button")WebElement ProceedToCheckOutButton3;
	
	@FindBy(how=How.XPATH, using="//input[@id='cgv']")WebElement TermsOfServiceCheckbox;
	
	@FindBy(how=How.XPATH, using=".//*[@id='form']/p/button")WebElement ProceedToCheckOutButton4;
	
	@FindBy(how=How.XPATH, using ="//*[@id='cart_navigation']/button") WebElement confirmButton;
	
	public void selectDress()
	{
		ShirtsButton.click();
		
	}
	
	public void VerifyDressPage()
	{
		Assert.assertEquals("T-shirts - My Store", driver.getTitle(), "Sorry, the page is not correct");
	}
	
	public void SelectingDress()
	{
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",ProceedToCheckOutButton );
		
		ProceedToCheckOutButton.click();
		
	}

}
