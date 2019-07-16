package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private List<Company> companies = Company.createTestCompany();
    @GetMapping
    public List<Company> getAllCompanies(){
        return Company.createTestCompany();
    }

    @GetMapping("/{index}")
    public Company getCompanyByIndex(@PathVariable int index){
        return companies.get(index-1);
    }

    @GetMapping("/{companyIndex}/employees")
    public List<Employee> getEmployeesByCompanyIndex(@PathVariable int companyIndex){
        return companies.get(companyIndex-1).getEmployees();
    }

    @GetMapping("/s")
    public List<Company> getCompaniesWithPageAndPageSize(@RequestParam int page, @RequestParam int pageSize){
        return companies.subList((page - 1) * pageSize,page * pageSize);
    }

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company){
        companies.add(company);
        return companies;
    }
}
