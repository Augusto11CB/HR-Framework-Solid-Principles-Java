package ocp.refactored.taxes;

import ocp.refactored.personnel.Employee;
import ocp.refactored.personnel.FullTimeEmployee;
import ocp.refactored.personnel.Intern;
import ocp.refactored.personnel.PartTimeEmployee;


//Goal: serves concrete instances of tax calculator based on the employee type

public class TaxCalculatorFactory {
    public static TaxCalculator create(Employee employee) {
        if (employee instanceof FullTimeEmployee) {
            return new FullTimeTaxCalculator();
        }

        if (employee instanceof PartTimeEmployee) {
            return new PartTimeTaxCalculator();
        }

        if (employee instanceof Intern) {
            return new InternTaxCalculator();
        }

        throw new RuntimeException("Invalid employee type");
    }
}
