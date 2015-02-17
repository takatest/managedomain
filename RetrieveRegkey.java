package ManageDomain;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetrieveRegkey {

	public void retriveregkey(WebDriver driver){
		driver.findElement(By.linkText("Retrieve")).click();	
		assertEquals("Retrieval Success", driver.findElement(By.cssSelector("h2.confirmation")).getText());

		// go back to previous page
		driver.navigate().back();
		System.out.println("  @--Retrieve Registry key End");
	}
}
