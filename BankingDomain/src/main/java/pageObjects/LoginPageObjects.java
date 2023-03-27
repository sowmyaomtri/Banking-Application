package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

	
	@FindBy(xpath="/html/body/form/table/tbody/tr[1]/td[2]/input")
	public static WebElement userid;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	public static WebElement password;
	
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	public static WebElement submit;
}
