package seleniumTests;
 
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
 
public class E2E_Test {
	//private static WebDriver driver;
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		//•	Given user is on Home Page
		System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
		DesiredCapabilities d = new DesiredCapabilities();
		d.setCapability("marionette", false);  // to disable marionette, by default true
		
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver","C:\\ToolsQA\\Libs\\Drivers\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("deepyadon@gmail.com");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("password123");
		driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
		Thread.sleep(3000);
		
		//•	When he search for “dress” 
		//driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("T-Shirt");
		//driver.findElement(By.xpath("//button[@name=\"submit_search\"]")).click();
		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
		
		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
		items.get(0).click();
		
		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
		addToCart.click();
		
		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
		cart.click();
		
		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
		continueToCheckout.click();
		
		Thread.sleep(5000);
		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
		firstName.sendKeys("Lakshay");
		
		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
		lastName.sendKeys("Sharma");
		
		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
		emailAddress.sendKeys("test@gmail.com");
		
		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
		phone.sendKeys("07438862327");
				
		WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
		countryDropDown.click();
		Thread.sleep(2000);
		
		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
		for(WebElement country : countryList){
			if(country.getText().equals("India")) {
				country.click();	
				Thread.sleep(3000);
				break;
			}		
		}
						
		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
		city.sendKeys("Delhi");
		
		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
		address.sendKeys("Shalimar Bagh");
		
		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
		postcode.sendKeys("110088");		
		
		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
		shipToDifferetAddress.click();
		Thread.sleep(7000);
		
		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
		paymentMethod.get(0).click();
		
		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
		acceptTC.click();
		
		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
		placeOrder.submit();
		
		driver.quit();
		
		//Logout
		driver.findElement(By.xpath("//a[@title=\"Log me out\"]")).click();
		
		
 
//		driver.navigate().to("http://shop.demoqa.com/?s=" + "dress" + "&post_type=product");
// 
//	
//		List<WebElement> items = driver.findElements(By.cssSelector(".noo-product-inner"));
//		items.get(0).click();
//		
//		WebElement addToCart = driver.findElement(By.cssSelector("button.single_add_to_cart_button"));
//		addToCart.click();		
//		
//		
//		WebElement cart = driver.findElement(By.cssSelector(".cart-button"));
//		cart.click();
//		
//		Thread.sleep(5000);
//		//WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.alt"));
//		WebElement continueToCheckout = driver.findElement(By.cssSelector(".checkout-button.button.alt"));
//		continueToCheckout.click();		
//		
//		
//		Thread.sleep(5000);
//		WebElement firstName = driver.findElement(By.cssSelector("#billing_first_name"));
//		firstName.sendKeys("Lakshay");
//		
//		WebElement lastName = driver.findElement(By.cssSelector("#billing_last_name"));
//		lastName.sendKeys("Sharma");
//		
//		WebElement emailAddress = driver.findElement(By.cssSelector("#billing_email"));
//		emailAddress.sendKeys("test@gmail.com");
//		
//		WebElement phone = driver.findElement(By.cssSelector("#billing_phone"));
//		phone.sendKeys("07438862327");
//				
//		WebElement countryDropDown = driver.findElement(By.cssSelector("#billing_country_field .select2-arrow"));
//		countryDropDown.click();
//		Thread.sleep(2000);
//		
//		List<WebElement> countryList = driver.findElements(By.cssSelector("#select2-drop ul li"));
//		for(WebElement country : countryList){
//			if(country.getText().equals("India")) {
//				country.click();	
//				Thread.sleep(3000);
//				break;
//			}		
//		}
//						
//		WebElement city = driver.findElement(By.cssSelector("#billing_city"));
//		city.sendKeys("Delhi");
//		
//		WebElement address = driver.findElement(By.cssSelector("#billing_address_1"));
//		address.sendKeys("Shalimar Bagh");
//		
//		WebElement postcode = driver.findElement(By.cssSelector("#billing_postcode"));
//		postcode.sendKeys("110088");		
//		
//		WebElement shipToDifferetAddress = driver.findElement(By.cssSelector("#ship-to-different-address-checkbox"));
//		shipToDifferetAddress.click();
//		Thread.sleep(3000);
//		
//		List<WebElement> paymentMethod = driver.findElements(By.cssSelector("ul.wc_payment_methods li"));
//		paymentMethod.get(0).click();
//		
//		WebElement acceptTC = driver.findElement(By.cssSelector("#terms.input-checkbox"));
//		acceptTC.click();
//		
//		WebElement placeOrder = driver.findElement(By.cssSelector("#place_order"));
//		placeOrder.submit();
		
		driver.quit();
 
	}
 
}
