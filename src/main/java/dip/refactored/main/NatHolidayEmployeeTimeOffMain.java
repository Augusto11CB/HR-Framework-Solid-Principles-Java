package dip.refactored.main;

import dip.refactored.logging.ConsoleLogger;
import dip.refactored.persistence.EmployeeFileSerializer;
import dip.refactored.persistence.EmployeeRepositoryImpl;
import dip.refactored.personnel.Employee;
import dip.refactored.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

        // Request time off for each employee on
        // national holiday
        for (Employee employee : employees){
            employee.requestTimeOff(1, manager);
        }
    }
}
