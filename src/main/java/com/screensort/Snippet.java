package com.screensort;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snippet {
	public static String takeScreenShot() {
			WebDriver driver = InitWebdriver.getDefaultDriver();
			return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		}
}

