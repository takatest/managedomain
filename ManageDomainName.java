package ManageDomain;
import java.util.concurrent.TimeUnit;

import newgTLDlink.UnderManageDomainPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.ie.*;

import RegisterdomainName.LoginPage;

public class ManageDomainName {

	private FirefoxDriver 					driver;					// firefox driver
//	private WebDriver 						driver;					// IE driver
	//    private static UnderManageDomainPage 	UnderManageDomainPage;	// Create My account page
    private static LoginPage 				LoginPage;				// login page
    private static LockunlockDomain 		LockunlockDomain;		// lock and unlock domain
    private static RetrieveRegkey			RetrieveRegkey;			// Retrieve registry key
    private static ShowAuthcode				ShowAuthcode;			// shows authcode
    private static IcannStatus				IcannStatus;			// ICANN Status
    private static PrivateReg				PrivateReg;				// PrivateRegistration
    private static AutoRenew				AutoRenew;				// Auto renew					
    private static ChangeOwner				ChangeOwner;			// change Domain Owner
    private static Contactupdate			Contactupdate;			// contact update		
    private static RenewDomain				RenewDomain;			// renew domain
    private static Redelegate				Redelegate;				// Redelegate
    private static ActivateDns				ActivateDns;			// Activate DNS		
    private static CancelDomain				CancelDomain;			// Cancel Domain		
    private static CheckDomainSpace			CheckDomainSpace;		// check if domain space can support private reg or not
    private static SearchDomain				SearchDomain;			// Search domain
    private static int						renew_year = 1;			// renew year				
    private static int						domain_num = 1;			// number of domain
	private static String					domain = "remind90r20150209170557";
    private static String[] 				domain_space = {"creditcard","net","com","net"};// domain space
	private String 							myaccount = "TAKAAUTO";			// my account			property
	private String 							password = "password";					// my account password	property

	
	private String baseUrl = "https://stage.melbourneit.com.au/";		//URL stage
//	private Sstring baseUrl = "https://www.melbourneit.com.au/";		//URL prod
    
	@BeforeTest
	public void BeforeTest() {
		// FireFox
		driver = new FirefoxDriver();
/*		// IE
		System.setProperty("webdriver.ie.driver","C:\\eclipse_latest\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();

		// Chrome
		System.setProperty("webdriver.chrome.driver","C:\\eclipse_latest\\chromedriver.exe");
        driver = new ChromeDriver();
*/		
		driver.get(baseUrl); 
		 
	    System.out.println("-------------Manage Domain name Test--------------");
	    // create page object
	    LockunlockDomain = new LockunlockDomain();
	    LoginPage = new LoginPage();
//	    UnderManageDomainPage = new UnderManageDomainPage();
	    SearchDomain = new SearchDomain();
	    RetrieveRegkey = new RetrieveRegkey();
	    ShowAuthcode = new ShowAuthcode();
	    PrivateReg = new PrivateReg();
	    ChangeOwner = new ChangeOwner();
	    RenewDomain = new RenewDomain();
	    Contactupdate = new Contactupdate();
	    Redelegate = new Redelegate();
	    ActivateDns = new ActivateDns();
	    CancelDomain = new CancelDomain();
	    CheckDomainSpace = new CheckDomainSpace();
	    AutoRenew = new AutoRenew();
	    IcannStatus = new IcannStatus();
	    
	    // wait 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	     
		// login to my account
		LoginPage.normalloginmyaccount(driver, myaccount, password);
		System.out.println("login to my account end");
	}

	// set up data
	@DataProvider(name = "GetDomain")
	public static Object[][] domainName() {
		Object[][] data = new Object[domain_num][2];
		for (int k = 0; k<domain_num; k++){
			String domainName = domain+"."+domain_space[k];
			data[k][0]= k+1;
			data[k][1]= domainName;
		}
		return data;
	}
/********************************************************************************************
 * 	
 * Manage domain test - from under domain manage
 * 
 ********************************************************************************************/
	@Test(dataProvider = "GetDomain")
	public void ManageDomain(int number, String domainName){
	    System.out.println(number+"-"+domainName);
		
		driver.get(baseUrl + "/cc/myaccount/domains/index");			// go to the under my account
		SearchDomain.searchdomain(driver, domainName);					// go to under domain domain page
		System.out.print("1");
		LockunlockDomain.lockdomain(driver, domainName);				// lock and unlock domain
/*		System.out.print("2");
		RenewDomain.renew(driver, baseUrl, domainName, renew_year);		// renew domain for 1 year 
*/		System.out.print("3");
		RetrieveRegkey.retriveregkey(driver);							// Retrieve registry key
		System.out.print("4");
		ShowAuthcode.showsauthcode(driver);								// shows Auth Code

		// private registration, show Authcode, Change ownership support only com/net/info/org 
		System.out.print("5");
		PrivateReg.privatebuy(driver, domainName, baseUrl);				// private registration On
		PrivateReg.active(driver,domainName);							// private registration click active
		PrivateReg.suspend(driver,domainName);							// private registration click suspend
		
		System.out.print("6");
		IcannStatus.sentemail(driver, domainName);						// ICANN Status send email
		System.out.print("7");
		AutoRenew.onoff(driver,domainName);								// Auto renew On and Off
		System.out.print("8");
		ShowAuthcode.viewauthcode(driver, domainName);					// view Domain Password
		System.out.print("9");
		ChangeOwner.changeonwer(driver,baseUrl,domainName);				// Change ownership
		System.out.print("10");
		Contactupdate.update(driver, baseUrl, domainName);				// contact update
		Contactupdate.advancededit(driver,domainName);					// contact update advanced edit
		System.out.print("11");

		Redelegate.delegate(driver);									// Redelegate
		System.out.print("12");
		ActivateDns.activatedns(driver, baseUrl, domainName);			// Activate DNS
		System.out.print("13");
		CancelDomain.cancel(driver);									// cancel domain
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("----------Manage Domain Nmae Test End----------");
		driver.quit();
	}
}
