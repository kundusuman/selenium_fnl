import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test
{
  public static void main(String[] args)
  {
	  WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/search?source=hp&ei=05KNW_rkK4forQG36rCYAw&q=flipkart+india&oq=flipkart+india&gs_l=psy-ab.12...864.983.0.1118.14.3.0.0.0.0.0.0..0.0....0...1.1.64.psy-ab..14.0.0....0.Irmw-LJIfEM");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='rc']//div[@class='r']//a[@href='https://www.flipkart.com/]")).click();
  }
}