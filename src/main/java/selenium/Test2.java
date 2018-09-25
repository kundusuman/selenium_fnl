package selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test2 
{
	public static void main(String args[]) throws InterruptedException
	{
		chrome();
		 
		 
		
	}

	private static void chrome() 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		driver.get("https://www.amazon.in");
		WebElement searchBar1 = driver.findElement(By.id("twotabsearchtextbox"));
		searchBar1.sendKeys("redmi note 4");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='submit']//ancestor::div[@class='nav-search-submit nav-sprite']")));
		 builder.moveToElement(element).build().perform();
		 element.click();
		 WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@data-attribute='Redmi 5 (Gold, 16GB)']//ancestor::a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")));
		 builder.moveToElement(element1).build().perform();
		 element1.click();
		 ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.MILLISECONDS) ;
		 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();;
		
	}
	

}
