package com.swisscom.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

 
/**
 * This is a utility class created to read the excel test data file before performing the test steps.
 * This class loads the excel file and
 * reads its column entries.
 *
 */
 
public class DataTableReader {
                public static HSSFSheet sheet;
                private Map<String, Integer> columns = new HashMap<String, Integer>();
                
              
                public void createDataTable(String ExcelSheetPath) throws IOException {
 
                	 // Initialize
                    try {
                    	 FileInputStream inputStream = new FileInputStream(new File(ExcelSheetPath));
                    	 HSSFWorkbook workbook =  new HSSFWorkbook(inputStream);
                    	 sheet = workbook.getSheet("LoginData");
                    	 workbook.close();
                    	
                    } catch (IOException e) {
                                    throw new IOException();
                    }
                }
               
 
                public static int RowCount() {
                                return   sheet.getLastRowNum()-sheet.getFirstRowNum();
                }
               
 
                public  Map<String, Integer> storeColumns() {
                        Row row = sheet.getRow(0);
                        for(int i=0;i<row.getLastCellNum();i++) {
                        	
                        	columns.put(row.getCell(i).getStringCellValue(), row.getCell(i).getColumnIndex());

                      
                    } 
                	
					return columns;
                }
                
 public  int getRowNumberToGetData(String env) {
                	
                	for (int i = 1; i <= RowCount(); i++) {

                        Row row = sheet.getRow(i);

                        for (int j = 0; j < row.getLastCellNum(); j++) {
                        	if(row.getCell(j).getStringCellValue().equalsIgnoreCase(env)) {	
                        		return i;
                        	}
                        }

                      
                	}
					return -1;
                }
public String getColumnValue(String columnName, int rowNo) {
	int colNo=columns.get(columnName);
	String cellvalue = sheet.getRow(rowNo).getCell(colNo).getStringCellValue();
	return cellvalue;
	
}
                
}
