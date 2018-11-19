package co.edureka.assignment.employeeservice.controller;

import co.edureka.assignment.employeeservice.service.EmployeeService;
import co.edureka.assignment.employeeservice.data.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<Collection<Employee>> getEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

}
