package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees = Employee.createTestEmployee();
    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(required = false) Integer page,
                                          @RequestParam(required =  false) Integer pageSize){
        if(page != null && pageSize != null)
            return getEmployeesWithLimitPageAndPageSize(page,pageSize);
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        return employees.stream().filter(employee -> employee.getId() == employeeId).collect(Collectors.toList()).get(0);
    }
    public List<Employee> getEmployeesWithLimitPageAndPageSize(int page, int pageSize){
        return employees.subList((page - 1) * pageSize, page * pageSize );
    }
}
