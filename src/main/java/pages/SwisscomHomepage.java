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

public class SwisscomHomepage extends SwissCom {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[text()='Accept']")
	WebElement eleAcceptButton;
	
	@FindBy(xpath="//sdx-price[@class='hydrated']/ancestor::div/div[text()='Apple iPhone 13']/ancestor::a[contains(@href,'iphone-13')]")
	List<WebElement> eleIphone; 
	
	@FindBy(xpath="//span[text()='Internet']")
	List<WebElement> eleInternet;
	
	@FindBy(xpath="//input[@value='Green']")
	WebElement eleColorBox;
	
	String mobilecolor="//div[@class='color-list']//input[@value='%s']";
	//div[@class='color-list']//input[@value='Green']
	
	String stringSearch="//div[contains(text(),'%s')]";
	
	@FindBy(xpath="//div[@class='memory-list']//input[@name='memory']")
	List<WebElement> elememoryOptions;
	
	boolean isAvailable=false;
	static String secondTab=null;
	
	
	public SwisscomHomepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}


	public void launchSwissComPage() {
		// TODO Auto-generated method stub
		driver.get("https://swisscom.com/");
		//driver.switchTo().alert().accept();
		if(isDisplayed(eleAcceptButton)) {
			eleAcceptButton.click();
			
		}
		
		System.out.println("launched swisscom page sucessfully");
		
	}
	
	public void searchForGivenString(String string) {
		try {
			Thread.sleep(3000);
			if(string.contains("iPhone")) {
				isAvailable=eleIphone.isEmpty();
				
			}else if(string.contains("Internet")) {
				isAvailable=eleInternet.isEmpty();
			
			}
			if(!isAvailable) {
				System.out.println("Given String" +string+" is available on Swisscom page");
			}
		
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public boolean getTheSearchResult() {
		return !isAvailable;
		
		
	}


	public void switchToNewWindow() {
		String mainTab=driver.getWindowHandle();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.open()");
		Set<String> tabs=driver.getWindowHandles();
		for(String tab:tabs) {
			if(!tab.equalsIgnoreCase(mainTab)) {
				driver.switchTo().window(tab);
				secondTab=driver.getWindowHandle();
				driver.get("https://swisscom.com/");
			}
		}
		driver.switchTo().window(mainTab);
	}

	
	public void switchtoSecondTab() {
		driver.switchTo().window(secondTab);
		System.out.println("switched to second tab");
	}

	public void selectMobile(String mobileName) {
		
			try {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", eleIphone.get(1));
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	public void clickOnMobileColor(String color) {
		mobilecolor=mobilecolor.replace("%s", color);
		WebElement eleColorBox=driver.findElement(By.xpath(mobilecolor));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", eleColorBox);
		
	}


	public boolean getStorageOptionsforSelectedColor() {
		boolean stoarage=elememoryOptions.isEmpty();
		
		return !stoarage;
		
	}
	

}
