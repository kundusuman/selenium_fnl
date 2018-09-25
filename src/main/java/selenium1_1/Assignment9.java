package selenium1_1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment9 
{
	public static void main(String suman[])
	{
				
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://facebook.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element,element1;
			if((element=driver.findElement(By.xpath("//input[@data-testid='royal_email']"))).isDisplayed())
			{
				System.out.println("user text box is present");
			}
			if((element1=driver.findElement(By.xpath("//input[@data-testid='royal_pass']"))).isDisplayed())
			{
				System.out.println("password displayed");
			}
			element.sendKeys("9475977330");
			element1.sendKeys("RishitaRajdip2009@");
			if("9475977330".equalsIgnoreCase(element.getAttribute("value")))
			{
				System.out.println("going right");
				driver.findElement(By.xpath("//input[@data-testid='royal_login_button']")).click();
			}
			else
			{
				System.out.println("something wrong");
			}
	}
}
