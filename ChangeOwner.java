package ManageDomain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import RegisterdomainName.PaymentPage;

public class ChangeOwner {

    private static PaymentPage PaymentPage = new PaymentPage();
    private static Gobackmyaccount	Gobackmyaccount = new Gobackmyaccount();		// go back to my account and search domain
	private static CheckDomainSpace	CheckDomainSpace=new CheckDomainSpace();		// check if domain space can support or not

    public void changeonwer(WebDriver driver, String baseUrl, String domainname){
    	
    	// change domain owner support only com/net not sure why
    	if (CheckDomainSpace.changeowner(domainname) == true){
			// click change domain Owner link
			driver.findElement(By.linkText("Change Domain Owner")).click();
		    driver.findElement(By.id("orgnname")).clear();
		    driver.findElement(By.id("orgnname")).sendKeys("changed owner");
		    driver.findElement(By.id("orgnaddress1")).clear();
		    driver.findElement(By.id("orgnaddress1")).sendKeys("Level 3, 469 La Trobe St");
		    driver.findElement(By.id("orgncity")).clear();
		    driver.findElement(By.id("orgncity")).sendKeys("Melbourne");
		    driver.findElement(By.id("orgnstate")).clear();
		    driver.findElement(By.id("orgnstate")).sendKeys("VIC");
		    driver.findElement(By.id("orgnpostcode")).clear();
		    driver.findElement(By.id("orgnpostcode")).sendKeys("3000");
		    new Select(driver.findElement(By.name("orgncountry"))).selectByVisibleText("Australia");
		    
		    if (domainname.contains(".org")){
			    driver.findElement(By.id("orgnemail")).clear();
			    driver.findElement(By.id("orgnemail")).sendKeys("takashi.komuro@melbourneit.com.au");
			    driver.findElement(By.id("orgnphone")).clear();
			    driver.findElement(By.id("orgnphone")).sendKeys("+61.12122222");
		    }
		    driver.findElement(By.id("filladmin")).click();
		    driver.findElement(By.id("adminfname")).clear();
		    driver.findElement(By.id("adminfname")).sendKeys("updated taka");
		    driver.findElement(By.id("adminsname")).clear();
		    driver.findElement(By.id("adminsname")).sendKeys("updated ko");
		    driver.findElement(By.id("adminemail")).clear();
		    driver.findElement(By.id("adminemail")).sendKeys("takashi.komuro@melbourneit.com.au");
		    driver.findElement(By.id("adminphone")).clear();
		    driver.findElement(By.id("adminphone")).sendKeys("+61.286242400");
		    driver.findElement(By.id("confirm")).click();
		    driver.findElement(By.id("submitbutton")).click();
		    driver.findElement(By.cssSelector("span.bold-text")).click();
		    
		    // payment page
		    PaymentPage.paymentsimple(driver);
			// go back to the under my account
			Gobackmyaccount.goback(driver, baseUrl, domainname);

			System.out.println("  @--Change domain Owner end");
		}else{
			System.out.println("   $--Not supprt Change domain Owner end");
		}
    }
}
