package Helper;

import static org.testng.Assert.assertTrue;

import pages.SwissCom;
import pages.SwisscomHomepage;

public class HomePageHelper extends ScriptHelper {
	
	SwisscomHomepage homepage= new  SwisscomHomepage(driver);
	

	public void navigateToSwisscomHomePage() {
		homepage.launchSwissComPage();
		
	}
	
	public void searchForIphoneInSwisscomHomePage(String string) {
		homepage.searchForGivenString(string);
		
	}

	public void verifyStringIsAvailable(String string) {
		Boolean page=homepage.getTheSearchResult(string);
		assertTrue(page,string+"is not available on swisscom home page");
		//assert.assertEquals(false, page);
		
	}

	public void navigateToAnotherTab() {
		homepage.switchToNewWindow();
		
	}

	public void userSelectsMobile(String mobileName) {
		homepage.selectMobile(mobileName);
		
	}

}
