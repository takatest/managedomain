package ManageDomain;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PrivateReg {

	private static Gobackmyaccount	Gobackmyaccount = new Gobackmyaccount();		// go back to my account and search domain
	private static CheckDomainSpace	CheckDomainSpace=new CheckDomainSpace();		// check if domain space can support private reg or not
	
	// private registration buy
	public void privatebuy(WebDriver driver, String domain, String baseUrl ){

		if (CheckDomainSpace.privatereg(domain) == true){
			
			try {
				driver.findElement(By.linkText("Enable Private Registration")).click();
			    driver.findElement(By.name("submit")).click();
			    driver.findElement(By.cssSelector("div.red-button.form-submit")).click();
			    driver.findElement(By.name("cardverificationcode1")).clear();
			    driver.findElement(By.name("cardverificationcode1")).sendKeys("122");
			    driver.findElement(By.id("tandc")).click();
			    driver.findElement(By.cssSelector("div.form-button-span")).click();
			    
			    System.out.println("  @--Private registration end");
			} catch (Exception e) {
				System.out.println("  @--Private registration failed. it could be already Active");
			}
			// go back to the under my account
			Gobackmyaccount.goback(driver, baseUrl, domain);
	
		}
	}	
	
	// private registration active
	public void active(WebDriver driver, String domain){
		if (CheckDomainSpace.privatereg(domain) == true){
			driver.findElement(By.linkText("Active")).click();
		    assertEquals("Suspended", driver.findElement(By.linkText("Suspended")).getText());
			System.out.println("  @--Private reg active end");
		}else{
			System.out.println("   $--Not support Private reg Active end");
		}
	}
	
	// private registration suspend
	public void suspend(WebDriver driver, String domain){
		if (CheckDomainSpace.privatereg(domain) == true){

			driver.findElement(By.linkText("Suspended")).click();
		    assertEquals("Active", driver.findElement(By.linkText("Active")).getText());
	
		    System.out.println("  @--Private reg suspend end");
		}else{
			System.out.println("    $--Not support Private reg suspend end");
		}
	}	
}
