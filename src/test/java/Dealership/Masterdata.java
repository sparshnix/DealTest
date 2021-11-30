package Dealership;

/**
 * BlackPurl Automation
 * Creation date 17-nov-2021
 * By Sparsh Shrivastava
 */

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.*;
import org.testng.Reporter;

@Listeners(Dealership.Listeners.class)

public class Masterdata extends POM {
	public static String timestamp = new SimpleDateFormat("-dd_MM_yyyyhh_mm_ss").format(new Date());
	public static String phonenumber = new SimpleDateFormat("MMyyyymmss").format(new Date());
	
	private static Logger log = LogManager.getLogger(POM.class.getName());

	
	@SuppressWarnings("deprecation")
	
	@Test
	public static void AddCustomer() throws Exception
	{
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Customer = driver.findElement(By.xpath(customer));
		Assert.assertTrue(Customer.isDisplayed(), "Button is missing");
		log.info("Customer button is displayed");
		Customer.click();
		Assert.assertTrue(Customer.isEnabled(), "Button is not clicked");
		log.info("Customer button is clicked");
		
        Thread.sleep(5000);
		
		WebElement Smallheader = driver.findElement(By.xpath(smallheader));
		Assert.assertTrue(Smallheader.isDisplayed(), "Button is missing");
		String Smallheadertext = Smallheader.getText();
		System.out.println(Smallheadertext);
		Assert.assertEquals(Smallheadertext, "CREATE NEW CUSTOMER");
		log.info("Customer creation window is opened");
		
		WebElement Firstname = driver.findElement(By.id("new-customer-first-name"));
		Assert.assertTrue(Firstname.isDisplayed(), "Firstname field is missing");
		log.info("Firstname field is visible");
		Firstname.sendKeys(firstname + timestamp);
		log.info("Firstname  is filled");
		
		WebElement Lastname = driver.findElement(By.id("new-customer-last-name"));
		Assert.assertTrue(Lastname.isDisplayed(), "Lastname field is missing");
		log.info("Lastname field is visible");
		Lastname.sendKeys(lastname);
		log.info("Lastname  is filled");
		
		WebElement Accounttypedropdown = driver.findElement(By.xpath(accounttypedropdown));
		Assert.assertTrue(Accounttypedropdown.isDisplayed(), "Account type field is missing");
		log.info("Account type field is visible");
		Accounttypedropdown.click();
		log.info("Account type  is clicked");
		WebElement Accounttypevalue = driver.findElement(By.xpath(accounttypevalue));
		Assert.assertTrue(Accounttypevalue.isDisplayed(), "Account type value is missing");
		Accounttypevalue.click();
		log.info("Account type  is selected");
		
		
		WebElement Email = driver.findElement(By.id("customer-email"));
		Assert.assertTrue(Email.isDisplayed(), "Email field is missing");
		log.info("Email field is visible");
		String email = firstname + timestamp + "@test.com";
		Email.sendKeys(email);
		log.info("Email  is filled");
		
		WebElement Mobilenumber = driver.findElement(By.id("customer-mobile-number"));
		Assert.assertTrue(Mobilenumber.isDisplayed(), "Mobilenumber field is missing");
		log.info("Mobilenumber field is visible");
		Mobilenumber.sendKeys(phonenumber);
		log.info("Mobilenumber  is filled");
		
		
		WebElement Address = driver.findElement(By.id("customer-Address"));
		Assert.assertTrue(Address.isDisplayed(), "Address field is missing");
		WebElement Address2 = driver.findElement(By.id("customer-Address2"));
		Assert.assertTrue(Address2.isDisplayed(), "Address field is missing");
		log.info("Address field is visible");
		Address.sendKeys("Sample text");
		Address2.sendKeys("Sample text");
		log.info("Address  is filled");
		
		WebElement Country = driver.findElement(By.xpath(country));
		Assert.assertTrue(Country.isDisplayed(), "Country field is missing");
		log.info("Country field is visible");
		Country.click();
		log.info("Country is clicked");
		WebElement CountryName = driver.findElement(By.xpath(countryname));
		Assert.assertTrue(CountryName.isDisplayed(), "Country Name value is missing");
		CountryName.click();
		log.info("Country Name is selected");
		
		WebElement City = driver.findElement(By.id("customer-City"));
		Assert.assertTrue(City.isDisplayed(), "City Name value is missing");
		City.sendKeys("Sydney");
		log.info("City Name is selected");
		
//		WebElement State = driver.findElement(By.xpath(state));
//		Assert.assertTrue(State.isDisplayed(), "State field is missing");
//		log.info("State field is visible");
//		State.click();
//		log.info("State is clicked");	
//		WebElement Statename = driver.findElement(By.xpath(statename));
//		Assert.assertTrue(Statename.isDisplayed(), "State Name value is missing");
//		Statename.click();
//		log.info("State Name is selected");
		
		
		WebElement PostCode = driver.findElement(By.id("customer-Postcode"));
		Assert.assertTrue(PostCode.isDisplayed(), "Postcode value is missing");
		PostCode.sendKeys("001234");
		log.info("Postcode is selected");
		
		WebElement Create = driver.findElement(By.xpath(create));
		Assert.assertTrue(Create.isDisplayed(), "Create button is missing");
		Create.click();
		log.info("Create button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(email);
		log.info("email is entered in seachbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.getText();
		log.info("the text is " + Verifyemail.getText());
		Assert.assertEquals(email,Verifyemail.getText(), "User not found");
		log.info("User is successfully created");	
		
	}
	
	
	@Test
	public static void AddVendor() throws InterruptedException
	
	{
		WebElement Addnew = driver.findElement(By.xpath(addnew));
		Assert.assertTrue(Addnew.isDisplayed(), "Button is missing");
		log.info("Addnew button is displayed");
		Addnew.click();
		Assert.assertTrue(Addnew.isEnabled(), "Button is not clicked");
		log.info("Addnew button is clicked");
		
		WebElement Customer = driver.findElement(By.xpath(vendor));
		Assert.assertTrue(Customer.isDisplayed(), "Button is missing");
		log.info("Vendor button is displayed");
		Customer.click();
		Assert.assertTrue(Customer.isEnabled(), "Button is not clicked");
		log.info("Vendor button is clicked");
        Thread.sleep(10000);
		
        WebElement VendorHeader = driver.findElement(By.xpath(vendorHeader));
		Assert.assertTrue(VendorHeader.isDisplayed(), "Button is missing");
		String VendorHeadertext = VendorHeader.getText();
		System.out.println(VendorHeadertext);
		Assert.assertEquals(VendorHeadertext, "New Vendor");
		log.info("Vendor creation window is opened");
      //*[@id="newVendor"]/div[2]/div/div/div[1]/div[4]/div[1]/h1[2]
        
        
        WebElement Vendorname = driver.findElement(By.id("vendorName"));
        Assert.assertTrue(Vendorname.isDisplayed(), "Vendor name field is missing");
        Vendorname.sendKeys(companyname + timestamp);
        log.info("Company name is entered");
        Thread.sleep(1000);
        
        WebElement VendorAccountNumber = driver.findElement(By.id("vendorAccountNumber"));
        Assert.assertTrue(VendorAccountNumber.isDisplayed(), "Vendor Account Number field is missing");
        VendorAccountNumber.sendKeys(vendorAccountNumber);
        log.info("Vendor Account Number is entered");
        
        WebElement WorkEmail = driver.findElement(By.id("workEmail"));
        Assert.assertTrue(WorkEmail.isDisplayed(), "Email field is missing");
        String workEmail = companyname + timestamp + "@gmail.com";
        WorkEmail.sendKeys(workEmail);
        log.info("Work Email is entered");
        
        WebElement WorkPhone = driver.findElement(By.id("workPhone"));
        Assert.assertTrue(WorkPhone.isDisplayed(), "Phone number is missing");
        log.info("Phone number field is visible");
        WorkPhone.sendKeys(phonenumber);
		log.info("Phone number  is filled");
		
		WebElement Billingaddress1 = driver.findElement(By.id("billingAddress1"));
		Assert.assertTrue(Billingaddress1.isDisplayed(), "Billing address1 field is missing");
		WebElement Billingaddress2 = driver.findElement(By.id("billingAddress2"));
		Assert.assertTrue(Billingaddress2.isDisplayed(), "Billing address2 field is missing");
		log.info("Billingaddress field is visible");
		Billingaddress1.sendKeys("Sample text");
		Billingaddress2.sendKeys("Sample text");
		log.info("Billingaddress  is filled");
		
		WebElement BillingCity = driver.findElement(By.id("billingCity"));
		Assert.assertTrue(BillingCity.isDisplayed(), "City field is missing");
		BillingCity.sendKeys("Sydney");
		log.info("City Name is selected");
		
		WebElement BillingState = driver.findElement(By.id("billingState"));
		Assert.assertTrue(BillingState.isDisplayed(), "Billing State value is missing");
		Select select1 = new Select(BillingState);
		select1.selectByIndex(1);
		log.info("Billing State is selected");
		
		
		WebElement BillingCountry = driver.findElement(By.id("billingCountry"));
		Assert.assertTrue(BillingCountry.isDisplayed(), "Billing Country value is missing");
		Select select2 = new Select(BillingCountry);
		select2.selectByIndex(1);
		log.info("Billing Country is selected");
		
		WebElement PostCode = driver.findElement(By.id("exampleInputEmail1"));
		Assert.assertTrue(PostCode.isDisplayed(), "Postcode value is missing");
		PostCode.sendKeys("001234");
		log.info("Postcode is selected");
		
		WebElement Shippingaddressflag = driver.findElement(By.xpath(shippingaddressflag));
		Assert.assertTrue(Shippingaddressflag.isDisplayed(), "Shippingaddressflag checkbox is missing");
		Shippingaddressflag.click();
		log.info("Shippingaddressflag is same as billing address");
		
//		WebElement  Part_Purchases = driver.findElement(By.xpath(part_Purchases));
//		Assert.assertTrue(Part_Purchases.isDisplayed(), "Part_Purchases checkbox is missing");
//		Part_Purchases.click();
//		
//		WebElement	Merchandise_Purchases = driver.findElement(By.xpath(merchandise_Purchases));
//		Assert.assertTrue(Merchandise_Purchases.isDisplayed(), "Merchandise_Purchases checkbox is missing");
//		Merchandise_Purchases.click();
//		
//		WebElement	Unit_Purchases = driver.findElement(By.xpath(unit_Purchases));
//		Assert.assertTrue(Unit_Purchases.isDisplayed(), "Unit_Purchases checkbox is missing");
//		Unit_Purchases.click();
//		
//		WebElement	Sublet_Purchases = driver.findElement(By.xpath(sublet_Purchases));
//		Assert.assertTrue(Sublet_Purchases.isDisplayed(), "Sublet_Purchases checkbox is missing");
//		Sublet_Purchases.click();
//		
//		WebElement	Claims_for_Service_Work = driver.findElement(By.xpath(claims_for_Service_Work));
//		Assert.assertTrue(Claims_for_Service_Work.isDisplayed(), "Claims_for_Service_Work checkbox is missing");
//		Claims_for_Service_Work.click();
//		
//		WebElement	Deal_Products = driver.findElement(By.xpath(deal_Products));
//		Assert.assertTrue(Deal_Products.isDisplayed(), "Deal_Products checkbox is missing");
//		Deal_Products.click();
//		
//		WebElement	Flooring_Company = driver.findElement(By.xpath(flooring_Company));
//		Assert.assertTrue(Flooring_Company.isDisplayed(), "Flooring_Company checkbox is missing");
//		Flooring_Company.click();
//		
//		WebElement	Finance_Company = driver.findElement(By.xpath(finance_Company));
//		Assert.assertTrue(Finance_Company.isDisplayed(), "Finance_Company checkbox is missing");
//		Finance_Company.click();
//		
//		WebElement	Financing_Products = driver.findElement(By.xpath(financing_Products));
//		Assert.assertTrue(Financing_Products.isDisplayed(), "Financing_Products checkbox is missing");
//		Financing_Products.click();
		
		WebElement PurchaseTaxLevel = driver.findElement(By.xpath(purchaseTaxLevel));
		Assert.assertTrue(PurchaseTaxLevel.isDisplayed(), "PurchaseTaxLevel value is missing");
		Select select3 = new Select(PurchaseTaxLevel);
		select3.selectByIndex(1);
		log.info("PurchaseTaxLevel is selected");
		
		WebElement VendorAccountTypeIcon = driver.findElement(By.xpath(vendorAccountTypeIcon));
		Assert.assertTrue(VendorAccountTypeIcon.isDisplayed(), "VendorAccountTypeIcon value is missing");
		Select select4 = new Select(VendorAccountTypeIcon);
		select4.selectByIndex(1);
		log.info("VendorAccountTypeIcon is selected");
		
		
		
		WebElement Save = driver.findElement(By.xpath(save));
		Assert.assertTrue(Save.isDisplayed(), "Save button is missing");
		Save.click();
		log.info("Save button is clicked");
		Thread.sleep(10000);
		
		WebElement Searchbox = driver.findElement(By.id("globalSearchStrInput"));
		Assert.assertTrue(Searchbox.isDisplayed(), "Searchbox is missing");
		Searchbox.sendKeys(workEmail);
		log.info("email is entered in searchbox");
		Thread.sleep(10000);
		
		WebElement Verifyemail = driver.findElement(By.xpath(verifyemail));
		Assert.assertTrue(Verifyemail.isDisplayed(), "No relevent data appeared");
		Verifyemail.getText();
		log.info("the text is " + Verifyemail.getText());
		Assert.assertEquals(workEmail,Verifyemail.getText(), "User not found");
		log.info("User is successfully created");
	}
	
//	@Test
//	public static void Test2() throws IOException, InterruptedException
//	{
//			 
//		
//		
//	    Assert.assertEquals("sdas1234567", "1234");
//	    
//	    
//	}
	
}
