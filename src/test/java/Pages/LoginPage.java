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

        // 1️⃣ SUCCESS CASE → Manager Page Loaded
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//marquee[contains(text(),\"Welcome To Manager\")]")
            ));
            System.out.println("[PASS] Login successful for: " + user);
            return;
        } catch (Exception ignore) {}

        // 2️⃣ FAILURE CASE → Alert Present
        try {
            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();
            alert.accept();

            System.out.println("[FAIL] Login failed for: " + user + " | Reason: " + msg);

            throw new AssertionError(
                    "Invalid login for user: " + user + " | Message: " + msg
            );

        } catch (Exception ignore) {}

        // 3️⃣ FAILURE CASE → Error message displayed on page (No alert)
        try {
            String errorMsg = driver.findElement(
                    By.xpath("//td[@class='heading3' or @class='heading3']/span")
            ).getText();

            System.out.println("[FAIL] Login failed for " + user + " | Page Message: " + errorMsg);

            throw new AssertionError(
                    "Invalid login for user: " + user + " | Page Message: " + errorMsg
            );

        } catch (Exception ignore) {}

        // 4️⃣ UNKNOWN FAILURE → Nothing was detectable
        throw new AssertionError(
                "Login failed for " + user + " but no alert or page message appeared."
        );
    }
}
