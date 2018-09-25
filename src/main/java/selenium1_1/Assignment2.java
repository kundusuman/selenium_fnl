package selenium1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment2 
{
	 WebDriver driver;
	 InternetExplorerDriver driver1;
	
	 @BeforeTest
	  public void setup() throws InterruptedException 
	 {
			System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		
	 }
	 @Test
	 public void print()
	 {
			String webpage = "http://www.google.com";
			// Open the URL for Google
					driver.navigate().to("https://www.amazon.in");
			// Maximize the window
					driver.manage().window().maximize();
			// Navigate to Google URL using String variable webpage
			driver.navigate().to(webpage);
			// Navigate to ‘Sign In’ page
					driver.findElement(By.id("gb_70")).click();
			// Navigate Back to google homepage
					driver.navigate().back();
			// Navigate Forward to Sign In page
					driver.navigate().forward();
			// Refresh the web page (F5)
					driver.navigate().refresh();
					
		 
	 }
	 @AfterTest
	 public void stop()
	 {
		 driver.quit();
	 }
	 
	 

}
