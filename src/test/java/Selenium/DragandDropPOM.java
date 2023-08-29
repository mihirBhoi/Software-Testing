package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DragandDropPOM {
	
	@FindBy(id="draggable") WebElement draggable;
	@FindBy(id="droppable") WebElement droppable;
	
	public DragandDropPOM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void draganddrop(WebDriver driver) {
		Actions action=new Actions(driver);
		//action.dragAndDrop(droppable, draggable).build().perform();
		action.dragAndDrop(driver.findElement(By.id("draggable")), driver.findElement(By.id("droppable"))).build().perform();
	}

}
