package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test 
{
	public static void main(String args[]) throws InterruptedException
	{
		chrome();
        
		 
	}

	private static void chrome()
	{
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		WebElement searchBar1 = driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']"));
		searchBar1.click();
		searchBar1=null;
		WebElement searchBar = driver.findElement(By.xpath("//span[contains(text(),'Electronics')]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(searchBar).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Mobiles']")));
        builder.moveToElement(element).click().build().perform();
        WebElement element12=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3b7jyH']//img[@alt='Mi']")));
        builder.moveToElement(element12).build().perform();
        element12.click();
	}

}
