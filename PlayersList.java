package com.java.sports;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
import  org.apache.poi.hssf.usermodel.HSSFCell;

public class PlayersList {

	public static void main(String[] args) {
		String filePath = "E:\\Custom\\Java\\Input\\Event Registration.csv";
		String line = "";
		String csvSplitBy = ",";
		TreeMap<String, List<String>> csvData = new TreeMap<String, List<String>>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			while ((line = br.readLine()) != null) {
				String[] content = line.split(csvSplitBy);
				csvData.put(content[1], Arrays.asList(content[3].split(";")));
			}
			System.out.println(csvData);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		createWorkbook(csvData);
	}
	
	private static void createWorkbook(TreeMap<String, List<String>> csvData)
	{
		try {
            String filename = "E:/Custom/Java/Output/NewExcelFile.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet singlesSheet = workbook.createSheet("Singles");
            HSSFSheet doublesSheet = workbook.createSheet("Doubles");
            HSSFSheet mixedDoublesSheet = workbook.createSheet("Mixed");
            HSSFRow row;
            short singlesCount = 0, doublesCount = 0, mixedDoublesCount = 0;
            
            for (Map.Entry<String, List<String>> entry : csvData.entrySet()) {
//            	System.out.println("" + entry.getKey().trim() + "=" + entry.getValue());
            	Iterator<String> itr = (entry.getValue()).iterator();
            	while (itr.hasNext()) {
            		String value = itr.next();
            		String name = entry.getKey().substring(1, entry.getKey().length()-1);
            		if (value.substring(1, 8).equals("Singles")) {
            			row = singlesSheet.createRow(singlesCount);
            			row.createCell(0).setCellValue(name);
            			singlesCount++;
            		} else if (value.substring(0, 7).equals("Doubles") || value.substring(1, 8).equals("Doubles")) {
            			row = doublesSheet.createRow(doublesCount);
            			row.createCell(0).setCellValue(name);
            			doublesCount++;
            		} else {
            			row = mixedDoublesSheet.createRow(mixedDoublesCount);
            			row.createCell(0).setCellValue(name);
            			mixedDoublesCount++;
            		}
            	}
            }

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");

        } catch ( Exception ex ) {
            System.out.println(ex);
        }
	}

}
