package srp.refactored.persistence;

import srp.refactored.personnel.Employee;
import srp.refactored.personnel.FullTimeEmployee;
import srp.refactored.personnel.PartTimeEmployee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
Helper method to perform CRUD operations on employees. In a production
application a database could be used for persistence.
 */

public class EmployeeRepository {

    private EmployeeFileSerializer serializer;

    public EmployeeRepository(EmployeeFileSerializer serializer) {
        // By using injection, EmployeeRepository does not need to concern about the creation of the serializer.
        this.serializer = serializer;
    }

    public List<Employee> findAll() {

        // Employees are kept in memory for simplicity
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);
    }

//    Responsibility Refactored: Save an employee
    public void save(Employee employee) throws IOException {

        String serializedEmployee = this.serializer.serialize(employee);

        //Responsibility Refactored: File Access
        Path path = Paths.get(employee.getFullName()
                .replace(" ", "_") + ".rec");
        Files.write(path, serializedEmployee.toString().getBytes());
    }

}
