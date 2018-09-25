package selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2__2 
{
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		File file=new File("./suman.properties");
		FileInputStream fileInput=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fileInput);
		
		
		driver.get("http://www.gmail.co.in");
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		element1.sendKeys(prop.getProperty("username"));
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[@class='CwaK9']//span[contains(text(),'Next')]")));
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		element1.sendKeys(prop.getProperty("password"));
		element1=driver.findElement(By.id("passwordNext"));
		element1.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
		if(element1.isDisplayed())
		{
			System.out.println("chrome opened verified");
		}
		else
		{
			System.out.println("not verified");
		}
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wO nr l1']//textarea[@class='vO']")));
		element1.sendKeys("sumankundudecember@gmail.com");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":nn")));
		element1.sendKeys("testing");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":os")));
		element1.sendKeys("testing first ");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=':nd']")));
		element1.click();
	}
}
