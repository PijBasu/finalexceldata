package com.exceldata.util;

import com.exceldata.beans.Employee;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private Object getCellValue(Cell cell) {

        switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                return cell.getStringCellValue();

            case Cell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue();

            case Cell.CELL_TYPE_NUMERIC:
                return cell.getNumericCellValue();
        }
        return null;
    }// End of getCellValue()

    private boolean alreadyExist(List<Employee> listEmployee, Employee emp2) {
        boolean flag = false;
        for (Employee emp1 : listEmployee) {
            if ((emp1.getId() == emp2.getId()) && ((emp1.getName().trim()).equalsIgnoreCase(emp2.getName().trim())) && ((emp1.getTechnology().trim()).equalsIgnoreCase(emp2.getTechnology().trim()))) {
                flag = true;
            }
        }
        return false;
    }// End of alreadyExist()

    public List<Employee> readEmployeesFromExcelFile(String excelFilePath) {

        List<Employee> listEmployee = new ArrayList<>();
        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            inputStream = new FileInputStream(new File(excelFilePath));
            workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = firstSheet.iterator();

            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                Employee emp = new Employee();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 5:
                            Double d = (Double) getCellValue(nextCell);
                            emp.setId(d.intValue());
                            break;
                        case 6:
                            emp.setName((String) getCellValue(nextCell));
                            break;
                        case 7:
                            emp.setTechnology((String) getCellValue(nextCell));
                            break;
                    }
                }
                if (listEmployee.isEmpty()) {
                    listEmployee.add(emp);
                } else {
                    if (!alreadyExist(listEmployee, emp)) {
                        listEmployee.add(emp);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return listEmployee;
    }// End of readEmployeesFromExcelFile()

//    public Set<Employee> readEmployeesFromExcelFile(String excelFilePath) {
//
//        Set<Employee> listEmployee = new LinkedHashSet<>();
//        Workbook workbook = null;
//        FileInputStream inputStream = null;
//        
//        try {
//            inputStream = new FileInputStream(new File(excelFilePath));
//            workbook = new XSSFWorkbook(inputStream);
//            Sheet firstSheet = workbook.getSheetAt(0);
//            Iterator<Row> iterator = firstSheet.iterator();
//
//            while (iterator.hasNext()) {
//                Row nextRow = iterator.next();
//                Iterator<Cell> cellIterator = nextRow.cellIterator();
//                Employee emp = new Employee();
//
//                while (cellIterator.hasNext()) {
//                    Cell nextCell = cellIterator.next();
//                    int columnIndex = nextCell.getColumnIndex();
//
//                    switch (columnIndex) {
//                        case 5:
//                            Double d = (Double)getCellValue(nextCell);
//                            emp.setId(d.intValue());
//                            break;
//                        case 6:
//                            emp.setName((String) getCellValue(nextCell));
//                            break;
//                        case 7:
//                            emp.setTechnology((String) getCellValue(nextCell));
//                            break;
//                    }
//
//                }
//                listEmployee.add(emp);
//            }            
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
//        } finally{
//            try {
//                inputStream.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ExcelReader.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        
//        return listEmployee;
//    }// End of readEmployeesFromExcelFile()
}// End of class
