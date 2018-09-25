package selenium1_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment11
{
	public static void main(String args[])
	{
			
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.wpengine.com/automation-practice-table/");
		List <WebElement> list=driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr")).findElements(By.tagName("td"));
		for(WebElement element:list)
			System.out.println(element.getText());
		driver.findElement(By.xpath("//table[@class='tsc_table_s13']//tbody//tr//a")).click();;
	}

}
