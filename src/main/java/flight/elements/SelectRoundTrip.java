package flight.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectRoundTrip
{
	WebDriver driver;
	By OneWay= By.xpath("//input[@name='tripType' and @value='roundtrip']");
	public SelectRoundTrip(WebDriver driver)
	{
		
		this.driver=driver;
	}
	public void selectOne()
	{
		System.out.println("2ndgroup");
		driver.findElement(OneWay).click();
	}


}
