package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NewaccountPage;
import utils.Drivefactory;

public class NewaccountTest {

	WebDriver driver;
	LoginPage loginpage;
	NewaccountPage Newaccountpage;

	@BeforeMethod
	public void setup() {
		driver = Drivefactory.getDriver(); // initiate chromedriver
		driver.get("https://www.demo.guru99.com/V4/");
		loginpage = new LoginPage(driver);
	}

	@Test

	public void NewAccountCreation() {
		Newaccountpage.newaccount("1234","3000");
    {
    	
    }
	}

}
