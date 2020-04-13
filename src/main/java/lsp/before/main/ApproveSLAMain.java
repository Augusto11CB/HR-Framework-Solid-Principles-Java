package lsp.before.main;


import lsp.before.logging.ConsoleLogger;
import lsp.before.persistence.EmployeeFileSerializer;
import lsp.before.persistence.EmployeeRepository;
import lsp.before.personnel.Employee;
import lsp.before.personnel.ServiceLicenseAgreement;
import lsp.before.personnel.Subcontractor;

import java.util.Arrays;
import java.util.List;

public class ApproveSLAMain {

////    [aug-lsp]
//    public static void main(String[] args) {
//        // Create dependencies
//        ConsoleLogger consoleLogger = new ConsoleLogger();
//        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
//        EmployeeRepository repository = new EmployeeRepository(employeeFileSerializer);
//
//        // Define SLA
//        int minTimeOffPercent = 98;
//        int maxResolutionDays = 2;
//        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
//                minTimeOffPercent,
//                maxResolutionDays);
//
//        // Grab subcontractors
//        List<Employee> subcontractors = repository.findAll();
//
//        for (Employee e : subcontractors){
//            if(e instanceof  Subcontractor){
//                // [aug-lsp] It is not adhering the lsp principle, because for a specific type of employee some extra action must run
//                Subcontractor s = (Subcontractor)e;
//                s.approveSLA(companySla);
//            }
//        }
//    }


    public static void main(String[] args) {
        // Define SLA
        int minTimeOffPercent = 98;
        int maxResolutionDays = 2;
        ServiceLicenseAgreement companySla = new ServiceLicenseAgreement(
                minTimeOffPercent,
                maxResolutionDays);

        // Get collaborators from their own source
        Subcontractor subcontractor1 = new Subcontractor(
                "Rebekah Jackson",
                "rebekah-jackson@abc.com",
                3000,
                15);
        Subcontractor subcontractor2 = new Subcontractor(
                "Harry Fitz",
                "harryfitz@def.com",
                3000, 15);
        List<Subcontractor> collaborators = Arrays.asList(subcontractor1, subcontractor2);

        // Check SLA
        for (Subcontractor s : collaborators) {
            s.approveSLA(companySla);
        }
    }
}
