package ManageDomain;

import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Redelegate {

	public void delegate(WebDriver driver){
	    driver.findElement(By.linkText("[Redelegate Domain Name]")).click();
		driver.findElement(By.name("hostname3")).clear();
		driver.findElement(By.name("hostname3")).sendKeys("ns3.melbourneit.com.au");
	    driver.findElement(By.name("submitbutton")).click();
	    assertEquals("Name servers were successfully updated.", driver.findElement(By.cssSelector("#alerts > p")).getText());
	    
		System.out.println(" @--Redelegate end");
	}
}
