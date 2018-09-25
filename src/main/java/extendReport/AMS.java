package extendReport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
public class AMS 
{
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "./driver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		WebDriver driver = new RemoteWebDriver(new URL("http://Jenkins.ip.here:4444/wd/hub"), capability);
//visiting home page
		driver.get("https://corpapps.mindtree.com/ams");
		WebDriverWait wait=new WebDriverWait(driver,10);
//visiting ams page
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='category-cont-wrap purple']//p[contains(text(),'View your details, raise stay out and travel requests.')]")));
		element.click();
//creating new page
		WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newReq")));
		element1.click();
		Date date = new Date();  
//formating date
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
		String strDate= formatter.format(date);
//adding date in from date
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtFromDate")));
		element.sendKeys(strDate);
//adding date in to date
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtToDate")));
		element.sendKeys(strDate);
//adding comments
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestorComments")));
		element.sendKeys("marketing");
//selecting requesttime
		Select newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlRequestType"))));
		newelement.selectByVisibleText("Mon-Fri (5:30PM -10:30PM)");
//selecting meal
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chkBoxNone")));
		element.click();
//selecting from time
		newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpFromTime"))));
		newelement.selectByVisibleText("5:30 PM");
//selecting to time
		newelement =new Select( wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("drpToTime"))));
		newelement.selectByVisibleText("10:30 PM");
//submitting
		element=driver.findElement(By.id("submit"));
		element.click();
//handeling alert
		Alert alert=driver.switchTo().alert();
		alert.accept();
//Screensort
		File ss=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(ss, new File("D://Ams/" + strDate + ".jpg"));
//		
	}

}
