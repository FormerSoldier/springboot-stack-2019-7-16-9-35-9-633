package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees;
    @GetMapping
    public List<Employee> getAllEmployees(@RequestParam(required = false) Integer page,
                                          @RequestParam(required =  false) Integer pageSize,
                                          @RequestParam(required = false) String gender){
        employees = Employee.createTestEmployee();
        if(page != null && pageSize != null)
            return getEmployeesWithLimitPageAndPageSize(page,pageSize);
        if(gender!= null && !gender.isEmpty())
            return getEmployeesByEqualsGender(gender);
        return employees;
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        employees = Employee.createTestEmployee();
        return employees.stream().filter(employee -> employee.getId() == employeeId).collect(Collectors.toList()).get(0);
    }
    @PostMapping
    public List<Employee> addEmployee(@RequestBody Employee employee){
        employees = Employee.createTestEmployee();
        employees.add(employee);
        return employees;
    }

    @PutMapping("/{index}")
    public List<Employee> updateEmployee(@PathVariable int index, @RequestBody Employee employee){
        employees = Employee.createTestEmployee();
        employees.set(index-1,employee);
        return employees;
    }

    @DeleteMapping("{index}")
    public List<Employee> deleteEmployeeByIndex(@PathVariable int index){
        employees = Employee.createTestEmployee();
        employees.remove(index-1);
        return employees;
    }
    public List<Employee> getEmployeesWithLimitPageAndPageSize(int page, int pageSize){
        employees = Employee.createTestEmployee();
        return employees.subList((page - 1) * pageSize, page * pageSize );
    }

    public List<Employee> getEmployeesByEqualsGender(@RequestParam String gender) {
        employees = Employee.createTestEmployee();
        return employees.stream().filter(employee -> employee.getGender().equals(gender)).collect(Collectors.toList());
    }


}
