package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driverl)
	{
		this.driver=driverl;
		
		
	}
	
	@FindBy(how=How.XPATH,using ="//a[@class='login']")WebElement signIn;
	@FindBy(how=How.ID, using="email")WebElement email;
	@FindBy(how=How.ID, using = "passwd")WebElement pass;
	@FindBy(how=How.ID, using = "SubmitLogin")WebElement SignInBtn;
	
	
	
	
	
	public void login(String emailAdd, String passwd)
	{
		
		email.sendKeys(emailAdd);
		pass.sendKeys(passwd);
		SignInBtn.click();
	}
	public void verifyLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='logout']")));
		
		Assert.assertTrue(element.isDisplayed());
		
		
	}

}
