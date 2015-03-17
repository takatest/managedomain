package ManageDomain;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import RegisterdomainName.PaymentPage;
import newRenew.RenewOptionsPage;

public class RenewDomain {

	private static RenewOptionsPage			RenewOptionsPage;
	private static PaymentPage				PaymentPage;
	private static Gobackmyaccount			Gobackmyaccount;
	
	public void renew(WebDriver driver, String baseUrl, String domain, int year){

		RenewOptionsPage = new RenewOptionsPage();
		PaymentPage = new PaymentPage();
		Gobackmyaccount = new Gobackmyaccount();
		
		driver.findElement(By.linkText("Renew Domain")).click();
	    //Review your order 1 year
		RenewOptionsPage.renewYear(driver,domain,year);
	    //Protect Page
		RenewOptionsPage.protect(driver);
	    // payment manually
		PaymentPage.paymentmanually(driver);
		
		// go back to the under my account
		Gobackmyaccount.goback(driver, baseUrl, domain);
		System.out.println("  @--Renew Domain End");
	}
/*	
	public void renewnoprivate(WebDriver driver, String domain){

		RenewOptionsPage = new RenewOptionsPage();
		PaymentPage = new PaymentPage();

		driver.findElement(By.linkText("Renew Domain")).click();
	    //Review your order 1 year
		RenewOptionsPage.renewYear(driver,domain,1);
	    //Protect Page
		RenewOptionsPage.protect(driver);
	    // payment manually
		PaymentPage.paymentmanually(driver);
	}
*/	
}
