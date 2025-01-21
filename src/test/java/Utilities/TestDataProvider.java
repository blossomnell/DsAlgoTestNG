//package Utilities;
//
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.testng.annotations.DataProvider;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class TestDataProvider {
//
//    @DataProvider(name = "LoginData")
//    public Object[][] getLoginData() throws IOException {
//        // Path to your Excel file
//        String excelFilePath = "src/test/resources/Excel/TestData.xlsx"; 
//
//        // Open the Excel file
//        FileInputStream file = new FileInputStream(excelFilePath);
//
//        // Load the workbook and sheet
//        XSSFWorkbook workbook = new XSSFWorkbook(file);
//        XSSFSheet sheet = workbook.getSheet("Login"); // Access the 'Login' sheet
//
//        // Get the number of rows and columns
//        int rowCount = sheet.getPhysicalNumberOfRows();
//        int colCount = sheet.getRow(0).getLastCellNum();
//
//        // Prepare the data array
//        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude the header row
//        DataFormatter formatter = new DataFormatter(); // To handle different data formats
//
//        // Loop through rows and columns to populate the data array
//        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
//            for (int j = 0; j < colCount; j++) {
//                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
//            }
//        }
//
//        // Close workbook and file stream
//        workbook.close();
//        file.close();
//
//        return data; // Return the data as a 2D array
//    }
//}




package Utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class TestDataProvider {
	 


    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        return getExcelData("Login");
    }

    @DataProvider(name = "PythonData")
    public Object[][] getExcelDataForDataStructures() throws IOException {
        return getExcelData("python DS"); 
    }
   
	    @DataProvider(name = "RegisterData")
	    public Object[][] getExcelDataForRegister() throws IOException {
	        return getExcelData("Register"); 
	    }
	    
	    @DataProvider(name = "LinkedListData")
	    public Object[][] getExcelDataForLinkedList() throws IOException {
	        return getExcelData("LinkedList"); 
	    }
	    
	    
	    private Object[][] getExcelData(String sheetName) throws IOException {
	        String excelFilePath = "src/test/resources/Excel/TestData.xlsx";
	        //String excelFilePath = System.getProperty("user.dir") + "/src/test/resources/Excel/TestData.xlsx";



	        FileInputStream file = new FileInputStream(excelFilePath);


	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName); // Access the specified sheet

	        int rowCount = sheet.getPhysicalNumberOfRows();
	        int colCount = sheet.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rowCount - 1][colCount]; // Exclude the header row
	        DataFormatter formatter = new DataFormatter(); // To handle different data formats

	        for (int i = 1; i < rowCount; i++) { // Start from 1 to skip the header row
	            for (int j = 0; j < colCount; j++) {
	                data[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
	            }
	        }

	        workbook.close();
	        file.close();

	        return data; // Return the data as a 2D array
	    }
	}
		


