package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewaccountPage {
	WebDriver driver;
	By CustomerID = By.name("cusid");
	By InitialDeposit = By.name("inideposit");
	public void newaccount(String custmID, String Initialdeposit )
	{
		driver.findElement(CustomerID).sendKeys("custmID");
		driver.findElement(InitialDeposit).sendKeys("Initialdeposit");
	}

}
