package internship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private String name;
    private int employeeId;
    private double hourlyRate;
    private double hoursWorked;

    // Constructor
    public Employee(String name, int employeeId, double hourlyRate) {
        this.name = name;
        this.employeeId = employeeId;
        this.hourlyRate = hourlyRate;
    }

    // Getter and Setter methods

    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // Other methods (e.g., calculateSalary, generatePayslip, etc.)
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    public void generatePayslip() {
        System.out.println("Payslip for Employee " + employeeId + ":");
        System.out.println("Name: " + name);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Hourly Rate: $" + hourlyRate);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Add sample employees
        employees.add(new Employee("John Doe", 1, 15.0));
        employees.add(new Employee("Jane Smith", 2, 20.0));

        // Input hours worked for each employee
        for (Employee employee : employees) {
            System.out.print("Enter hours worked for " + employee.getName() + ": ");
            double hoursWorked = scanner.nextDouble();
            employee.setHoursWorked(hoursWorked);
        }

        // Process payroll and generate payslips
        for (Employee employee : employees) {
            employee.generatePayslip();
        }

        scanner.close();
    }
}
