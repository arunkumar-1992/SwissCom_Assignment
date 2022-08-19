package stepDefinition;

import Helper.HomePageHelper;
import io.cucumber.java.en.Then;

public class ThenSteps {
	HomePageHelper homepage= new HomePageHelper();
	
	
	@Then("Verify search returned {string} result")
	public void verify_search_returned_result(String string) {
		homepage.verifyStringIsAvailable(string);
	}
	
	
	@Then("Verify different storage options avaialble for different colors")
	public void verify_different_storage_options_avaialble_for_different_colors() {
		//homepage.verifyStringIsAvailable(string);
	}


}
