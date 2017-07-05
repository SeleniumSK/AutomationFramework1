package testCases;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;



public class BaseClass extends ExcelDataProvider {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public static FileOutputStream fout;
	public ExcelDataProvider excel;
	public ExtentTest logger;
	
	@BeforeSuite
	public void preSetUpSuite()
	{
		System.out.println("Before Suite is getting executed");;
		 config = new ConfigDataProvider();
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/report.html");
		excel = new ExcelDataProvider();
		System.out.println("ReportSetup is done.");
	}
	
	@Parameters({"browser"})
	@BeforeClass
	public void setUp(String browserName)
	{
		System.out.println("Before Class is getting executed");
		 driver= utility.BrowserFactory.startBrowser("Firefox");
		
		driver.get(config.getAppUrl());
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		System.out.println("Application is started");
	}
	
	
	@AfterClass
	public void closeApplication( ) throws FileNotFoundException
	{
		
		driver.quit();
		
		 
			fout = new FileOutputStream(src);
			
			System.out.println("After class is executed");
		
		int statusSize = Login.staus.size();
		
		for(int i=0; i<statusSize;i++)
		{
			excel.setDataToExcel("login",i, 2, Login.staus.get(i));
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		excel.writeExcel();
		report.flush();
		
		System.out.println("After Suite is executed");
	}
	
	/*@AfterMethod
	public void tearDownTest(ITestResult result)
	
	{
		int Current_Result = result.getStatus();
		
		if(Current_Result == ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "TestCompleted Successfully");
			
			Login.staus.add("Pass");
		} else if(Current_Result == ITestResult.FAILURE){
			
		logger.log(LogStatus.FAIL, "Test Failed");
		logger.log(LogStatus.FAIL, result.getThrowable().getMessage());
		Login.staus.add("Fail");
		}else if(Current_Result == ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "TestCase Skipped. Kindly Check the logs");
			Login.staus.add("Skip");
		}
		report.endTest(logger);
		
		System.out.println("After method Executed");
		
	*/
	//}
}
