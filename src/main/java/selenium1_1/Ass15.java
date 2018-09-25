package selenium1_1;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Ass15 
{
	public static void main(String argsp[])
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");

Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
 
       .withTimeout(60, TimeUnit.SECONDS)
 
       .pollingEvery(2, TimeUnit.SECONDS)
 
       .ignoring(NoSuchElementException.class);
 
 
 
   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
 
     public WebElement apply(WebDriver driver) {
 
       return driver.findElement(By.id("twotabsearchtextbox"));
 
     }
 
   });
		
		
		
		
	
		element.sendKeys("mobiles");
		element.submit();
		
	}

}
