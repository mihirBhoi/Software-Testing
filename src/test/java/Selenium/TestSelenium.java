package Selenium;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;

public class TestSelenium {

	WebDriver driver;
	SoftAssert obj;
	
	@BeforeTest
	public void setupDriver() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	}
	
	@BeforeMethod
	public void before() {
		driver=new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		obj=new SoftAssert();
	}
	
	@DataProvider(name="getdata")
	public Object[][] search(){
		return new Object[][] {{"Roicians"},{"Roicians Automation Testing"},{"RoiciansQA"}};
	}
	
	@Test(dataProvider="getdata")
	public void Display(String keywords) throws InterruptedException {
		driver.findElement(By.cssSelector("#APjFqb")).sendKeys(keywords);
		Thread.sleep(2000);
	}
	
	@Test(priority=1, groups="title")
	public void gettitle() {
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "yahoo");
		obj.assertEquals(title, "yahoo");
		obj.assertAll();
	}
	
	@Test(priority=2, groups="verification", dependsOnMethods= {"gettitle"})
	public void display() {
		boolean a=driver.findElement(By.cssSelector("#gb > div > div:nth-child(1) > div > div:nth-child(1) > a")).isDisplayed();
		System.out.print(a);
	}

	@AfterMethod
	public void aftermethod() {
		driver.close();
	}
}
