package runner;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.cucumber.testng.TestNGCucumberRunner;
import pages.SwissCom;

public class Runner extends SwissCom {
	
	private TestNGCucumberRunner testNGCucumberRunner;

	
	public TestNGCucumberRunner getTestNGCucumberRunner() {
		return testNGCucumberRunner;
	}

	public void setTestNGCucumberRunner(TestNGCucumberRunner testNGCucumberRunner) {
		this.testNGCucumberRunner = testNGCucumberRunner;
	}

	///Drivers\\gecko\\geckodriver.exe
	@BeforeSuite(alwaysRun = true)
	public void initalizeDriver() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		///src/main/resources/Drivers/chrome/chromedriver.exe"
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "./Drivers\\chrome\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterSuite(alwaysRun = true)
	public void tearDownClass() throws Exception {
		driver.quit();
		testNGCucumberRunner.finish();
	}

}
