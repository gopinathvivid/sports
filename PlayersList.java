package com.statistics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
//import  org.apache.poi.hssf.usermodel.HSSFSheet;
//import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import  org.apache.poi.hssf.usermodel.HSSFRow;
//import  org.apache.poi.hssf.usermodel.HSSFCell;

public class PlayersList {

	public static void main(String[] args) {
		String filePath = "D:\\Java Workspace\\Event Registration.csv";
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
//		try {
//            String filename = "C:/NewExcelFile.xls" ;
//            HSSFWorkbook workbook = new HSSFWorkbook();
//            HSSFSheet sheet = workbook.createSheet("FirstSheet");  
//
//            HSSFRow rowhead = sheet.createRow((short)0);
//            rowhead.createCell(0).setCellValue("No.");
//            rowhead.createCell(1).setCellValue("Name");
//            rowhead.createCell(2).setCellValue("Address");
//            rowhead.createCell(3).setCellValue("Email");
//
//            HSSFRow row = sheet.createRow((short)1);
//            row.createCell(0).setCellValue("1");
//            row.createCell(1).setCellValue("Sankumarsingh");
//            row.createCell(2).setCellValue("India");
//            row.createCell(3).setCellValue("sankumarsingh@gmail.com");
//
//            FileOutputStream fileOut = new FileOutputStream(filename);
//            workbook.write(fileOut);
//            fileOut.close();
//            System.out.println("Your excel file has been generated!");
//
//        } catch ( Exception ex ) {
//            System.out.println(ex);
//        }
	}

}
