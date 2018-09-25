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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import gmail.accn.*;

public class TestNGTest 
{
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;
	 @BeforeTest
	  public void setup() 
	 {
		 System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		 driver1=new ChromeDriver();
		 driver1.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		 driver2=new ChromeDriver();
		 driver2.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");

//			driver1 = new InternetExplorerDriver();
//			driver1.get("www.google.com");
	 }
	 @Test
	 @Parameters ({"firstName","lastName","userName","passWord"})
	 public void tesst1(String firstname, String lastname, String username, String password)
	 {
		 TestNGCreateAccount TCA=new TestNGCreateAccount(driver);
		 TCA.loginToGmail(firstname, lastname, username, password);
	 }
	 @Test
	 @Parameters ({"firstName","lastName","userName","passWord"})
	 public void tesst2(String firstname, String lastname, String username, String password)
	 {
	System.out.println(firstname);
		 TestNGCreateAccount TCA=new TestNGCreateAccount(driver1);
		 TCA.loginToGmail(firstname, lastname, username, password);
	 }
	 @Test
	 @Parameters ({"firstName","lastName","userName","passWord"})
	 public void tesst(String firstname, String lastname, String username, String password)
	 {
		 TestNGCreateAccount TCA=new TestNGCreateAccount(driver2);
		 TCA.loginToGmail(firstname, lastname, username, password);
	 }

	 
	 
	 
	 
	 @AfterTest
	 public void close()
	 {
		 driver1.quit();
		 driver2.quit();
		 driver.quit();
	 }
		

}
