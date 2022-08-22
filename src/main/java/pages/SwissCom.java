package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class SwissCom {
	
	public static WebDriver driver;
	
	
	
	public boolean isDisplayed(WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		return element.isDisplayed();
	}

}
