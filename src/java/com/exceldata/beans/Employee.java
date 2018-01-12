/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exceldata.beans;

/**
 *
 * @author prashanta
 */
public class Employee {
    private int id;
    private String name;
    private String technology;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        //return "Employee{" + "id=" + id + ", name=" + name + ", technology=" + technology + '}';
        return String.format("%d - %s - %s",id,name,technology);
    }
    
    
}
