package ManageDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchDomain {

	public void searchdomain(WebDriver driver, String domain){
	    Search(driver, domain);
	    driver.findElement(By.id("go")).click();
	    driver.findElement(By.linkText(domain)).click();
	}

	// Search Domain under Manage domain
	public void Search( WebDriver driver, String domain){
	    driver.findElement(By.id("search")).sendKeys(domain);
	}
}


