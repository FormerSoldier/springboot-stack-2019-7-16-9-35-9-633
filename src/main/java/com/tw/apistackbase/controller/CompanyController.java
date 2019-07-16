package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.AssertFalse;
import java.util.List;
import java.util.ListIterator;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private List<Company> companies ;
    @GetMapping
    public List<Company> getAllCompanies(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer pageSize){
        companies = Company.createTestCompany();
        if(page != null && pageSize != null)
            return getCompaniesWithPageAndPageSize(page,pageSize);
        return Company.createTestCompany();
    }

    @GetMapping("/{index}")
    public Company getCompanyByIndex(@PathVariable int index){
        companies = Company.createTestCompany();
        return companies.get(index-1);
    }

    @GetMapping("/{companyIndex}/employees")
    public List<Employee> getEmployeesByCompanyIndex(@PathVariable int companyIndex){
        companies = Company.createTestCompany();
        return companies.get(companyIndex-1).getEmployees();
    }

    public List<Company> getCompaniesWithPageAndPageSize(@RequestParam int page, @RequestParam int pageSize){
        companies = Company.createTestCompany();
        return companies.subList((page - 1) * pageSize,page * pageSize);
    }

    @PostMapping
    public List<Company> addCompany(@RequestBody Company company){
        companies = Company.createTestCompany();
        companies.add(company);
        return companies;
    }

    @PutMapping("/{companyId}")
    public List<Company> updateCompany(@RequestBody Company company){
        companies = Company.createTestCompany();
        int realIndex = 0;
        for(int i = 0; i < companies.size(); i++){
            if(companies.get(i).getCompanyName().equals(company.getCompanyName()))
                realIndex = i;
        }
        companies.set(realIndex, company);
        return companies;
    }

    @DeleteMapping("/{companyIndex}")
    public List<Company> deleteCompanyByIndex(@PathVariable int companyIndex){
        companies = Company.createTestCompany();
        companies.remove(companyIndex-1);
        return companies;
    }
}
