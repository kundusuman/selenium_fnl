//package selenium;
//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.InputEvent;
//import java.awt.event.KeyEvent;
//import java.util.ArrayList;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Selenium2__3 
//{
//	public static void main(String args[])
//	{
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.google.co.in");
//		WebDriverWait wait= new WebDriverWait(driver,10);
//		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//		
//		List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//		driver.get("http://toolsqa.com");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
//		WebElement element = driver.findElement(By.linkText("DEMO SITES"));
//		 
//        Actions action = new Actions(driver);
// 
//        action.moveToElement(element).click().build().perform();
//        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
//        List<WebElement> list= element.findElements(By.xpath("./../ul//span/span/span"));
//        for(WebElement a: list)
//        {
//        	System.out.println(a.getText());
//        }
//        
//		list.get(0).click();
//       // newTab(driver);
//		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
//		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
//		System.out.println(tabs1.size());
//		driver.switchTo().window(tabs1.get(tabs1.size()-1));
//		System.out.println(driver.getCurrentUrl());
//				
//	}
//
//}
//        
//		
//	}
//
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	private static void newTab(WebDriver driver) 
//	{
//		try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_T);
//            robot.keyRelease(KeyEvent.VK_T);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//
//		  		} catch (AWTException e) {
//		  				e.printStackTrace();
//		  								}
//		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
//
//		driver.switchTo().window(tabs.get(tabs.size()-1));
//		
//	}
//
//}
