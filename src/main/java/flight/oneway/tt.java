package flight.oneway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class tt {
	public static void main(String args[])
	{
	WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
	driver.get("http://www.google.com");

}
}