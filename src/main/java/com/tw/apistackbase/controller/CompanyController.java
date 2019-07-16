package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping
    public List<Company> getAllCompanies(){
        return Company.createTestCompany();
    }

    @GetMapping("/{index}")
    public Company getCompanyByIndex(@PathVariable int index){
        List<Company> companies = Company.createTestCompany();
        return companies.get(index-1);
    }

    @GetMapping("/{companyIndex}/employees")
    public List<Employee> getEmployeesByCompanyIndex(@PathVariable int companyIndex){
        List<Company> companies = Company.createTestCompany();
        return companies.get(companyIndex-1).getEmployees();
    }

}
