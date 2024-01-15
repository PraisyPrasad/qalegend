package org.qalegend.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.qalegend.constants.Constants;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelUtility {
    public static FileInputStream file;
    public static XSSFWorkbook wb;
    public static XSSFSheet sh;

    public static ArrayList<String> readData(String file_path, String sheet) {
        try {
            DataFormatter formatter = new DataFormatter();
            String path = Constants.HOME_DIRECTORY + file_path;
            file = new FileInputStream(path);
            wb = new XSSFWorkbook(file);
            sh = wb.getSheet(sheet);
            ArrayList<String> excelRows = new ArrayList<>();
            int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
            for (int i = 0; i <= rowCount; i++) {
                Row row = sh.getRow(i);
                int cellCount = row.getLastCellNum();
                for (int j = 0; j < cellCount; j++) {
                    excelRows.add(formatter.formatCellValue(row.getCell(j)));
                }
            }
            return excelRows;
        }
        catch (Exception ex)
        {
            throw new RuntimeException("Test data excel sheet not found");
        }
    }

}
