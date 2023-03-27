package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonFunctions.CommonUtility;
import pageObjects.LoginPageObjects;

public class Userlogin extends CommonUtility{
	
	ExtentReports extentreport; 
	ExtentSparkReporter spark ;
	ExtentTest testcase;
	
	@Test
	public void login() {
		extentreport = new ExtentReports();
		 spark = new ExtentSparkReporter("firstreport.html");
		 extentreport.attachReporter(spark);
		 testcase = extentreport.createTest("launch the  the chrome browser");
		 testcase.log(Status.PASS, "Starting test case");
		 
		
		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.userid.sendKeys(properties.getProperty("username"));
		LoginPageObjects.password.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submit.click();
		
		extentreport.flush();
		
	}
	
	

	

}
