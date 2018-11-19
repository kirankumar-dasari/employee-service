package co.edureka.assignment.employeeservice.service;

import co.edureka.assignment.employeeservice.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EmployeeService {

    @Autowired
    private Collection<?> employees;

    @Bean
    private Collection<Employee> employees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "emp1", "designation1", 100000));
        employees.add(new Employee(1, "emp2", "designation1", 20000));
        employees.add(new Employee(1, "emp3", "designation2", 30000));
        employees.add(new Employee(1, "emp4", "designation3", 40000));
        return employees;
    }

    public Collection<Employee> findAll() {
        return employees();
    }
}
