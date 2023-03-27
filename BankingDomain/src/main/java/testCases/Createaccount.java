package testCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonFunctions.CommonUtility;
import pageObjects.CreateAccountpageobjects;
import pageObjects.LoginPageObjects;
import pageObjects.ManagerHomePage;

/**
 * @author sowmya This class is used for the creating the New Account of the
 *         Bank Application
 *
 */
public class Createaccount extends CommonUtility {
	ExtentReports extentreport;
	ExtentSparkReporter spark;
	ExtentTest testcase;

	/**
	 * This Method is used for the generating the Extent report
	 */
	@BeforeSuite
	public void extentreportGenerte() {

		// extentreport = new ExtentReports();

		extentreport = new ExtentReports();
		spark = new ExtentSparkReporter("Bankapplicationreport.html");
		List<ViewName> DEFAULT_ORDER = Arrays.asList(ViewName.DASHBOARD, ViewName.CATEGORY, ViewName.TEST);
		spark.viewConfigurer().viewOrder().as(DEFAULT_ORDER);

		extentreport.attachReporter(spark);
		testcase = extentreport.createTest("launch the  the chrome browser");
		testcase.log(Status.PASS, "Browser Launched Successfully");
		testcase.log(Status.INFO, "Successfully Launched the Chrome Browser");

	}

	/**
	 * This Method is used for the login into the Bank Application
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void logintoManagerAccount() throws InterruptedException {
		PageFactory.initElements(driver, LoginPageObjects.class);
		// extentreport = reportGenerate();
		testcase = extentreport.createTest("Login into Banking domain application");
		LoginPageObjects.userid.sendKeys(properties.getProperty("username"));
		LoginPageObjects.password.sendKeys(properties.getProperty("password"));
		LoginPageObjects.submit.click();

		testcase.log(Status.PASS, "User Logged in successfully");
	}

	/**
	 * This method is used to click on the New Customer Button
	 */
	@Test
	public void managerAccount() {
		// extentreport = reportGenerate();
		testcase = extentreport.createTest("Logged in as Manager and click on New Customer Button");
		PageFactory.initElements(driver, ManagerHomePage.class);

		ManagerHomePage.newcustomer.click();
		testcase.info("click on New Customer Button");
		testcase.log(Status.PASS, "As Manager and click on New Customer Button");

	}

	/**
	 * This method is used for the creating New Account with the input parameters
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void createNewAccount() throws InterruptedException {
		testcase = extentreport.createTest("As Manager enter the New Customer details");
		testcase.info("Provide the input values to Create New account details");
		PageFactory.initElements(driver, CreateAccountpageobjects.class);
		CreateAccountpageobjects.customername.sendKeys("raamu");

		testcase.info(" Entered the input values for the customer");
		CreateAccountpageobjects.calendar.sendKeys(Keys.TAB);
		testcase.info(" Entered the input values for the Date of Birth");
		CreateAccountpageobjects.calendar.sendKeys("10122000" + Keys.TAB);
		CreateAccountpageobjects.calendar.sendKeys("12" + Keys.TAB);
		CreateAccountpageobjects.calendar.sendKeys("2000" + Keys.TAB);
		/* calendar.sendKeys("12"+Keys.TAB); calendar.sendKeys("2000"+Keys.TAB); */
		CreateAccountpageobjects.address.sendKeys("1006 kirkland road");
		testcase.info(" Entered the input values for the Address");
		CreateAccountpageobjects.city.sendKeys("chennai");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		CreateAccountpageobjects.state.sendKeys("Andhrapradesh");
		testcase.info(" Entered the input values for the State");
		Thread.sleep(3000);
		CreateAccountpageobjects.pin.sendKeys("517501");
		testcase.info(" Entered the input values for the Zipcode");
		CreateAccountpageobjects.phoneno.sendKeys("123249671");
		testcase.info(" Entered the input values for the Phone number");
		CreateAccountpageobjects.id.sendKeys("sowmya12258@gmail.com");
		testcase.info(" Entered the input values for the Email");
		CreateAccountpageobjects.pw.sendKeys("guru123#");
		testcase.info(" Entered the input values for the Password");
		testcase.log(Status.PASS, "Provided  all input values for the New Customer");
		CreateAccountpageobjects.submit.click();
		testcase.log(Status.PASS, "Successfully created new customer to the Banking domain Application");
		// extentreport.flush();
	}

	@AfterTest
	public void createhtml() {
		extentreport.flush();
	}
}
