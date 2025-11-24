package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;
import utils.Drivefactory;
import utils.ExcelUtils;
import utils.BrowserFactory;

public class LoginTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriver driverInstance = new ChromeDriver();
        Drivefactory.setDriver(driverInstance);

        driverInstance.manage().window().maximize();
        driverInstance.get("https://www.demo.guru99.com/V4/");

        loginPage = new LoginPage(driverInstance);
    }


    @DataProvider(name = "loginData")
    public Object[][] getLoginData() throws Exception {
        String path = "src/test/resources/testdata/loginData.xlsx";
        return ExcelUtils.readExcelData(path, "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLoginFromExcel(String username, String password) {
        loginPage.login(username, password);
    }

    @AfterMethod
    public void tearDown() {
        Drivefactory.quitDriver();
    }
}
