package Dealership;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property extends Variables {
	public static Properties prop;
	public static Properties locators;
	public static void testProperty() throws IOException
	
	{
		FileInputStream inputP = new FileInputStream(System.getProperty("user.dir")+ 
				File.separator + "src" + 
				File.separator + "test" + 
				File.separator + "java" + 
				File.separator + "config.properties");
		prop = new Properties();
		prop.load(inputP);	
		
		FileInputStream inputL = new FileInputStream(System.getProperty("user.dir")+ 
				File.separator + "src" + 
				File.separator + "test" + 
				File.separator + "java" + 
				File.separator + "locators.properties");
		locators = new Properties();
		locators.load(inputL);	
		
		
		//Fetch the values from config.properties 
		browser = prop.getProperty("browser");
		url = prop.getProperty("url");
		username = prop.getProperty("username");
		password = prop.getProperty("password");
		firstname = prop.getProperty("firstname");
		lastname = prop.getProperty("lastname");
		companyname = prop.getProperty("companyname");
		vendorAccountNumber = prop.getProperty("vendorAccountNumber");
		
		
		
		//Fetch the values from locators.properties 
		addnew = locators.getProperty("addnew");
		customer = locators.getProperty("customer");
		smallheader = locators.getProperty("smallheader");
		accounttypedropdown = locators.getProperty("accounttypedropdown");
		accounttypevalue = locators.getProperty("accounttypevalue");
		country = locators.getProperty("country");
		countryname = locators.getProperty("countryname");
		state = locators.getProperty("state");
		statename = locators.getProperty("statename");
		create = locators.getProperty("create");
		verifyemail = locators.getProperty("verifyemail");
		vendor = locators.getProperty("vendor");
		shippingaddressflag = locators.getProperty("shippingaddressflag");
		save = locators.getProperty("save");
		vendorHeader = locators.getProperty("vendorHeader");
		purchaseTaxLevel = locators.getProperty("purchaseTaxLevel");
		vendorAccountTypeIcon = locators.getProperty("vendorAccountTypeIcon");
		
	 }
}
