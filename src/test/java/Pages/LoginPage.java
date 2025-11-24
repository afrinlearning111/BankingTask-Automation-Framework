package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;

    By username = By.name("uid");
    By password = By.name("password");
    By loginBtn = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // CASE 1 — SUCCESS LOGIN → Detect Welcome Marquee
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]")
            ));

            System.out.println("[PASS] Login successful for: " + user);

        } catch (Exception e) {

            // CASE 2 — FAILURE LOGIN → Detect the alert
            try {
                Alert alert = driver.switchTo().alert();
                String msg = alert.getText();
                alert.accept();

                System.out.println("[FAIL] Login failed for: " + user + " | Reason: " + msg);

                // Throw error → TestNG marks test as FAIL → Extent report FAIL
                throw new AssertionError("Invalid login for user: " + user + " | Message: " + msg);

            } catch (Exception alertNotFound) {
                // No alert → unknown failure
                throw new AssertionError("Login failed for " + user + " but no alert was shown.");
            }
        }
    }
}
