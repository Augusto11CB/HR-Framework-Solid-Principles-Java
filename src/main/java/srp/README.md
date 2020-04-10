# Single Responsibility Principle
The single responsibility principle states that a class should have a single reason to change.

* Classes should be highly coupled internally.
* A change to a specific area of the class should affect all dependent classes.

Now, while intuitively this might sound like a bad thing, it is actually a driving force towards “cutting” our classes to small pieces based on their functional responsibility in our system. Doing so allows us to isolate a specific “area of change” in our software, according to the dependencies of the class being changed. 

## Illustration

### Disrespecting the principle os Single Responsability
```
 // This method has several responsibilities
    // Responsibility: Save an employee is not a function of a domain class as Employee.
        // It should be implemented in a second component that is responsible for handle persistence
    public static void save(Employee employee){
        // Responsibility: Exception handling
        try {
            // Responsibility: Serialization
            StringBuilder sb = new StringBuilder();
            sb.append("### EMPLOYEE RECORD ####");
            sb.append(System.lineSeparator());
            sb.append("NAME: ");
            sb.append(employee.firstName + " " + employee.lastName);
            sb.append(System.lineSeparator());
            sb.append("POSITION: ");
            sb.append(employee.getClass().getTypeName());
            sb.append(System.lineSeparator());
            sb.append("EMAIL: ");
            sb.append(employee.getEmail());
            sb.append(System.lineSeparator());
            sb.append("MONTHLY WAGE: ");
            sb.append(employee.monthlyIncome);
            sb.append(System.lineSeparator());

            //Responsibility: File Access
            Path path = Paths.get(employee.getFullName()
                    .replace(" ","_") + ".rec");
            Files.write(path, sb.toString().getBytes());

            // Responsibility: Logging
            System.out.println("Saved employee " + employee.toString());
        } catch (IOException e){
            // Responsibility: Logging
            System.out.println("ERROR: Could not save employee. " + e);
        }
    }

```
### Refactoring

Responsibility: Save an employee -> Move the save method from the domain entity to a repository component

Responsibility: Serialization -> Move the responsibility to perform serialization from the save method to a special serializer component
 
    EmployeeFileSerializer.java

Responsibility: Logging -> Move logging for a specific component responsible only for perform logging operation
    
    ConsoleLogger.java

Responsibility: Exception handling -> Address the responsibility for handling exception for the caller of function

    SaveEmployeesMain.java

