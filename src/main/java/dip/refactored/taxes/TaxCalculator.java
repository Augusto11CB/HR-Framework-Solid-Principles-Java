package dip.refactored.taxes;

import dip.refactored.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
