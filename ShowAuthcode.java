package ManageDomain;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class ShowAuthcode {

	private static CheckDomainSpace	CheckDomainSpace=new CheckDomainSpace();		// check if domain space can support private reg or not

	// shows auth code on the second top
	public void showsauthcode(WebDriver driver){
			driver.findElement(By.id("authcode")).click();
			System.out.println("  @--show auth code End");
	}
	
	// View Domain Password( AuthInfo )
	public void viewauthcode(WebDriver driver, String domain){
		if (CheckDomainSpace.authcode(domain) == true){
			driver.findElement(By.linkText("View Domain Password")).click();
			//checking auth code with regular expression
			assertTrue(Pattern.compile("[Domain name password (authinfo):]\\b[a-zA-Z]+\\b").matcher(driver.findElement(By.xpath("//div[@id='alerts']/p")).getText()).find());
			System.out.println("  @--view domain password end");
		}else{
			System.out.println("  $--Not support View Auth code");
		}
	}
}
