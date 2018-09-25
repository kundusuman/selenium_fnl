package gmail.accnTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import gmail.accn.*;

public class TestNGTest_dataprovider2 
{
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;
	 @BeforeTest
	  public void setup() throws InterruptedException
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		// driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");

	 }
	 @DataProvider(name = "Suman's")
	 
	  public static Object[][] credentials() {
	 
	        return new Object[][] { { "user1", "user1_lastname","user1_username","user1_password" }, { "user2", "user2_lastname","user2_username","user2_password" },{ "user3", "user3_lastname","user3_username","user3_password" }};
	  }
	  // Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Suman's")
	 public void tesst1(String firstname, String lastname, String username, String password)
	 {
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		 TestNGCreateAccount TCA=new TestNGCreateAccount(driver);
		 TCA.loginToGmail(firstname, lastname, username, password);
	 }
	 
	 
	 
	 @AfterTest
	 public void close()
	 {
		
		 driver.quit();
	 }
		

}
