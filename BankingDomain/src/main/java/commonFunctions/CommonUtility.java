package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class CommonUtility {

	public static Properties properties = null;
	public static WebDriver driver;/* = null; */
	ExtentReports extentreport;
	ExtentSparkReporter spark;
	ExtentTest testcase;
	
	 
	 

	public Properties loadpropertyfile() throws IOException {

		FileInputStream fileinputstream = new FileInputStream("config.properties");
		properties = new Properties();
		properties.load(fileinputstream);

		return properties;
	}

	@BeforeTest
	public void launchdriver() throws IOException {

		System.out.println("before test");
		Properties properties = loadpropertyfile();
		String browser = properties.getProperty("browser");
		String url = properties.getProperty("url");
		String driverLocation = properties.getProperty("driverLocation");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", driverLocation);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable notifications");
			DesiredCapabilities cp = new DesiredCapabilities();
			cp.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(cp);

			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("WebDriver.gecko.driver", driverLocation);
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterTest
	public void teardown() {
		//extentreport=reportGenerate();
		
		driver.quit();

	}

}
