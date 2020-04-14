package dip.refactored.persistence;


import dip.refactored.personnel.Employee;
import dip.refactored.personnel.FullTimeEmployee;
import dip.refactored.personnel.Intern;
import dip.refactored.personnel.PartTimeEmployee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
Helper method to perform CRUD operations on employees. In a production
application we could use the database for persistence. In this demo,
we are storing employees in the file system.
 */

//[aug-dip] generic interface
public interface EmployeeRepository {
    List<Employee> findAll();
    void save(Employee employee) throws IOException;
}