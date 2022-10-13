package com.example.employeeservice.service;

import com.example.employeeservice.exception_handler.EmployeeNotFound;
import com.example.employeeservice.model.Employee;
import com.example.employeeservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeDao service;

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return service.getAllEmloyees();
    }

    @GetMapping("/employees/{emp_id}")
    public Employee getEmployeeById(@PathVariable int emp_id) { //employee id get from the url that why we put path variable
        Employee  employee =  service.getEmployeeById(emp_id);
        if(employee == null){
            throw new EmployeeNotFound("Employee not found!");
        }
        return employee;
    }

    @PostMapping("employees/add")
    public void addEmployee(@RequestBody Employee emp) { //employee data get from the body
        service.addEmployee(emp);
    }

}
