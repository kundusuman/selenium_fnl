package selenium1_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment1 
{
	 WebDriver driver;
	 InternetExplorerDriver driver1;
	
	 @BeforeTest
	  public void setup() throws InterruptedException 
	 {
			System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
	
		driver.get("https://www.google.com");
		System.setProperty("webdriver.ie.driver","D:\\NewOxygenWorkspace2\\selenium\\driver\\IEDriverServer.exe");
		driver1=new InternetExplorerDriver();
		driver1.get("http://www.amazon.in");
		
	 }
	 @Test
	 public void print()
	 {
		 System.out.println("hi");
		 
	 }
	 @AfterTest
	 public void stop()
	 {
		 driver.quit();
		 //driver1.quit();
	 }
	 
	 

}
