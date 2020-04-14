package dip.before.taxes;

import dip.before.personnel.Employee;

public interface TaxCalculator {
    double calculate(Employee employee);
}
