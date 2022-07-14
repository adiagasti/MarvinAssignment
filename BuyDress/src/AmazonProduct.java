
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonProduct {
	
	@Test
	public void buyProduct() throws InterruptedException, ParseException
	  {
			//Open Browser
			System.setProperty("webdriver.chrome.driver", "/Users/adiagasti/Documents/Selenium/chromedriver");
			WebDriver driver = new ChromeDriver();
			WebDriverWait wait = new WebDriverWait (driver,300);
			
			//Open Amazon
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			
			//Sign In
		
			WebElement signIn = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("nav-link-accountList"))));
			signIn.click();
			WebElement email = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ap_email"))));
			email.sendKeys("8888849835");
			WebElement continueButton = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("continue"))));
			continueButton.click();
			WebElement password = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ap_password"))));
			password.sendKeys("Adi@j070269");
			WebElement submit = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("signInSubmit"))));
			submit.click();
			
			//Search Product
			WebElement search = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("twotabsearchtextbox"))));
			search.sendKeys("dress for women" + Keys.ENTER);
			
			//Select the Product
			List<WebElement> dressList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		    dressList.get(3).click();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    
		    //Select Size
		    WebElement element = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']"))));
			Select size = new Select (element);
			size.selectByIndex(3);
			
			
			//Select Quantity
			WebElement Quantity = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//select[@id='quantity']"))));
			Select quantity = new Select (Quantity);
			quantity.selectByValue("1");
			WebElement price = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-price-whole']"))));
			String actualPrice = price.getText();
			
			//Add To Cart
			WebElement addToCart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='submit.add-to-cart']"))));
			JavascriptExecutor js = (JavascriptExecutor)driver;	
			js.executeScript("arguments[0].click();", addToCart);
			
			//Go To Cart
			WebElement goToCart = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@id=\"nav-cart\"]"))));
			goToCart.click();
			
			//Get Price
			WebElement cartPrice = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='currencyINR']/parent::span"))));
			String priceInCart = cartPrice.getText();

			//Assert and Print Price
			//NumberFormat nF  = NumberFormat.getNumberInstance();          
			Assert.assertEquals(Float.parseFloat(actualPrice), Float.parseFloat(priceInCart));
			System.out.println("Price of the dress is" + driver.findElement(By.xpath("//span[@class='currencyINR']/parent::span")).getText());
			System.out.println("The quantity of the dress to be bought is " + driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']")).getText());
			
			//Proceed to Checkout
			WebElement proceedToCheck = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@name='proceedToRetailCheckout' and @class='a-button-input']"))));
			proceedToCheck.click();
			//driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@name='proceedToRetailCheckout' and @class='a-button-input']")).click();
			
				
		} 
}

