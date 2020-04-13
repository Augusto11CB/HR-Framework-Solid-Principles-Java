package lsp.before.main;



import lsp.before.logging.ConsoleLogger;
import lsp.before.persistence.EmployeeFileSerializer;
import lsp.before.persistence.EmployeeRepository;
import lsp.before.personnel.Employee;
import lsp.before.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {

    //    [aug-lsp]
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);


        // Request time off for each employee on
        // national holiday
        for (Employee employee : employees){
            //    [aug-lsp] it throws exception, because some contractors does not implement requestTimeOff
            employee.requestTimeOff(1, manager);
        }
    }
}
