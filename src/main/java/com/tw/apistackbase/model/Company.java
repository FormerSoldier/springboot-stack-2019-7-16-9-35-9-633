package com.tw.apistackbase.model;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private int employeesNumber;
    private List<Employee> employees;

    public Company() {
    }

    public Company(String companyName, int employeesNumber) {
        this.companyName = companyName;
        this.employeesNumber = employeesNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(int employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public static List<Company> createTestCompany(){
        List<Company> companies = new ArrayList<>();
        companies.add(new Company("oocl",10000));
        companies.add(new Company("alibaba",200));
        companies.add(new Company("TW",600));

        for(int i = 0; i < companies.size(); i++)
            companies.get(i).setEmployees(createTestEmployeeFactoryByCompanyName(companies.get(i).getCompanyName()));
        return companies;
    }

    public static List<Employee> createTestEmployeeFactoryByCompanyName(String companyName){
        List<Employee> employees = new ArrayList<>();
        if(companyName.equals("oocl")){
            employees.add(new Employee(0,"XiaoHong",10,"female",10));
            employees.add(new Employee(1,"XiaoGao",12,"male",100));
            employees.add(new Employee(2,"XiaoLiu",14,"male",1000));
        }else if(companyName.equals("alibaba")){
            employees.add(new Employee(4,"alibaba1",20,"female",10));
            employees.add(new Employee(11,"tengxun2",19,"female",7000));
            employees.add(new Employee(6,"alibaba3",19,"male",8000));
        }else if(companyName.equals("TW")){
            employees.add(new Employee(4,"huage",30,"male",1002));
            employees.add(new Employee(4,"niuxin",25,"male",1003));
        }else{
            employees = null;
        }
        return employees;
    }


}
