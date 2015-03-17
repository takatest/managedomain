package ManageDomain;

import org.openqa.selenium.WebDriver;
import ManageDomain.SearchDomain;

public class Gobackmyaccount {

	SearchDomain search = new SearchDomain();
	
	public void goback(WebDriver driver, String baseUrl, String domain){
		
		driver.get(baseUrl + "/cc/myaccount/domains/index");
		// search domain
		search.searchdomain(driver, domain);
	}
}
