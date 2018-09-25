package Capabilitydiss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Capability
{


		WebDriver driver;
		
		 @BeforeTest
		  public void setup() 
		 {
			 System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
			 driver=new ChromeDriver();
			 driver.get("https://www.google.com");

		 }
		 @Test
		 @Parameters ({"keyword"})
		 public void tesst1(String keyword)
		 {
			driver.findElement(By.id("lst-ib")).sendKeys(keyword);
			Assert.assertEquals("hello", keyword);
		 }
		
		 
		 @AfterTest
		 public void close()
		 {
			
			// driver.quit();
		 }
			

	

}
