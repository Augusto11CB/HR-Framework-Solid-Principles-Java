package dip.refactored.main;

import dip.refactored.documents.Payslip;
import dip.refactored.logging.ConsoleLogger;
import dip.refactored.persistence.EmployeeFileSerializer;
import dip.refactored.persistence.EmployeeRepositoryImpl;
import dip.refactored.personnel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepositoryImpl repository = new EmployeeRepositoryImpl(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees){
            Payslip payslip = new Payslip(employee , Month.AUGUST);

            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }
    }
}
