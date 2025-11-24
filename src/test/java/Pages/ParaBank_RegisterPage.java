package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParaBank_RegisterPage {

	WebDriver driver;
	By FirstName = By.name("customer.firstName");
	By LastName = By.name("customer.lastName");
	By Address = By.name("customer.address.street");
	By City = By.name("customer.address.city");
	By State = By.name("customer.address.state");
	By ZipCode = By.name("customer.address.zipCode");
	By Phone = By.name("customer.phoneNumber");
	By SSN = By.name("customer.ssn");
	By Username = By.name("customer.username");
	By Password = By.name("customer.password");
	By ConfirmPassword = By.name("repeatedPassword");
	By RegisterButton = By.xpath("//input[@value='Register']");

	public ParaBank_RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public void RegisterNewCustomer(String fname, String lname, String address, String city, String state, String zip,
			String mobileno, String ssn, String uname, String pass, String Confpass) {
		driver.findElement(FirstName).sendKeys(fname);
		driver.findElement(LastName).sendKeys(lname);
		driver.findElement(Address).sendKeys(address);
		driver.findElement(City).sendKeys(city);
		driver.findElement(State).sendKeys(state);
		driver.findElement(ZipCode).sendKeys(zip);
		driver.findElement(Phone).sendKeys(mobileno);
		driver.findElement(SSN).sendKeys(ssn);
		driver.findElement(Username).sendKeys(uname);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(ConfirmPassword).sendKeys(Confpass);
		driver.findElement(RegisterButton).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']")));


	}
}
