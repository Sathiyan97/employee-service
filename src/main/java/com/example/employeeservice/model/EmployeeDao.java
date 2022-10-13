package com.example.employeeservice.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDao {
    static List<Employee> list = new ArrayList<>();

    static {
        list.add(new Employee(1234, "sathiyan", "sathiyan@gmail.com"));
        list.add(new Employee(1235, "Dilaxn", "dilaxn@gmail.com"));
        list.add(new Employee(1236, "Thinesh", "thinesh@gmail.com"));
    }

    public List<Employee> getAllEmloyees() {
        return list;

    }

    public Employee getEmployeeById(int emp_id) {
        return list.stream()
                .filter(emp -> emp.getEmployeeId() == emp_id)
                .findAny()
                .orElse(null);
    }

    public Employee addEmployee(Employee emp) {
        emp.setEmployeeId(123 + list.size() + 1);
        list.add(emp);
        return emp;
    }

    public Employee deleteEMployee(int empId) {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            Employee emp = iterator.next();
            if (empId == emp.getEmployeeId()) {
                iterator.remove();
                return emp;
            }
        }
        return null;
    }
}
