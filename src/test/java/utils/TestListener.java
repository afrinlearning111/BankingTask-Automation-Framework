package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testng.*;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import com.aventstack.extentreports.*;
//import com.aventstack.extentreports.markuputils.*;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("Test Failed");
        test.get().fail(result.getThrowable());

        WebDriver driver = Drivefactory.getDriver();
        String screenshotPath = takeScreenshot(driver, result.getMethod().getMethodName());
        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String takeScreenshot(WebDriver driver, String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "/extent-reports/screenshots/" + testName + ".png";
        File dest = new File(path);

        try {
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🔥 Extent Listener Started");
    }
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
