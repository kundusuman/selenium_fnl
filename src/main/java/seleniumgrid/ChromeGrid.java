package seleniumgrid;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeGrid 
{
	public static void main(String args[]) throws MalformedURLException
	{
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		String hubUrl="http://172.17.120.233:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(hubUrl),cap);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		
	}

}
