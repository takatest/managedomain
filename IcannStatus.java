package ManageDomain;

import static org.testng.AssertJUnit.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IcannStatus {
	
	public static CheckDomainSpace CheckDomainSpace = new CheckDomainSpace();
	
	public void sentemail(WebDriver driver, String domain){
		// ICANN status doesnt support com.au/net/au
		if ( CheckDomainSpace.icann(domain) == true ){
			driver.findElement(By.id("resendEmailBtn")).click();
			try {
				Thread.sleep(10000);	// wait 10 second
			} catch (InterruptedException e) {
				System.out.println("10 second gone!!");
			}
		    assertEquals("Email Sent!", driver.findElement(By.id("raasuccess")).getText());
			System.out.println("  @--ICANN Status end");
		}else{
			System.out.println("  $--Not support ICANN Status");
			
		}
	}
}
