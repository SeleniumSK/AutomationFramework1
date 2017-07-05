package pages;

import org.eclipse.jetty.util.log.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class AccountCreationPage {
	
	WebDriver driver;
	
	public AccountCreationPage(WebDriver driverl)
	{
		this.driver=driverl;
	}
	
	@FindBy(xpath="//a[@class='login']")WebElement SignInButton;
	@FindBy(id="SubmitCreate")WebElement CreateAccBtn;
	@FindBy(id="email_create")WebElement emailAdd;
	@FindBy(xpath="//input[@type='radio' and @id='id_gender2']")WebElement gender;
	@FindBy(id="customer_firstname")WebElement fName;
	@FindBy(id="customer_lastname")WebElement lName;
	@FindBy(id="email")WebElement Email;
	@FindBy(id="passwd")WebElement password;
	@FindBy(id="days")WebElement DOBdays;
	@FindBy(id="months")WebElement DOBmonths;
	@FindBy(id="years")WebElement DOByears;
	@FindBy(id="firstname")WebElement fstNm;
	@FindBy(id="lastname")WebElement lstNm;
	@FindBy(id="address1")WebElement add;
	@FindBy(id="city")WebElement cty;
	@FindBy(id="id_state")WebElement state;
	@FindBy(id="postcode")WebElement zCode;
	@FindBy(id="'id_country")WebElement ctry;
	@FindBy(id="phone_mobile")WebElement phne;
	@FindBy(id="alias")WebElement aliasadd;
	@FindBy(id="submitAccount")WebElement smbBtn;
	
	
	
	
	
	
	
	public void SignIn(String alias, String Phone, String email,String country,String ste,String zip,String address, String city, String firstName, String lastName, String pwd, int day, String month, String year){
		
		SignInButton.click();
		emailAdd.sendKeys(email);
		CreateAccBtn.click();
		gender.click();
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		Email.clear();
		Email.sendKeys(email);
		password.sendKeys(pwd);
		Select s = new Select(DOBdays);
		s.selectByIndex(day);
		Select s1 = new Select(DOBmonths);
		s1.selectByIndex(day);
		Select s2 = new Select(DOByears);
		s2.selectByValue(year);
		fstNm.sendKeys(firstName);
		lstNm.sendKeys(lastName);
		add.sendKeys(address);
		cty.sendKeys(city);
		Select stateS = new Select(state);
		stateS.selectByVisibleText(ste);
		zCode.sendKeys(zip);
		/*Select ctryS = new Select(ctry);
		ctryS.selectByVisibleText(country);*/
		phne.sendKeys(Phone);
		aliasadd.sendKeys(alias);
		smbBtn.click();
	}
	
	public void verifySignIn(){
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Login - My Store";
		
		Assert.assertTrue(actualTitle.equals(expectedTitle));
		
		Reporter.log("Clicked on the SignIn button", true);
	}
	
	public void verifyAccPg(){
		
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "Login - My Store";
		
		Assert.assertTrue(actualTitle.equals(expectedTitle));
		
		Reporter.log("Clicked on the Create account button", true);
	}
	public void verifyAccCre()
	{
		String actualTitle = driver.getTitle();
		
		String expectedTitle = "LoMy account - My Store";
		
		Assert.assertTrue(actualTitle.equals(expectedTitle));
		Assert.assertEquals(expectedTitle, actualTitle,"Sorry title doesnt match the expected");
		Reporter.log("clicked on the submit button", true);
	}

}
