package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.NewCustomerPage;
import utils.Drivefactory;

public class NewCustomerTest {

	WebDriver driver;
	LoginPage loginPage;
	NewCustomerPage addnewcus;

	@BeforeMethod
	public void setUp() {
		driver = Drivefactory.getDriver();
		driver.get("https://www.demo.guru99.com/V4/");
		loginPage = new LoginPage(driver);
		loginPage.login("mngr646782", "YmyhyhE");
		addnewcus = new NewCustomerPage(driver);
	}

	@Test
	public void NewCustomeraddition() {

		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		addnewcus.AddNewCustomer("Tester", 
				"28-05-1994",
				"ABCD", 
				"Ernakulam",
				"Kerala",
				"682029", 
				"9845682136",
				"tester1@examplemail.com", 
				"testertesttesting");

	}

	@AfterMethod
	public void tearDown() {
		Drivefactory.quitDriver();
	}

}
