package selenium1_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment12 
{
	public static void main(String args[])
	{
			
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.wpengine.com/automation-practice-form/ ");
		Select DD=new Select(driver.findElement(By.id("continents")));
		DD.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		DD.selectByVisibleText("Africa");
		List <WebElement> list=driver.findElement(By.id("continents")).findElements(By.tagName("option"));
		for(WebElement element:list)
		{
			System.out.println(element.getText());
		}
		
		
	}
}
