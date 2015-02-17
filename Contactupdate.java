package ManageDomain;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Contactupdate {

    private static Gobackmyaccount			Gobackmyaccount;		// go back to my account and search domain

	public void update(WebDriver driver, String baseUrl, String domain ){
	
		Gobackmyaccount = new Gobackmyaccount();
		
		driver.findElement(By.cssSelector("a[title=\"Update your contact details for this domain\"]")).click();
	    driver.findElement(By.name("contactfirstname")).clear();
	    driver.findElement(By.name("contactfirstname")).sendKeys("first updated");
	    driver.findElement(By.name("contactlastname")).clear();
	    driver.findElement(By.name("contactlastname")).sendKeys("last updated");

	    if (!domain.contains(".com") && !domain.contains(".net")){
		    driver.findElement(By.name("contactinstitution")).clear();
		    driver.findElement(By.name("contactinstitution")).sendKeys("tester");
	    }
	    driver.findElement(By.name("contactaddressline1")).clear();
	    driver.findElement(By.name("contactaddressline1")).sendKeys("address 1 updated");
	    driver.findElement(By.name("contactaddressline2")).clear();
	    driver.findElement(By.name("contactaddressline2")).sendKeys("address 2 updated");
	    driver.findElement(By.name("contactaddressline3")).clear();
	    driver.findElement(By.name("contactaddressline3")).sendKeys("address 3 updated");
	    driver.findElement(By.name("contactsuburb")).clear();
	    driver.findElement(By.name("contactsuburb")).sendKeys("Melb updated");
	    driver.findElement(By.name("contactstate")).clear();
	    driver.findElement(By.name("contactstate")).sendKeys("NSW");
	    driver.findElement(By.name("contactpostcode")).clear();
	    driver.findElement(By.name("contactpostcode")).sendKeys("2000");
	    driver.findElement(By.name("contactemail")).clear();
	    driver.findElement(By.name("contactemail")).sendKeys("testing@melbourneit.com.au");
	    driver.findElement(By.name("contactphone2")).clear();
	    driver.findElement(By.name("contactphone2")).sendKeys("22222222");
	    driver.findElement(By.name("proceedbutton")).click();
	    assertEquals("Update Successful!", driver.findElement(By.cssSelector("#update-results > p")).getText());
	
		// go back to the under my account
		Gobackmyaccount.goback(driver, baseUrl, domain);

		System.out.println("  @--Contact update end");
	}
	public void advancededit(WebDriver driver, String domain){
		
		  driver.findElement(By.cssSelector("a[title=\"Update your contact details for this domain\"]")).click();
		    driver.findElement(By.cssSelector("#content > p > a")).click();
		    driver.findElement(By.name("registrantaddressline1")).clear();
		    driver.findElement(By.name("registrantaddressline1")).sendKeys("updated advance");
		    driver.findElement(By.name("registrantaddressline2")).clear();
		    driver.findElement(By.name("registrantaddressline2")).sendKeys("update advance2");
		    driver.findElement(By.name("registrantaddressline3")).clear();
		    driver.findElement(By.name("registrantaddressline3")).sendKeys("update advance 3");
		    new Select(driver.findElement(By.name("registrantcountry"))).selectByVisibleText("Australia");
		    driver.findElement(By.name("adminfirstname")).clear();
		    driver.findElement(By.name("adminfirstname")).sendKeys("taka advanced");
		    driver.findElement(By.name("adminlastname")).clear();
		    driver.findElement(By.name("adminlastname")).sendKeys("last advanced");
		    if (!domain.contains(".com") && !domain.contains(".net")){
			    driver.findElement(By.name("admininstitution")).clear();
			    driver.findElement(By.name("admininstitution")).sendKeys("melb IT");
		    }
		    driver.findElement(By.name("adminaddressline1")).clear();
		    driver.findElement(By.name("adminaddressline1")).sendKeys("admin advance1");
		    driver.findElement(By.name("adminaddressline2")).clear();
		    driver.findElement(By.name("adminaddressline2")).sendKeys("admin advance2");
		    driver.findElement(By.name("adminaddressline3")).clear();
		    driver.findElement(By.name("adminaddressline3")).sendKeys("admin advance3");
		    driver.findElement(By.name("adminsuburb")).clear();
		    driver.findElement(By.name("adminsuburb")).sendKeys("sydney");
		    driver.findElement(By.name("adminstate")).clear();
		    driver.findElement(By.name("adminstate")).sendKeys("NSW");
		    driver.findElement(By.name("adminpostcode")).clear();
		    driver.findElement(By.name("adminpostcode")).sendKeys("1000");
		    new Select(driver.findElement(By.name("admincountry"))).selectByVisibleText("Australia");
		    driver.findElement(By.name("techfirstname")).clear();
		    driver.findElement(By.name("techfirstname")).sendKeys("taka advanced");
		    driver.findElement(By.name("techlastname")).clear();
		    driver.findElement(By.name("techlastname")).sendKeys("last advanced");
		    if (!domain.contains(".com") && !domain.contains(".net")){
			    driver.findElement(By.name("techinstitution")).clear();
			    driver.findElement(By.name("techinstitution")).sendKeys("Melb IT");
		    }
		    driver.findElement(By.name("techaddressline1")).clear();
		    driver.findElement(By.name("techaddressline1")).sendKeys("tech advance1");
		    driver.findElement(By.name("techaddressline2")).clear();
		    driver.findElement(By.name("techaddressline2")).sendKeys("tech advance2");
		    driver.findElement(By.name("techsuburb")).clear();
		    driver.findElement(By.name("techsuburb")).sendKeys("Brisbane");
		    driver.findElement(By.name("techstate")).clear();
		    driver.findElement(By.name("techstate")).sendKeys("QLD");
		    new Select(driver.findElement(By.name("techcountry"))).selectByVisibleText("Australia");
		    driver.findElement(By.name("billfirstname")).clear();
		    driver.findElement(By.name("billfirstname")).sendKeys("taka advanced");
		    driver.findElement(By.name("billlastname")).clear();
		    driver.findElement(By.name("billlastname")).sendKeys("last advanced");
		    if (!domain.contains(".com") && !domain.contains(".net")){
		    	driver.findElement(By.name("billinstitution")).clear();
		    	driver.findElement(By.name("billinstitution")).sendKeys("Melb IT");
		    }
		    driver.findElement(By.name("billaddressline1")).clear();
		    driver.findElement(By.name("billaddressline1")).sendKeys("billing advance1");
		    driver.findElement(By.name("billaddressline2")).clear();
		    driver.findElement(By.name("billaddressline2")).sendKeys("billing advance2");
		    driver.findElement(By.name("billaddressline3")).clear();
		    driver.findElement(By.name("billaddressline3")).sendKeys("billing advance3");
		    driver.findElement(By.name("billsuburb")).clear();
		    driver.findElement(By.name("billsuburb")).sendKeys("Perth");
		    driver.findElement(By.name("billstate")).clear();
		    driver.findElement(By.name("billstate")).sendKeys("WA");
		    driver.findElement(By.name("billpostcode")).clear();
		    driver.findElement(By.name("billpostcode")).sendKeys("4000");
		    new Select(driver.findElement(By.name("billcountry"))).selectByVisibleText("Australia");
		    driver.findElement(By.name("proceedbutton")).click();
		    assertEquals("Contacts-Updated", driver.findElement(By.cssSelector("#alerts > p")).getText());

		    System.out.println("    @--Contact update advanced edit end");
	}

}
