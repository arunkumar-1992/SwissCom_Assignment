package runner;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@CucumberOptions(tags = "@tc_1", glue = { "stepDefinition" }, plugin = { "html:target/cucumber-reports/cucumber-pretty",
		"json:target/json-cucumber-reports/default/cukejson.json",
		"testng:target/testng-cucumber-reports/cuketestng.xml" }, features = { "src/test/resources/features" })
public class HomePageRunner extends Runner {

	
	@Test(dataProvider = "scenarios")
	public void my_test(PickleWrapper pickle, FeatureWrapper cucumberFeature) {
		getTestNGCucumberRunner().runScenario(pickle.getPickle());
	}

	@DataProvider
	public Object[][] scenarios() {
		return getTestNGCucumberRunner().provideScenarios();
	}

	

}
