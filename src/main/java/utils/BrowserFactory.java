package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    public static WebDriver createInstance(String browser) {

        WebDriver driver = null;

        switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
            	System.setProperty("webdriver.edge.driver", "\"C:\\Users\\afrin\\eclipse-workspace\\msedgedriver.exe\"");
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
