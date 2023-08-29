package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demoqa.com/droppable");
		
		DragandDropPOM dragandDropPOM=new DragandDropPOM(driver);
		dragandDropPOM.draganddrop(driver);
	}

}
