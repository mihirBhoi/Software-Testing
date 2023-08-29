package Selenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPOM {
	
	@FindBy(id="alertButton") WebElement alertBtn;
	@FindBy(id="timerAlertButton") WebElement timeAlertBtn;
	@FindBy(id="confirmButton") WebElement confirmBtn;
	@FindBy(id="promtButton") WebElement promptBtn;
	
	public AlertPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickalertbtn(WebDriver driver) {
		alertBtn.click();
		org.openqa.selenium.Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	public void clickalertbtnafterfiveseconds(WebDriver driver) {
		timeAlertBtn.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.alertIsPresent());
		org.openqa.selenium.Alert a=driver.switchTo().alert();
		a.accept();
	}
	
	public void clickconfirmbtn(WebDriver driver) {
		confirmBtn.click();
		org.openqa.selenium.Alert a=driver.switchTo().alert();
		a.dismiss();
	}
	
	public void clickpromptbtn(WebDriver driver, String name) {
		promptBtn.click();
		org.openqa.selenium.Alert a=driver.switchTo().alert();
		a.sendKeys(name);
		a.accept();
	}
}
