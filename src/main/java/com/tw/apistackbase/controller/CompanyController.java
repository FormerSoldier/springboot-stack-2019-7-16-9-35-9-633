package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
