package mousehover;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseHover 
{
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		Actions action=new Actions(driver);
		WebElement element=driver.findElement(By.xpath("//a[@class='gb_b gb_ec' and @title='Google apps']"));
		action.moveToElement(element).perform();;
		System.out.println(element.getAttribute("title"));
		
	}

}
