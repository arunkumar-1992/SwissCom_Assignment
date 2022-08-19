package stepDefinition;

import Helper.HomePageHelper;
import io.cucumber.java.en.Given;

public class GivenSteps {
	
	HomePageHelper homepage= new HomePageHelper();
	
	@Given("User Navigates to Swisscom Homepage")
	public void user_navigates_to_swisscom_homepage() {
		
		homepage.navigateToSwisscomHomePage();
	    
	    //throw new io.cucumber.java.PendingException();
	}

	
	
	

	

	


	
	
	

}
