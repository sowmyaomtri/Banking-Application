package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagerHomePage {
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	public static WebElement newcustomer;

}
