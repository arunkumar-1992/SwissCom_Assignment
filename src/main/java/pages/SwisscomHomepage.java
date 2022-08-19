package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwisscomHomepage {
	
	public WebDriver driver;
	//)[1]
	@FindBy(xpath="//sdx-price[@class='hydrated']/ancestor::div/div[text()='Apple iPhone 13']/ancestor::a[contains(@href,'iphone-13')]")
	List<WebElement> eleIphone; 
	
	@FindBy(xpath="//button[text()='Accept']")
	WebElement eleAcceptButton;
	String stringSearch="//div[contains(text(),'%s')]";
	
	
	public SwisscomHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public void launchSwissComPage() {
		// TODO Auto-generated method stub
		driver.get("https://swisscom.com/");
		//driver.switchTo().alert().accept();
		eleAcceptButton.click();
		//System.out.println("launched swisscom page sucessfully");
		
	}
	
	public void searchForGivenString(String string) {
		String xpath=stringSearch.replace("%s", "Apple iPhone 13");
		try {
			Thread.sleep(3000);
			if(string.contains("iPhone")) {
				System.out.println("inside iphone condition");
				System.out.println("is it available"+eleIphone);
				boolean isAvailable=eleIphone.isEmpty();
				System.out.println("is it available"+isAvailable);
				if(!isAvailable) {
					System.out.println("iphone is available ");
				}
				
			
			}else {
			
			}
		
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean getTheSearchResult(String string) {
		//String xpath=stringSearch.replace("%s", string);
		//List<WebElement> ele=driver.findElements(By.xpath(xpath));
		//return ele.isEmpty();
		boolean isAvaialable = false;
		
		try {
			Thread.sleep(1000);
			if(string.contains("iPhone")) {
				isAvaialable=eleIphone.isEmpty();
				
			
			}else {
			
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !isAvaialable;
		
		
	}


	public void switchToNewWindow() {
		String mainTab=driver.getWindowHandle();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		Set<String> tabs=driver.getWindowHandles();
		for(String tab:tabs) {
			if(!tab.equalsIgnoreCase(mainTab)) {
				driver.switchTo().window(tab);
				driver.get("https://swisscom.com/");
				System.out.println("open swisscom home page in second tab");
			}
		}
		driver.switchTo().defaultContent();
	}


	public void selectMobile(String mobileName) {
		
	
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", eleIphone.get(1));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

}
