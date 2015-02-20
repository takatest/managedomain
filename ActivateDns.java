package ManageDomain;

import static org.junit.Assert.assertEquals;
import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActivateDns {

    private static Gobackmyaccount			Gobackmyaccount;		// go back to my account and search domain

	public void activatedns(WebDriver driver, String baseUrl, String domainName){

		Gobackmyaccount =new Gobackmyaccount() ;		// go back to my account and search domain
		if (domainName.endsWith(".com") ||domainName.endsWith(".net") || domainName.endsWith(".info") || domainName.endsWith(".org")){
				driver.findElement(By.linkText("Activate DNS")).click();
				driver.findElement(By.id("tandc")).click();
			    driver.findElement(By.id("enableDnsButton")).click();
			    // Checking Thank you
			    assertEquals("Thank You", driver.findElement(By.cssSelector("div.dnsDetailsDiv > h3")).getText());
				System.out.println(" @--Activate DNS end");
		}else{
			System.out.println("  $--Not support Activate DNS end");
		}
		// go back to the under my account
		Gobackmyaccount.goback(driver, baseUrl, domainName);
	}
}
