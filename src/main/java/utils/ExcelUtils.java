package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtils {

    public static Object[][] readExcelData(String filePath, String sheetName) throws Exception {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols]; // skip header

        for (int i = 1; i < rows; i++) { // start from row 1 (skip header)
            Row row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = row.getCell(j).toString();
            }
        }

        wb.close();
        fis.close();
        return data;
    }
}
