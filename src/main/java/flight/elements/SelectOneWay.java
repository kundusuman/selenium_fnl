package flight.elements;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectOneWay
{
	WebDriver driver;
	By OneWay= By.xpath("//input[@name='tripType' and @value='oneway']");
	public SelectOneWay(WebDriver driver)
	{
		
		this.driver=driver;
	}
	public void selectOne()
	{
		
		System.out.println("1st group");
		driver.findElement(OneWay).click();
	}

}
