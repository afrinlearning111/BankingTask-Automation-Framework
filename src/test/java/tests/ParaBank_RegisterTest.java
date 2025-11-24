package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import Pages.ParaBank_RegisterPage;
import utils.BrowserFactory;
import utils.Drivefactory;

@Listeners(utils.TestListener.class)
public class ParaBank_RegisterTest {

    ParaBank_RegisterPage register;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {

        // Create browser instance (Chrome / Edge / Firefox)
        WebDriver driver = BrowserFactory.createInstance(browser);

        // Set to ThreadLocal
        Drivefactory.setDriver(driver);

        // Navigate to URL
        Drivefactory.getDriver().get("https://parabank.parasoft.com/");

        // Initialize page object
        register = new ParaBank_RegisterPage(Drivefactory.getDriver());
    }

    @Test
    public void NewRegister() {

        Drivefactory.getDriver().findElement(By.xpath("//a[text()='Register']")).click();

        register.RegisterNewCustomer(
                "Testerrr",
                "Testerrrw",
                "ABCD",
                "XYZ",
                "Kerala",
                "685212",
                "9854658567",
                "789456587",
                "tester13567",
                "testertest",
                "testertest"
        );
    }

    @AfterMethod
    public void tearDown() {
        Drivefactory.quitDriver();
    }
}
