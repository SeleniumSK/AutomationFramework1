package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AccountCreationPage;

public class AccountCreation extends BaseClass{
	
	
	@Test
	public void accCreation()
	{
		AccountCreationPage page = PageFactory.initElements(driver, AccountCreationPage.class);
		
		page.SignIn("MyAlias","12345433","sahanakaza@gmail.com","United States","California","95131","somersetpark","fremont","Againmyfname","Againmylname","mypassword1",6,"April","1970");
		
		page.verifySignIn();
		
		page.verifyAccPg();
		
		page.verifyAccCre();
		
				
	}

}
