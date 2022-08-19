package stepDefinition;

import Helper.HomePageHelper;
import io.cucumber.java.en.When;

public class WhenSteps {
	HomePageHelper homepage= new HomePageHelper();
	
	@When("User Searches for {string}")
	public void user_searches_for(String string) {
		homepage.searchForIphoneInSwisscomHomePage(string);
	}
	
	
	@When("user navigates Swisscom homepage in another tab")
	public void user_navigates_swisscom_homepage_in_another_tab() {
		homepage.navigateToAnotherTab();
	}
	
	
	@When("User Selects {string}")
	public void user_selects(String string) {
		homepage.userSelectsMobile(string);
	}


}
