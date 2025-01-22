package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProvider {

	@DataProvider(name = "LoginData")
    public Object[][] getExcelDataForLogin() throws IOException {
        return getExcelData("Login");
    }
        
	//@DataProvider(name = "GraphData")
    //public Object[][] getExcelDataForGraph() throws IOException {
       // return getExcelData("python DS"); 
    //}
	 @DataProvider(name = "PythonData")
	    public Object[][] getExcelDataForDataStructures() throws IOException {
	        return getExcelData("python DS"); 
	    }
	
	@DataProvider(name = "ArrayData")
    public Object[][] getExcelDataForArray() throws IOException {
        return getExcelData("python PQ"); 
    }
        
        private Object[][] getExcelData(String sheetName) throws IOException {
	        String excelFilePath = "src/test/resources/Excel/TestData.xlsx";
	        //String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/Excel/TestData.xlsx";

        
        
        
        // Open the Excel file
        FileInputStream file = new FileInputStream(excelFilePath);

        // Load the workbook and sheet
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("python DS"); // Access the 'Login' sheet

        // Get the number of rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        // Prepare the data array
        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude the header row
        DataFormatter formatter = new DataFormatter(); // To handle different data formats

        // Loop through rows and columns to populate the data array
        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

        // Close workbook and file stream
        workbook.close();
        file.close();

        return data; // Return the data as a 2D array
    }
}
