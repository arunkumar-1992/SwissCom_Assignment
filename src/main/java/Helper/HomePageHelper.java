package Helper;

import static org.testng.Assert.assertTrue;

import java.util.List;

import pages.SwisscomHomepage;

public class HomePageHelper extends ScriptHelper {
	
	SwisscomHomepage homepage= new  SwisscomHomepage(driver);
	

	public void navigateToSwisscomHomePage() {
		homepage.launchSwissComPage();
		
	}
	
	public void searchForGivenStringInSwisscomHomePage(String string) {
		homepage.searchForGivenString(string);
		
	}

	public boolean verifyStringIsAvailable(String string) {
		String text= homepage.getTheSearchResult();
		String expected ="results found for "+'"'+string+'"';
		if(text.contains(expected)) {
			return true;
		}
		return false;
		
		
		
	}

	public void navigateToAnotherTab() {
		homepage.switchToNewWindow();
		
	}

	public void userSelectsMobile(String mobileName) {
		homepage.selectMobile(mobileName);
	}

	public void getMobileDetails(List<String> colors_list, List<String> storage_list) {
		
			for(String color:colors_list) {
				System.out.println("current color  is "+color);
				homepage.clickOnMobileColor(color);
				boolean storageAvailable=homepage.getStorageOptionsforSelectedColor();
				assertTrue(storageAvailable,storage_list+"  is not available on swisscom home page");
		 }
			
			homepage.switchtoSecondTab();
			
	}

}
