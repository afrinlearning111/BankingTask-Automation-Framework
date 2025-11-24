package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {

	WebDriver driver;
	By CustomerName = By.name("name");
	By Gender = By.xpath("//input[@value='f']");
	By DOB = By.name("dob");
	By Address = By.name("addr");
	By City = By.name("city");
	By State = By.name("state");
	By Pin = By.name("pinno");
	By Mobile = By.name("telephoneno");
	By Email = By.name("emailid");
	By Password = By.name("password");
	By SubmitButton = By.name("sub");

	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void AddNewCustomer(String Cusname, String dob, String address, String city, String state, String pin,
			String mobileno, String email, String pass) {
		driver.findElement(CustomerName).sendKeys(Cusname);
		driver.findElement(Gender).click();
		driver.findElement(DOB).sendKeys(dob);
		driver.findElement(Address).sendKeys(address);
		driver.findElement(City).sendKeys(city);
		driver.findElement(State).sendKeys(state);
		driver.findElement(Pin).sendKeys(pin);
		driver.findElement(Mobile).sendKeys(mobileno);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(SubmitButton).click();

	}
}
