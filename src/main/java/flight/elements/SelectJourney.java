package flight.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SelectJourney
{
	WebDriver driver;
	public SelectJourney(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	public void select()
	{
		
	
			driver.findElement(By.xpath("//select[@name='fromPort'] //option[@value='Sydney']")).click();
			driver.findElement(By.xpath("//select[@name='toPort'] //option[@value='Paris']")).click();
			
			driver.findElement(By.xpath("//select[@name='passCount'] //option[@value='4']")).click();
			driver.findElement(By.xpath("//select[@name='fromMonth'] //option[@value='11']")).click();
			driver.findElement(By.xpath("//select[@name='fromDay'] //option[@value='19']")).click();
			driver.findElement(By.xpath("//select[@name='toMonth'] //option[@value='11']")).click();
			driver.findElement(By.xpath("//select[@name='toDay'] //option[@value='20']")).click();
			driver.findElement(By.xpath("//input[@value='First']")).click();
			driver.findElement(By.xpath("//select[@name='airline'] //option[3]")).click();
			driver.findElement(By.name("findFlights")).click();
			
			driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
			driver.findElement(By.xpath("//input[@value='Pangea Airlines$632$282$16:37']")).click();
			driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
			
			driver.findElement(By.name("passFirst0")).sendKeys("Tester1");
			driver.findElement(By.name("passLast0")).sendKeys("LN1");
			Select newelement =new Select( driver.findElement(By.name("pass.0.meal")));
			newelement.selectByVisibleText("Hindu");
			
			
		
			driver.findElement(By.name("passFirst1")).sendKeys("Tester2");
			driver.findElement(By.name("passLast1")).sendKeys("LN2");
			newelement =new Select( driver.findElement(By.name("pass.1.meal")));
			newelement.selectByVisibleText("Low Calorie");
			
			driver.findElement(By.name("passFirst2")).sendKeys("Tester3");
			driver.findElement(By.name("passLast2")).sendKeys("LN3");
			newelement =new Select( driver.findElement(By.name("pass.2.meal")));
			newelement.selectByVisibleText("Kosher");
			
			driver.findElement(By.name("passFirst3")).sendKeys("Tester4");
			driver.findElement(By.name("passLast3")).sendKeys("LN4");
			newelement =new Select( driver.findElement(By.name("pass.3.meal")));
			newelement.selectByVisibleText("No preference");
			
			driver.findElement(By.xpath("//input[@name='creditnumber']")).sendKeys("234234");
			driver.findElement(By.xpath("//input[@value='1325 Borregas Ave.']")).clear();
			driver.findElement(By.xpath("//input[@value='1325 Borregas Ave.']")).sendKeys("101, Notting Hill");
			
			driver.findElement(By.xpath("//input[@name='billCity']")).clear();
			driver.findElement(By.xpath("//input[@name='billCity']")).sendKeys("New Jersey");
			
			driver.findElement(By.xpath("//input[@name='billState']")).clear();
			driver.findElement(By.xpath("//input[@name='billState']")).sendKeys("NJ");
			
			driver.findElement(By.xpath("//input[@name='delZip']")).clear();
			driver.findElement(By.xpath("//input[@name='delZip']")).sendKeys("07342");
			driver.findElement(By.name("buyFlights")).click();
			driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']")).click();
			
	}

}
