package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Helper.HomePageHelper;
import io.cucumber.java.en.Then;

public class ThenSteps {
	HomePageHelper homepage= new HomePageHelper();
	
	
	@Then("Verify search returned {string} result")
	public void verify_search_returned_result(String string) {
		boolean bool=homepage.verifyStringIsAvailable(string);
		assertTrue(bool,string +"  is not available on swisscom home page");
		//assert.assertEquals(false, page);
	}
	
	
	@Then("Verify different storage options avaialble for different colors")
	public void verify_different_storage_options_avaialble_for_different_colors() {
		String[] colors = {"Green","(PRODUCT)RED","Midnight","Blue","Starlight","Pink"};
		 List<String> colors_list = new ArrayList<String>(Arrays.asList(colors));
		
		String[] storage = {"128","256","512"};
		List<String> storage_list = new ArrayList<String>(Arrays.asList(storage));
		homepage.getMobileDetails(colors_list,storage_list);
		
		
		
		
		
	}


}
