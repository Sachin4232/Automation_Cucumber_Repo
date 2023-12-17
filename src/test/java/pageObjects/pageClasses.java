package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pageClasses 
{
    public WebDriver driver;
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']") @CacheLookup WebElement SignInToEnterCredentials;
	@FindBy(xpath="//input[@id='ap_email']") @CacheLookup WebElement MobileNumber;
	@FindBy(xpath="//input[@id='continue']") @CacheLookup WebElement ContinueButton;
	@FindBy(xpath="//input[@id='ap_password']") @CacheLookup WebElement Password;
	@FindBy(xpath="//input[@id='signInSubmit']") @CacheLookup WebElement SigIn;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") @CacheLookup WebElement PhoneName;

	public pageClasses(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickon_SignInToEnterCredentials()
	{
		SignInToEnterCredentials.click();
	}
	
	public void enterMobileNumber_ClickonContinueButton(String mobileNumber)
	{
		MobileNumber.sendKeys(mobileNumber);
		ContinueButton.click();
	}
	
	public void enterPassword_ClickonSignInButton(String password)
	{
		Password.sendKeys(password);
		SigIn.click();
	}
	
	public void enterPhoneName_Search(String phoneName)
	{
		PhoneName.sendKeys(phoneName);
	}
}
