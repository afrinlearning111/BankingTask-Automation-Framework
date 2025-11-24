package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reportmanager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            String reportPath = System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Automation Test Results");
            spark.config().setDocumentTitle("Extent Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "Banking Automation");
            extent.setSystemInfo("Tester", "Afrin");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}
