package ManageDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AutoRenew {

	private static CheckDomainSpace	CheckDomainSpace=new CheckDomainSpace();		// check if domain space can support or not

	public void onoff(WebDriver driver, String domain){
		
		// Auto Renewal support only .com/.net/.org/.info/.biz/com.au/net.au
		if ( CheckDomainSpace.autorenewal(domain)== true){
			// auto renew On 
			driver.findElement(By.id("domainautorenew")).click();
			driver.findElement(By.id("optinToAutoRenewal")).click();
		    assertEquals("Auto-Renewal is now enabled for the selected domain.", driver.findElement(By.xpath("//div[@id='alerts']/p")).getText());
			System.out.println("   @--Auto-renewal On");

			// auto renew Off 
		    driver.findElement(By.id("domainautorenew")).click();
		    driver.findElement(By.id("optinToAutoRenewal")).click();
		    assertEquals("Auto-Renewal has been disabled for the selected domain.", driver.findElement(By.xpath("//div[@id='alerts']/p")).getText());
			System.out.println("   @--Auto-renewal Off");
			System.out.println("  @--Auto-renewal end");
		}else{
			System.out.println("  $--Not supprt Auto-renewal end");
		}
	}
}
