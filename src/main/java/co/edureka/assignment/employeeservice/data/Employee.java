package co.edureka.assignment.employeeservice.data;

import lombok.Data;

@Data
public class Employee {
    private long id;
    private String name;
    private String designation;
    private double salary;

    public Employee(long id, String name, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
}
