package listner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestCases
{
	WebDriver driver;
	Properties prop;
	WebDriverWait wait;
	WebElement element1;
		@BeforeTest
		public void conffig() throws IOException
		{
			System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			File file=new File("./suman.properties");
			FileInputStream fileInput=new FileInputStream(file);
			prop=new Properties();
			prop.load(fileInput);
			wait= new WebDriverWait(driver,10);
		}
		
		@Test(priority=1)
		public void loginGmail()
		{
		driver.get("http://www.gmail.co.in");
		
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		element1.sendKeys(prop.getProperty("username"));
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[@class='CwaK9']//span[contains(text(),'Next')]")));
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		element1.sendKeys(prop.getProperty("password"));
		element1=driver.findElement(By.id("passwordNext"));
		element1.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
		takeScreenShot() ;
		
		}
		@Test(dependsOnMethods = { "loginGmail" })
		public void sendMail()
		{
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wO nr l1']//textarea[@class='vO']")));
		element1.sendKeys("sumankundudecember@gmail.com");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":nn")));
		element1.sendKeys("testing");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":os")));
		element1.sendKeys("testing first ");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=':nd']")));
		takeScreenShot() ;
		element1.click();
		takeScreenShot() ;
		
		}
		@AfterTest
		public void Quit()
		{
			driver.quit();
		}
		public void takeScreenShot() {
         //The below method will save the screen shot in d drive with test method name 
            try {
            	File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	    	String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    	    	String s=String.valueOf(java.time.LocalTime.now());
    	    	s=s.replaceAll(":", "");
    	    	FileUtils.copyFile(ss, new File("D://Ams//" + date +"//" +s + ".jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
    }

	

}
