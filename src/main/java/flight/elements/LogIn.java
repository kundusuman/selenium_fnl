package flight.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn 
{
	private WebDriver driver;
	By userName = By.name("userName");
	By passWord= By.name("password");
	By logIn = By.name("login");
	
	public LogIn(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void login(String username,String password)
	{
		 
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(logIn).click();
	}
}
