package pageObjects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountpageobjects {
	@FindBy(xpath="/html/body/form/table/tbody/tr[1]/td[2]/input")
	public static WebElement userid ;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[2]/td[2]/input")
	public static WebElement password; 
	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	public static WebElement login; 
	
	
	 @FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	 public static WebElement newcustomer;
	 
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	public static WebElement customername;
	@FindBy(xpath="//input[@id='dob']")
	public static WebElement calendar;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	public static WebElement address ;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")
	public static WebElement city; 
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")
	public static WebElement state; 
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")
	public static WebElement pin ;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input")
	public static WebElement phoneno; 
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[12]/td[2]/input")
	public static WebElement id ;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[13]/td[2]/input")
	public static WebElement pw ;
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[14]/td[2]/input[1]")
	public static WebElement submit ;}
	


