package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String folderPath = System.getProperty("user.dir") + "/extent-reports/";
            String reportPath = folderPath + "Report_" + timestamp + ".html";

            // Create the folder if not exists
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(spark);
        }

        return extent;
    }
}
