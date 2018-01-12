/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exceldata.app;

import com.exceldata.beans.Employee;
import com.exceldata.util.ExcelReader;
import java.util.List;

/**
 *
 * @author prashanta
 */
public class EmployeeApp {
    
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\prashanta\\Desktop\\emp.xlsx";
        ExcelReader er = new ExcelReader();
        List<Employee> list = er.readEmployeesFromExcelFile(excelFilePath);
        System.out.println(list);
        list.forEach((e) -> {
            System.out.println(e.toString());
        });
    }
}
