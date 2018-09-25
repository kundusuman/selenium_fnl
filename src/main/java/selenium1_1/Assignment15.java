package selenium1_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment15 
{
	public static void main(String args[]) throws InterruptedException, AWTException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.gmail.co.in");
		WebDriverWait wait= new WebDriverWait(driver,10);
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
		element1.sendKeys(args[0]);
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//content[@class='CwaK9']//span[contains(text(),'Next')]")));
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		element1.sendKeys(args[1]);
		element1=driver.findElement(By.id("passwordNext"));
		element1.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")));
		if(element1.isDisplayed())
		{
			System.out.println("chrome opened verified");
		}
		else
		{
			System.out.println("not verified");
		}
		element1.click();
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='wO nr l1']//textarea[@class='vO']")));
		element1.sendKeys("sumankundudecember@gmail.com");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":nn")));
		element1.sendKeys("testing");
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(":os")));
		element1.sendKeys("testing first ");
		 driver.findElement(By.xpath("//div[@class='J-J5-Ji J-Z-I-J6-H']//div[@class='a1 aaA aMZ']")).click();
		  //click on attachment icon
		 StringSelection ss = new StringSelection("C:\\Users\\M1047073\\Desktop\\text.txt");
		     //upload your file using RobotClass
		     //attach your path where file is located.
		     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		     Robot robot = new Robot();
		     driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		     robot.keyPress(KeyEvent.VK_CONTROL);
		     robot.keyPress(KeyEvent.VK_V);
		     robot.keyRelease(KeyEvent.VK_CONTROL);
		     robot.keyRelease(KeyEvent.VK_V);
		     driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		     robot.keyPress(KeyEvent.VK_ENTER);
		     robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=':nd']")));
		element1.click();


	}
}
