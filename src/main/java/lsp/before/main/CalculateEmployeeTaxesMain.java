package lsp.before.main;



import lsp.before.logging.ConsoleLogger;
import lsp.before.persistence.EmployeeFileSerializer;
import lsp.before.persistence.EmployeeRepository;
import lsp.before.personnel.Employee;
import lsp.before.taxes.TaxCalculator;
import lsp.before.taxes.TaxCalculatorFactory;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class CalculateEmployeeTaxesMain {

    //    [aug-lsp]
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        // Calculate taxes
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

        double totalTaxes = 0;
        for (Employee employee: employees){
            //    [aug-lsp] Here an exception will no longer be thrown because for SubContractor is a subtype of employee
            // Subcontractors should calqculate their own taxes, so we cannot implement a TaxCalculator for them.
            TaxCalculator taxCalculator = TaxCalculatorFactory.create(employee);

            // compute individual tax
            double tax = taxCalculator.calculate(employee);
            String formattedTax = currencyFormatter.format(tax);
            consoleLogger.writeInfo(employee.getFullName() + " taxes: " + formattedTax);

            // add to company total taxes
            totalTaxes += taxCalculator.calculate(employee);
        }
        consoleLogger.writeInfo("Total taxes = " + currencyFormatter.format(totalTaxes));
    }
}
