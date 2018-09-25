package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

public class Selenium2__1 
{
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1600, 900));
		driver.get("http://www.gmail.co.in");
		WebDriverWait wait= new WebDriverWait(driver,15);
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		element1.sendKeys(args[0]);
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[@class='CwaK9']//span[contains(text(),'Next')]")));
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		element1.sendKeys(args[1]);
		element1=driver.findElement(By.id("passwordNext"));
		element1.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		element1=driver.findElement(By.id(":2o"));
		if(!element1.getAttribute("aria-selected").equals("true"))
		{
			element1.click();
		}
		WebElement element12=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='T-Jo J-J5-Ji']")));
		element12.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":ke")));
		String str[]=element1.getText().split(" ");
		System.out.println(str[2] + "   mails are there in primary tab");
		element12.click();
		List<WebElement> rows = wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ae4 aDM']//table[@class='F cf zt']//tr"))));
		rows.get(5).click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":kr")));
		System.out.println("Subject of the mail is " + element1.getText());
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='iw']//span[@class='gD']")));
		System.out.println("Sender is " + element1.getAttribute("email"));
		
	}
}
