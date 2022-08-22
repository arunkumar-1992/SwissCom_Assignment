package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwisscomHomepage extends SwissCom {
	
	public WebDriver driver;
	
	
	
	
	
	
	
	
	@FindBy(xpath="//div[contains(@class,'render-header')]//sdx-header")
	WebElement elesearchHeader;
	
	@FindBy(xpath="//button[text()='Accept']")
	WebElement eleAcceptButton;
	
	@FindBy(xpath="//div[@class='result-info default']/p")
	WebElement eleResultInfo;
	
	String phoneLink="//h2/a[text()='%s']";
	
	
	@FindBy(xpath="//span[text()='Internet']")
	List<WebElement> eleInternet;
	
	@FindBy(xpath="//input[@value='Green']")
	WebElement eleColorBox;
	
	String mobilecolor="//div[@class='color-list']//label//input[@value='%s' and @type='radio']";
	
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
	
	public  SearchContext getShadowRootElement(Object  elesearchHeader) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		SearchContext eleShadow=  (SearchContext)jse.executeScript("return arguments[0].shadowRoot", elesearchHeader);
			       
		return eleShadow;
		
	}
	
	
	public void executeJavaScript(WebElement element) {
		String script = "arguments[0].click();";
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		try {
			Thread.sleep(3000);
			jse.executeScript(script,element);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void searchForGivenString(String string) {
			//1st code block to handle shadow elements of opening search button
			SearchContext root1=getShadowRootElement(elesearchHeader);
			WebElement element1=root1.findElement(By.cssSelector("sdx-icon[class='icon hydrated icon-search']"));
			SearchContext root2=getShadowRootElement(element1);
			WebElement element2 = root2.findElement(By.cssSelector("sdx-animation>sdx-flip>span"));
			executeJavaScript(element2);
		
			
			//2nd code block to enter the text in Search field
			SearchContext elesearch=getShadowRootElement(driver.findElement(By.cssSelector("scs-search-input")));
			WebElement elements=elesearch.findElement(By.cssSelector("input"));
			elements.sendKeys(string);
			
	
			//3rd  below code is to click search button after entering details
			WebElement elebutton=elesearch.findElement(By.cssSelector("sdx-button"));
			SearchContext shadowButton=getShadowRootElement(elebutton);
			WebElement elebutton_icon=shadowButton.findElement(By.cssSelector("sdx-icon"));
			SearchContext shadowIcon=getShadowRootElement(elebutton_icon);
			WebElement elebuttonSearch=shadowIcon.findElement(By.cssSelector("sdx-animation>sdx-flip>span"));
			executeJavaScript(elebuttonSearch);
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
	

	public String getTheSearchResult() {
		
		if(isDisplayed(eleResultInfo)){
			return eleResultInfo.getText();
		}
		return "";
		
		
	}

	
	public void switchtoSecondTab() {
		driver.switchTo().window(secondTab);
		System.out.println("switched to second tab");
	}

	public void selectMobile(String mobileName) {
		String xpath=phoneLink.replace("%s", mobileName);
		WebElement elephoneLink=driver.findElement(By.xpath(xpath));
		isDisplayed(elephoneLink);
		elephoneLink.click();
		
	}
	
	public void clickOnMobileColor(String color) {
		try {
			Thread.sleep(3000);
			String eleColor=mobilecolor.replace("%s", color);
			WebElement eleColorBox=driver.findElement(By.xpath(eleColor));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click()", eleColorBox);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	public boolean getStorageOptionsforSelectedColor() {
		boolean stoarage=elememoryOptions.isEmpty();
		
		return !stoarage;
		
	}
	

}
