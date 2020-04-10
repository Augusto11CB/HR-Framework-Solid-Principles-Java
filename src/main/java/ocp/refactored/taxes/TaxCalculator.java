package ocp.refactored.taxes;

import ocp.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
