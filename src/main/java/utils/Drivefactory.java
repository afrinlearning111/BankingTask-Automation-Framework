package utils;

import org.openqa.selenium.WebDriver;

public class Drivefactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}



























//package utils;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//
//public class Drivefactory {
//	private static WebDriver driver;
//
//	public static WebDriver getDriver() {
//		if (driver == null) {
//			System.setProperty("webdriver.chrome.driver",
//				    "C:\\Users\\afrin\\eclipse-workspace\\chromedriver-win64\\chromedriver.exe");
//			 ChromeOptions options = new ChromeOptions();
//	            options.addArguments("--incognito");     // 🚀 Enable incognito mode
//	            options.addArguments("--start-maximized");
//
//	            driver = new ChromeDriver(options);
//		}
//		return driver;
//	}
//
//	public static void quitDriver() {
//		if (driver != null) {
//			driver.quit();
//			driver = null;
//		}
//	}
//}
