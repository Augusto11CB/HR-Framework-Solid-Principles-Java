package srp.before.persistence;

import srp.before.personnel.Employee;
import srp.before.personnel.FullTimeEmployee;
import srp.before.personnel.PartTimeEmployee;

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

    public List<Employee> findAll(){

        // Employees are kept in memory for simplicity
        Employee anna = new FullTimeEmployee("Anna Smith", 2000);
        Employee billy = new FullTimeEmployee("Billy Leech", 920);

        Employee steve = new PartTimeEmployee("Steve Jones", 800);
        Employee magda = new PartTimeEmployee("Magda Iovan", 920);

        return Arrays.asList(anna, billy, steve, magda);
    }


}
