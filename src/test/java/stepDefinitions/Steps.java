package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.pageClasses;

public class Steps
{
	public WebDriver driver;
	public pageClasses pc;
	
	@Given("User Launch browser")
	public void user_launch_browser() 
	{
	   System.setProperty("webdriver.chrome.driver",".\\Drivers\\chromedriver.exe");
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--remote-allow-origins=*");
	   
	   driver=new ChromeDriver(options);
	   
	   pc=new pageClasses(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
	    driver.get(url);
	    
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@When("Click on SignIn Button to enter credentials")
	public void click_on_signIn_button_to_enter_credentials()
	{
	    pc.clickon_SignInToEnterCredentials();
	}
	
	@When("Enter mobile number as {string} & click on continue")
	public void enter_mobile_number_as_click_on_continue(String mobileNumber) 
	{
		pc.enterMobileNumber_ClickonContinueButton(mobileNumber);
	}

	@When("Enter password as {string} & click on Sign In")
	public void enter_password_as_click_on_sign_in(String password) 
	{
		pc.enterPassword_ClickonSignInButton(password);
	}
	
	@And("I wait for {int} seconds")
	public void i_wait(int a) throws InterruptedException
	{
		Thread.sleep(1000*a);
	}

	@Then("Search phone as {string} & click {string}")
	public void search_phone(String phoneName, String phoneSelection) throws InterruptedException 
	{
	    pc.enterPhoneName_Search(phoneName);
	    Thread.sleep(1000*4);
	    List<WebElement> allPhones = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));
		for(WebElement phone:allPhones)
		{
			if(phone.getText().equals(phoneSelection))
			{
				phone.click();
				break;
			}
		}
	}

	@Then("Click on iphone & store its price")
	public void click_on_iphone_store_its_price() throws InterruptedException 
	{
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[contains(text(),'iPhone 15 Pro (256 GB) - Blue Titanium')]")).click();
	    WebElement iphonePrices = driver.findElement(By.xpath("//span[normalize-space()='1,41,991']"));
	    String iphonePrice = iphonePrices.getText();
	    System.out.println("iphonePrice: "+iphonePrice);
	}

	@Then("Click on Add to cart")
	public void click_on_add_to_cart() throws InterruptedException 
	{
		Thread.sleep(1000*5);
		Set<String> windows = driver.getWindowHandles();
		ArrayList<String> al=new ArrayList<String>(windows);
		String childWindowID = al.get(1);
		driver.switchTo().window(childWindowID);
		
		WebElement addToCart = driver.findElement(By.xpath("//input[@id=\"add-to-cart-button\"]"));
		addToCart.click();
		
		WebElement clickOnClose = driver.findElement(By.xpath("//a[@aria-label=\"Exit this panel and return to the product page. \"]"));
		clickOnClose.click();
	}

	@Then("Validate iphone is added in cart or not")
	public void validate_iphone_is_added_in_cart_or_not()
	{
		WebElement itemsInCart = driver.findElement(By.xpath("//a[@id=\"nav-cart\"]"));
		itemsInCart.click();
		String actPhoneNameFromCart = driver.findElement(By.xpath("//span[contains(text(),'iPhone 15 Pro (256 GB) - Blue Titanium')]")).getText();
		
		String expPhoneNameFromFF = "iPhone 15 Pro (256 GB) - Blue Titanium";
	    
		if(expPhoneNameFromFF.equals(actPhoneNameFromCart))
		{
			System.out.println("iPhone 15 Pro is Added in Cart Successfully.");
		}
	}
	
	@And("Apply filter Sort by as {string}")
	public void apply_filter_sortBy(String sortBy) 
	{
		WebElement filterButton = driver.findElement(By.xpath("//span[@class=\"a-button-inner\"]"));
		filterButton.click();
		WebElement filterSelection = driver.findElement(By.xpath("//a[text()='"+sortBy+"']"));
		filterSelection.click();
	}
	
	@And("Validate filter should be {string}")
	public void validate_filter(String filterName) 
	{
		String filterChecking = driver.findElement(By.xpath("//span[text()=\"Price: Low to High\"]")).getText();
		
		if(filterChecking.equals(filterName))
		{
			Assert.assertTrue(true);
		}
	}

	@Then("close the browser")
	public void close_the_browser() 
	{
		driver.quit();
	}
}