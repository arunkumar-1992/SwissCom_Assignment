package runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.swisscom.utilities.DataTableReader;
import com.swisscom.utilities.ReadConfigurationFile;

public class Framework {

	ReadConfigurationFile config = new ReadConfigurationFile();
	WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void initalizeDriver() throws Exception {
		String browser = config.getDriverType();
		String driverPath = config.getDriverPath(config.getDriverType());
		System.out.println("driverpath     " + driverPath);
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Safari")) {
			System.setProperty("webdriver.safari.driver", driverPath);
			driver = new SafariDriver();
		} else {
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void my_test() {
		DataTableReader table = new DataTableReader();

		try {
			table.createDataTable(System.getProperty("user.dir") + "./src/test/resources/TestData.xls");
			table.storeColumns();
			int rowNo = table.getRowNumberToGetData(config.getEnvironmentType());
			String url = table.getColumnValue("Url", rowNo);
			String userName = table.getColumnValue("UserName", rowNo);
			String password = table.getColumnValue("Password", rowNo);
			System.out.println("url is      " + url);
			System.out.println("userName is      " + userName);
			System.out.println("password  is     " + password);
			driver.get(url);
			Assert.assertTrue(url.equals(driver.getCurrentUrl()), "URLS are not matching");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest(alwaysRun = true)
	public void tearDownClass() throws Exception {
		driver.quit();
	}
}
