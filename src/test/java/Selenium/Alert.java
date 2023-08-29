package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert {

	public static void main(String[] args) {
		String name="Mihir";
		
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoqa.com/alerts");

		AlertPOM alertPOM=new AlertPOM(driver);
		alertPOM.clickalertbtn(driver);
		alertPOM.clickalertbtnafterfiveseconds(driver);
		alertPOM.clickconfirmbtn(driver);
		alertPOM.clickpromptbtn(driver, name);
	}

}
