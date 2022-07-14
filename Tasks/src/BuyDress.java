import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.base.StandardSystemProperty;

public class BuyDress {
	
	@Test
	public void buyProduct()
	  {
		
			System.setProperty("webdriver.chrome.driver", "/Users/adiagasti/Documents/Selenium/chromedriver");
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			driver.findElement(By.id("nav-link-accountList")).click();
			driver.findElement(By.id("ap_email")).sendKeys("8888849835");
			driver.findElement(By.id("continue")).click();
			driver.findElement(By.id("ap_password")).sendKeys("Adi@j070269");
			driver.findElement(By.id("signInSubmit")).click();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("dress for women" + Keys.ENTER);
			List<WebElement> dressList = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
		    dressList.get(3).click();
			ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));
		    driver.navigate().refresh();
		    WebElement element = driver.findElement(By.xpath("//select[@name='dropdown_selected_size_name']"));
			Select size = new Select (element);
			size.selectByIndex(3);
			driver.findElement(By.xpath("//input[@name='submit.add-to-cart']")).click();
			driver.findElement(By.xpath("//a[@id=\"nav-cart\"]")).click();
			//WebElement rate = driver.findElement(By.xpath("//span[@class='currencyINR']"));
			//String price = rate.getText();
			//System.out.println("Price of the dress is " + price);
			//System.out.println(driver.findElement(By.))
			//driver.findElement(By.xpath("//span[@class='a-button-inner']//input[@name='proceedToRetailCheckout' and @class='a-button-input']")).click();
	
			
		}

}
