package testCases;

import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import utility.CustomLogger;

public class Login extends BaseClass {
	public static ArrayList<String> staus = new ArrayList<String>();
	LoginPage lpage;
	HomePage hp;
	@Test
	public void loginToTheApplication()
	
	{
		logger = report.startTest("HomePage Verification");
		 lpage=PageFactory.initElements(driver, LoginPage.class);
		
		
		 hp =	PageFactory.initElements(driver, HomePage.class);
		 
		 hp.signIn();
		 
		CustomLogger.logInfo(logger, "Clicked on signin");
		 
		 hp.verifySignIn();
		 			 
		 CustomLogger.logInfo(logger, "verified HomePage");
		
	}
	
	@Test(dependsOnMethods="loginToTheApplication")
	public void verifyLogin()
	{
		
		logger = report.startTest("Login Page Verification", "This test case will verify the valid credentials");
		
		String user = excel.getExcelData("login", 0, 0);
		
		String pwd = excel.getExcelData("login", 0, 1);
		
		lpage.login(user, pwd);
		
		lpage.verifyLogin();
		CustomLogger.logPass(logger, "TestCase passed");
		
		
	}

}
