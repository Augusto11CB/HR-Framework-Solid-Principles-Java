# Open/Closed Principle
The “Open/Closed” principle states that software entities should be open for extension but closed for modification.

## Illustration

### Disrespecting the principle Open/Closed
The main TaxCalculator only perform the tax calculation for the full-time employees. There are other times of employees like interns and part-time employees.

In order to attend the needs of perform other tax calculation, if the code state as its in the "before" package, modifications in the TaxCalculator class are necessary and it does not respect what Open/closed principle say;
> entities should be open for extension but closed for modification. 

### Refactoring
To allow tax calculation for other employees, a TaxCalculator interface was created. For each employee, an EmployeeTypeTaxCalculator class will be created to implement the TaxCalculator interface. Thus, the specific way of calculating the tax for a given employee can be used.

