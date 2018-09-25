package log4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogDemo
{
	  public static void main(String[] args) throws Exception {
	         // TODO Auto-generated method stub
		  WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			PropertyConfigurator.configure("D:\\NewOxygenWorkspace2\\selenium\\src\\main\\java\\log4j\\log4j.properties");
	         Logger log = Logger.getLogger(LogDemo.class);
	         
	         
	     	File file=new File("./suman.properties");
			FileInputStream fileInput=new FileInputStream(file);
			Properties prop=new Properties();
			prop.load(fileInput);
			log.debug("opening property file");
	 		driver.get("http://www.gmail.co.in");
	 		log.debug("visiting web site");
	 		WebDriverWait wait= new WebDriverWait(driver,10);
	 		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	 		element1.sendKeys(prop.getProperty("username"));
	 		log.debug("reading value from property file");
	 		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[@class='CwaK9']//span[contains(text(),'Next')]")));
	 		element1.click();
	 		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
	 		element1.sendKeys(prop.getProperty("password"));
	 		log.debug("reading password from property file sdfdh");
	 		element1=driver.findElement(By.id("passwordNext"));
	 		element1.click();
	 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 		
		}
	}

