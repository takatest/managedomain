package ManageDomain;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LockunlockDomain {

	// lock domain
	public void lockdomain(WebDriver driver, String domain){
		if (domain.endsWith(".com") ||domain.endsWith(".net")|| domain.endsWith(".biz") || domain.endsWith(".info") || domain.endsWith(".org")){
			driver.findElement(By.linkText("Lock/Unlock Domain")).click();
		    driver.findElement(By.name("submit")).click();
		    assertEquals("Domain was locked successfully", driver.findElement(By.cssSelector("#alerts > p")).getText());
			System.out.println("  Domain was locked successfully");
	
			// unlock domain
		    driver.findElement(By.linkText("Lock/Unlock Domain")).click();
		    driver.findElement(By.name("submit")).click();
		    assertEquals("Domain was unlocked successfully", driver.findElement(By.cssSelector("#alerts > p")).getText());
			System.out.println("  Domain was unlocked successfully");
			System.out.println("  @--Lock unlock domain End");
		}else{
			System.out.println("   $--Not support Lock unlock domain");
		}
	}
}
