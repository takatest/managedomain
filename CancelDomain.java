package ManageDomain;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancelDomain {

	public void cancel(WebDriver driver){
		driver.findElement(By.linkText("Cancel Domain")).click();
	    // wait 
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.id("confirm")).click();
		driver.findElement(By.name("submit")).click();

	    // wait 
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		//checking Successfully message with regular expression
		assertTrue(Pattern.compile("[Successfully cancelled domain name:]\\b[a-zA-Z]+\\b").matcher(driver.findElement(By.id("alerts")).getText()).find());
		System.out.println("  @--Cancel domain end");
	}
}
