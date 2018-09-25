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

import com.excel.ExcelUtils;
//import com.excel.writeExcel;

import gmail.accn.*;

public class TestNGTest_dataprovider 
{
	WebDriver driver;
	WebDriver driver1;
	WebDriver driver2;
	public static int row=0;
	 @BeforeTest
	  public void setup() throws InterruptedException
	 {
		 
		 System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
		// driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");

	 }
	 @DataProvider(name = "Suman's")
	 
	  public static Object[][] credentials() throws Exception {
	 

         Object[][] testObjArray = ExcelUtils.getTableArray("D:\\NewOxygenWorkspace2\\selenium\\src\\test\\resources\\excel\\suman.xlsx","Sheet1");
 
         return (testObjArray);
 
	  }
	  // Here we are calling the Data Provider object with its Name
	@Test(dataProvider = "Suman's")
	 public void tesst1(String firstname, String lastname, String username, String password) throws Exception
	 {
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		 TestNGCreateAccount TCA=new TestNGCreateAccount(driver);
		 TCA.loginToGmail(firstname, lastname, username, password);
		// writeExcel.writeExcel1("D:\\NewOxygenWorkspace2\\selenium\\src\\main\\resources\\excel\\suman.xlsx","Sheet1", argss );
	 }
	 
	 
	 
	 @AfterTest
	 public void close()
	 {
		
		 driver.quit();
	 }
		

}
