package gmail.accn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestNGCreateAccount 
{
	WebDriver driver;
	 
	 
	 
	By firstName=By.id("firstName");
	By lastName =By.id("lastName");
	By userName =By.id("username");
	By passWord =By.xpath("//div[@class='Xb9hP']//input[@name='Passwd']");
	By rpassWord = By.xpath("//div[@class='Xb9hP']//input[@name='ConfirmPasswd']");
	By clickButton=By.id("accountDetailsNext");
	
	public TestNGCreateAccount(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void loginToGmail(String firstname,String lastname,String username,String password)
	{
	 
		driver.findElement(firstName).sendKeys(firstname);
		driver.findElement(lastName).sendKeys(lastname);
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(rpassWord).sendKeys(password);
		driver.findElement(clickButton).click();
	}	
	
	 
	 
	
	 

	
	 
	 
	
	
	

}
