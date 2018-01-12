package com.exceldata.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SingleClassExcelReaderExample {

    public static void main(String[] args) {
        FileInputStream inputStream = null;
        Workbook workbook = null;
        String excelFilePath = "C:\\Users\\prashanta\\Desktop\\emp.xlsx";
        try {
            inputStream = new FileInputStream(new File(excelFilePath));
            workbook = new XSSFWorkbook(inputStream);
            int totalSheet = workbook.getNumberOfSheets();
            System.out.println("totalSheet : " + totalSheet);
            
            for (int i = 0; i < totalSheet; i++) {
                System.out.println("Sheet "+(i+1)+" :: ");
                Sheet nSheet = workbook.getSheetAt(i);// getSheetAt(0): sheet 1, getSheetAt(1): sheet 2
                Iterator<Row> iterator = nSheet.iterator();
                while (iterator.hasNext()) { // Iterate row
                    Row nextRow = iterator.next();
                    Iterator<Cell> cellIterator = nextRow.cellIterator();

                    while (cellIterator.hasNext()) {// Iterate cell
                        Cell cell = cellIterator.next();

                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                System.out.print(cell.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                System.out.print(cell.getBooleanCellValue());
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                System.out.print(cell.getNumericCellValue());
                                break;
                        }
                        System.out.print(" - ");
                    }
                    System.out.println("\b\b\b");
                }
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(SingleClassExcelReaderExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SingleClassExcelReaderExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(SingleClassExcelReaderExample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
