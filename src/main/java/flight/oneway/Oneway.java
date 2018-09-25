package flight.oneway;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import flight.elements.LogIn;
import flight.elements.SelectJourney;
import flight.elements.SelectOneWay;
import flight.elements.SelectRoundTrip;

public class Oneway {
	static WebDriver driver;

	@BeforeGroups(groups= {"oneway"})
	public void setup() {
		System.out.println("before Group excecuted...");
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");

	}
	@BeforeGroups(groups= { "twoway"})
	public void setup11() {
		System.out.println("before Group excecuted...");
		System.setProperty("webdriver.chrome.driver", "D:\\NewOxygenWorkspace2\\selenium\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");

	}
	@Test(priority = 1, groups = { "oneway", "twoway" })
	@Parameters({ "username", "password" })
	public void login(String username, String password) {
		System.out.println("Test priority =1....oneway/twoway");

		LogIn LI = new LogIn(driver);
		LI.login(username, password);

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

	}

	@Test(priority = 2, groups = { "oneway" })
	public void selectOne() {
		System.out.println("Test priority =1....oneway/twoway");
		System.out.println("Test priority =2....");
		SelectOneWay SOW = new SelectOneWay(driver);
		SOW.selectOne();

	}

	@Test(priority = 2, groups = { "twoway" })
	public void roundTrip() {
		SelectRoundTrip SRT = new SelectRoundTrip(driver);
		SRT.selectOne();

	}

	@Test(priority = 3, groups = { "oneway", "twoway" })
	public void selectTrip() {
		SelectJourney SJ = new SelectJourney(driver);
		SJ.select();
	}

	@AfterGroups(groups = { "oneway", "twoway" })
	public void setup1() {
		driver.quit();
	}

}
