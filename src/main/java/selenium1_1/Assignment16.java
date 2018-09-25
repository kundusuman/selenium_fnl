package selenium1_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment16 
{
	public static void main (String args[])
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		
		
		
		
		
		
	}

}
